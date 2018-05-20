package com.xas.common.dao;

import com.vision.model.Request;
import com.vision.model.RootRequest;
import com.vision.model.RootTextDetectionResponse;
import com.vision.model.TextDetectionResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface GVisionDao {
	
	
	@POST("/v1/images:annotate")
	Call<RootTextDetectionResponse> detectText(@Body RootRequest request);
}
