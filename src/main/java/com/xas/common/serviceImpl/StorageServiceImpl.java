package com.xas.common.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;




import org.elasticsearch.action.index.IndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.vision.model.Feature;
import com.vision.model.Image;
import com.vision.model.Request;
import com.vision.model.RootRequest;
import com.vision.model.RootTextDetectionResponse;
import com.vision.model.Source;
import com.vision.model.TextDetectionResponse;
import com.xas.common.daoImpl.GVisionDaoImpl;
import com.xas.common.model.EsIndexModel;
import com.xas.common.service.ApplicationConfiguration;
import com.xas.common.service.ElasticService;
import com.xas.common.service.LoadUserProfile;
import com.xas.common.service.StorageService;
@Service
public class StorageServiceImpl implements StorageService{
	@Autowired
	ElasticService elasticService;

	@Autowired
	LoadUserProfile loadUserProfile;
	@Autowired
	ApplicationConfiguration appConfig;
	
	
	@Async
	@Override
	public void asyncTextFinder(String imageUrl,String imageToIndex)throws  IOException {
		try {
			List<Request> r=new ArrayList<Request>();
			Request req=new Request();
			Feature f=new Feature();
			f.setType("TEXT_DETECTION");
			List<Feature> f2=new ArrayList<Feature>();
			f2.add(f);
			req.setFeatures(f2);
			r.add(req);
			Image i=new Image();
			Source s=new Source();
			s.setImageUri(imageUrl); // https://storage.googleapis.com/visionbucket01/404page.jpg
			i.setSource(s);
			req.setImage(i);
		//	ObjectMapper mapper=new ObjectMapper();
			RootRequest rr=new RootRequest();
			rr.setRequests(r);		
			//String x=mapper.writeValueAsString(rr); // Test için
			//System.out.println("Request is "+x);
		retrofit2.Response<RootTextDetectionResponse> res= GVisionDaoImpl.detectText(rr);

			System.out.println("xasdasdasdas");
			StringBuilder textContent=new StringBuilder();
			for (TextDetectionResponse item : res.body().getResponses()) {
				textContent.append(item.getTextAnnotations().get(0).getDescription());
			//	System.out.println(item.getTextAnnotations().get(0).getDescription());
			}
			
			/*Map<String,Object> jsonMap=new HashMap<>();
			jsonMap.put("user", imageToIndex.split("/")[0]);
			jsonMap.put("date", new Date());
			jsonMap.put("description",textContent.toString().replaceAll("\n", ""));*/
			EsIndexModel d=new EsIndexModel();
		d.date=new Date();
		d.setImageUrl(imageUrl);
		d.user= imageToIndex.split("/")[0]; //userGuid
		d.setImageName(imageToIndex.split("/")[1]);
		//description=textContent.toString().replaceAll("\n", "");
		d.setDescription(textContent.toString());
		
	//		String jsonTextContent=mapper.writeValueAsString(d);
			
		
	//		HttpEntity entity=new NStringEntity(jsonTextContent,ContentType.APPLICATION_JSON);
		
			//System.out.println(jsonTextContent);
	        IndexResponse asd=elasticService.indexDocument(d,imageToIndex);
	        System.out.println("----------------------------------");
	        System.out.println(asd.getIndex());
		//	 System.out.println(EntityUtils.toString(asd.getEntity()));
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	

	
		
	}
	
}
