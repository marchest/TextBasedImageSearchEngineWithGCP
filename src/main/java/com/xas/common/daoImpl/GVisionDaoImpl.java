package com.xas.common.daoImpl;

import java.io.IOException;

import org.springframework.stereotype.Repository;

import com.vision.model.Request;
import com.vision.model.RootRequest;
import com.vision.model.RootTextDetectionResponse;
import com.vision.model.TextDetectionResponse;
import com.vision.model.LabelDetectionResponse;
import com.xas.common.AppUtils.Constants;
import com.xas.common.dao.GVisionDao;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Interceptor.Chain;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;

public class GVisionDaoImpl {
	
	public static retrofit2.Response<RootTextDetectionResponse> detectText(@Body RootRequest request) throws IOException {
		
		
			OkHttpClient client=new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
			
			public okhttp3.Response intercept(Chain chain) throws IOException {
		
			okhttp3.Request original=chain.request();
			
			HttpUrl httpUrl=original.url();
			HttpUrl newhttpUrl=httpUrl.newBuilder().addQueryParameter("key", Constants.API_KEY).build();
			okhttp3.Request.Builder requestBuilder=original.newBuilder().header("Accept", "application/json").url(newhttpUrl);
			okhttp3.Request request=requestBuilder.build();
		//	System.out.println("Request Url-> "+request.url().toString());
			return chain.proceed(request);
			}
		}).build();
		Retrofit retrofit=new Retrofit.Builder().baseUrl(Constants.G_VISION_ENDPOINT).client(client)
				.addConverterFactory(GsonConverterFactory.create()).build();
		
		GVisionDao gVisionDao=retrofit.create(GVisionDao.class);
		
		
		retrofit2.Response<RootTextDetectionResponse>response=gVisionDao.detectText(request).execute();
			
		return response;
		
	}
}
