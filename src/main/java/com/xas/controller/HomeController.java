package com.xas.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;

import static org.elasticsearch.common.xcontent.XContentFactory.*;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.mail.URLName;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.util.EntityUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.support.FormatterPropertyEditorAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.json.Json;
import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Blob.BlobSourceOption;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.HttpMethod;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobListOption;
import com.google.cloud.storage.Storage.BucketField;
import com.google.cloud.storage.Storage.BucketGetOption;
import com.google.cloud.storage.Storage.SignUrlOption;
import com.google.cloud.storage.StorageOptions;
import com.google.gson.JsonDeserializer;
import com.vision.model.*;
import com.vision.storage.StorageAuthentication;
import com.xas.common.daoImpl.GVisionDaoImpl;
import com.xas.common.model.UserProfile;
import com.xas.common.service.ApplicationConfiguration;
import com.xas.common.service.ElasticService;
import com.xas.common.service.LoadUserProfile;
import com.xas.common.service.UserService;

@Controller
@RequestMapping(value="/home")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class HomeController extends AbstractController {
	
	@Autowired
	ApplicationConfiguration appConfig;
	
	@Autowired
	UserService userService;

	
	 boolean flag=true;
	@Autowired
	LoadUserProfile loadUserProfile;
	
	

	@Autowired(required=true)
	ElasticService elasticService;
	
	 @RequestMapping(value = "", method = RequestMethod.GET)
	public String getHome(HttpServletRequest request,HttpSession session,ModelMap model) throws IOException {
		 UserProfile upf=loadUserProfile.loadUserProfile(request.getSession().getAttribute(appConfig.returnUserEmailFromSession()).toString(),true);
		upf.getUser();
		
		try {
		Storage storage=StorageAuthentication.execute();
		//Bucket bucket=storage.create(BucketInfo.of("visionbucket03"));
		Bucket bucket=storage.get("visionbucket02", BucketGetOption.fields(BucketField.SELF_LINK));
		System.out.println(bucket.getName());
		long start=System.currentTimeMillis();
		String bucketName = "visionbucket02";
	    String userGuid = upf.getUser().getUserGuid();		 
		Page<Blob> blobIterator = storage.list(bucketName, BlobListOption.currentDirectory(),
		     BlobListOption.prefix(userGuid+"/"));
		List<String> ax=new ArrayList<String>();
		 for (Blob item : blobIterator.iterateAll()) {	 
			 ax.add(item.signUrl(30, TimeUnit.SECONDS,SignUrlOption.httpMethod(HttpMethod.GET)).toString());			
		}
		 if (flag) {
			 model.addAttribute("imgUrl", ax);
			 System.out.println("girdi");
		}
			flag=false;
			long end=System.currentTimeMillis();
			System.out.println((end-start));

		} catch (Exception e) {

			System.out.println(e);
			
		}		
		model.addAttribute("userCategories", upf.getUserCategories());
		 return  "home" ;

	 }
	 @ResponseBody
	@RequestMapping(value="filter",method=RequestMethod.POST,consumes ="application/json", produces = "text/plain")
	 public  ModelAndView filterImages(@RequestBody SearchModel params,HttpServletRequest request,ModelMap model) throws FileNotFoundException, IOException, URISyntaxException {
		// System.out.println("furkan");
		 System.out.println(params.getDesc());
		 SearchModel s=new SearchModel();
		 UserProfile upf=loadUserProfile.loadUserProfile(request.getSession().getAttribute(appConfig.returnUserEmailFromSession()).toString(),true);
		 String userGuid = upf.getUser().getUserGuid();
		 SearchResponse s1= elasticService.getDocument(params, userGuid);
		 List<String> ax=new ArrayList<String>();
	//	 System.out.println(s1.status());
		 
		 SearchHits hits = s1.getHits();
	     System.out.println(hits.totalHits);
	//	 System.out.println(userGuid);
	/*	 Storage storage=StorageAuthentication.execute();
		 Page<Blob> blobIterator = storage.list("visionbucket02", BlobListOption.currentDirectory(),BlobListOption.prefix(userGuid+"/"));
		 for (SearchHit hit : hits) {
			 for (Blob item : blobIterator.iterateAll()) {	
			String temp=userGuid+"/"+hit.getId();
				 if (item.getName().equalsIgnoreCase(temp)) {
					 ax.add(item.signUrl(30, TimeUnit.SECONDS,SignUrlOption.httpMethod(HttpMethod.GET)).toString());
				}
			}
		}*/
	     for (SearchHit hit : hits) {
	    	 	Map map=hit.getSourceAsMap();
	    	 	ax.add(map.get("imageBaseUrl").toString());
			}
		 model.addAttribute("imgUrl", ax);		
		 return new ModelAndView("/home");
	 }
	 
	 
	 
	 
	 
	 @RequestMapping(value = "/logout", method = RequestMethod.GET)
	 public String logout(HttpServletRequest request) {
		 System.out.println("logout");
		 request.getSession().invalidate(); // end session
		 
		 return "redirect:/";
	 }
	 
	 
	 

	@Override
	public String checkSession() {

		return null;
	}

		

}
