package com.xas.common.serviceImpl;

import java.io.IOException;
import java.net.UnknownHostException;

import static org.elasticsearch.common.xcontent.XContentFactory.*;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.DocWriteResponse.Result;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vision.model.SearchModel;
import com.xas.common.model.EsIndexModel;
import com.xas.common.service.ESConfig;
import com.xas.common.service.ElasticService;

@Service
public class ElasticServiceImpl implements ElasticService {

	@Autowired 
	ESConfig esConfig;

	/*	@Override
	public Response indexDocument(HttpEntity entity, String index) throws IOException {
		//Response indexDoc=esConfig.myClient().performRequest(HttpMethods.POST, "/"+index.split("/")[0]+"/_image"+index.split("/")[1],  Collections.<String, String>emptyMap(), entity);
		Response indexDoc=esConfig.myClient().performRequest(HttpMethods.POST, "/"+index.split("/")[0]+"/image",  Collections.<String, String>emptyMap(), entity);
		if (indexDoc.getStatusLine().getStatusCode()==400) {
			 indexDoc=esConfig.myClient().performRequest(HttpMethods.PUT, "/"+index.split("/")[0]+"/image",  Collections.<String, String>emptyMap(), entity);
		}
		return indexDoc;													
	}*/



	@Override
	public IndexResponse indexDocument(EsIndexModel entity, String index) throws UnknownHostException, IOException {
		RestHighLevelClient client=esConfig.esClient();

		IndexResponse indexResponse = null;
		IndexRequest request=new IndexRequest(entity.getUser(),"image",entity.getImageName())
				.source(jsonBuilder()
						.startObject()
						.field("user",entity.user)
						.field("imageName",entity.getImageName())
						.field("date",entity.getDate())
						.field("description",entity.getDescription())
					    .field("imageBaseUrl",entity.getImageUrl()).endObject());

		try {
			indexResponse=client.index(request);
			if (indexResponse.getResult()== Result.CREATED) {
				System.out.println("Created");
			} 
			System.out.println("status "+indexResponse.status());
		} catch(ElasticsearchException e) {
			e.printStackTrace();
			if (e.status() == RestStatus.CONFLICT) {
			}
		}
		esConfig.closeEsClient(client);
		return indexResponse;													
	}


	@Override
	public SearchResponse getDocument(SearchModel searchModel, String index) {
		SearchResponse searchResponse =null;
		SearchRequest searchRequest=new SearchRequest(index);
		SearchSourceBuilder sourceBuilder=new SearchSourceBuilder();
		//sourceBuilder.query(QueryBuilders.matchQuery("description",word));

		switch (searchModel.getOperator()) {
		case "wildcard":
			sourceBuilder.query(QueryBuilders.wildcardQuery("description", searchModel.getDesc()));
			searchRequest.source(sourceBuilder);
			break;
		case "prefix":
			sourceBuilder.query(QueryBuilders.prefixQuery("description", searchModel.getDesc()));
			searchRequest.source(sourceBuilder);
			break;
		case "match":
			sourceBuilder.query(QueryBuilders.matchQuery("description", searchModel.getDesc()));
			searchRequest.source(sourceBuilder);
			break;
		case "regex":
			sourceBuilder.query(QueryBuilders.regexpQuery("description", searchModel.getDesc()));
			searchRequest.source(sourceBuilder);
			break;
		default:
			break;
		}

		try {
			searchResponse = esConfig.esClient().search(searchRequest);

			if (searchResponse.getHits().getTotalHits()==0) {
				System.out.println("hit bulunamadý");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return searchResponse;
	}






}
