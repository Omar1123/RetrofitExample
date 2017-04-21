package com.retrofit.requiliem.retrofitexample.EndPoint;

import com.retrofit.requiliem.retrofitexample.models.Student;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by OmarV on 21/04/2017.
 */

public interface RetrofitObjectAPI {

    @GET("api/RetrofitAndroidObjectResponse")
    Call<Student> getStudentDetails();
}
