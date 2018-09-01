package com.clue.raldeskrisnu.clue.network;

import com.clue.raldeskrisnu.clue.models.ResultApi;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface NetworkInterface {

    @Headers("token: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoicWx1ZWluIiwiaWF0IjoxNDk0Mzk5Njg1fQ.mG5wmoCwmchufTPloxI7AjZaeM_bwcpCEJpyUnCDrmk" )
    @GET("example/top_report")
    Observable<List<ResultApi>> getAllData();

}
