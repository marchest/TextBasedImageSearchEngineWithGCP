package com.xas.common.service;


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Base64;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder.HttpClientConfigCallback;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Component;


@Component

public class ESConfig {
/*	@Value("${elasticsearch.host}")
	private String EsHost;

	@Value("${elasticsearch.port}")
	private int EsPort;

	@Value("${elasticsearch.clustername}")
	private String EsClusterName;*/
	//8bcGFf0ZAFcYdBM29S0lusZG
	private final String userName="userName";
	private final String password="password";
	private final String elasticUrl="elasticServerIP"; 

	
	public RestHighLevelClient esClient() {
		
	
		final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
		credentialsProvider.setCredentials(AuthScope.ANY,new UsernamePasswordCredentials(userName, password));
		
		RestHighLevelClient client = new RestHighLevelClient(
		        RestClient.builder(
		                new HttpHost(elasticUrl, 9200, "http"),
		                new HttpHost(elasticUrl, 9200, "http")).setHttpClientConfigCallback(new HttpClientConfigCallback() {
							
							@Override
							public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
								return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
								
							}
						}));
		

		return  client;
	}
	
	public void closeEsClient(final RestHighLevelClient client) {
		try {
			client.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	

}
