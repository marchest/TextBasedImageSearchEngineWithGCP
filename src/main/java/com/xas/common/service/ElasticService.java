package com.xas.common.service;

import java.io.IOException;
import java.net.UnknownHostException;

import org.apache.http.HttpEntity;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Response;

import com.google.api.client.http.HttpMethods;
import com.vision.model.SearchModel;
import com.xas.common.model.EsIndexModel;

public interface ElasticService {
	
	public IndexResponse indexDocument(EsIndexModel entity,String index) throws UnknownHostException, IOException;
	
	
	public SearchResponse getDocument(SearchModel searchModel, String index);
	

}
