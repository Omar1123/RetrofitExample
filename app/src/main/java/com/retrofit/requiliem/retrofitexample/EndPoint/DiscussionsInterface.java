package com.retrofit.requiliem.retrofitexample.EndPoint;

import com.retrofit.requiliem.retrofitexample.models.Discussion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by OmarV on 21/04/2017.
 */

public interface DiscussionsInterface {

    @GET("debates.json")
    Call<List<Discussion>> getDiscussions();
}
