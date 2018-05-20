package com.vision.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;


public class StorageAuthentication {
	
	public static Storage execute() throws FileNotFoundException, IOException, URISyntaxException {

		/*
		Storage storage = StorageOptions.newBuilder()
			    .setCredentials(ServiceAccountCredentials.fromStream(
			    		new FileInputStream("C:\\Users\\marchest\\Downloads\\testdata\\teb\\GvisionApiProject-610c42265abd.json")))
			    .build()
			    .getService();*/
	//	System.out.println(resource.getURL().getPath());
		Storage storage = StorageOptions.newBuilder()
			    .setCredentials(ServiceAccountCredentials.fromStream(
			    		new FileInputStream(StorageAuthentication.class.getResource("/StorageAuth.json").getPath())))
			    .build()
			    .getService();
		return storage;
	}
}
