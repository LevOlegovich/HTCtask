package com.nlv2022.htc.data.http;

import com.nlv2022.htc.data.network.RootEntityDto;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface ApiService {

    @GET("./5ddcd3673400005800eae483")
    Observable<RootEntityDto> getRootEntity();


}
