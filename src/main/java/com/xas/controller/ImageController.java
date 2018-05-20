package com.xas.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.query.QueryLookupStrategy.Key;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.cloud.Role;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Acl.User;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.Storage.BucketField;
import com.google.cloud.storage.Storage.BucketGetOption;
import com.google.cloud.storage.Storage.PredefinedAcl;
import com.vision.storage.StorageAuthentication;
import com.xas.common.service.ApplicationConfiguration;
import com.xas.common.service.ElasticService;
import com.xas.common.service.LoadUserProfile;
import com.xas.common.service.StorageService;

@Controller
@RequestMapping(value="/image")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class ImageController {
	@Autowired
	LoadUserProfile loadUserProfile;
	
	@Autowired
	StorageService storageService;
	

	
	@Autowired
	ApplicationConfiguration appConfig;
	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces="text/plain")
	    public String handleFileUpload(MultipartHttpServletRequest req,
	            RedirectAttributes redirectAttributes,HttpServletRequest request) throws FileNotFoundException, IOException, InterruptedException, ExecutionException, URISyntaxException {
		
		 String bucketName = "visionbucket02";
		 String userGuid=loadUserProfile.loadUserProfile(request.getSession().getAttribute(appConfig.returnUserEmailFromSession()).toString(),true).getUser().getUserGuid();
		 Storage storage=StorageAuthentication.execute();
		 Iterator<String> it=req.getFileNames();
		 MultipartFile mpf=null;
		 while (it.hasNext()) {
			mpf=req.getFile(it.next());
			System.out.println(mpf.getOriginalFilename());
		}
		 BlobInfo bli =BlobInfo.
				 newBuilder(storage.get(bucketName, BucketGetOption.fields(BucketField.SELF_LINK))
							 ,mpf.getOriginalFilename()).
					 setContentType(mpf.getContentType()).
					 setBlobId(BlobId.of(bucketName, userGuid+"/"+mpf.getOriginalFilename()))
					 .build();
		 String imageUrl=storage.create(bli, mpf.getBytes(),BlobTargetOption.predefinedAcl(PredefinedAcl.PUBLIC_READ)).getMediaLink();
		 storageService.asyncTextFinder(imageUrl,userGuid+"/"+mpf.getOriginalFilename());
		

	     redirectAttributes.addFlashAttribute("message",
	                "You successfully uploaded " + mpf.getOriginalFilename() + "!");
	        return "redirect:/";
	    }
}
