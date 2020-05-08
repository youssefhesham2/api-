package com.example.apipostupdatedelete.data;

import com.example.apipostupdatedelete.Models.EmpolyeeModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EmpolyeeHolder {

    @GET("api/v1/employees")
    Call<EmpolyeeModel> getapi();

    @POST("api/v1/create")
    Call<EmpolyeeModel.data> post(@Body EmpolyeeModel.data empolyeeModel);

    @FormUrlEncoded
    @POST("api/v1/create")
    Call<EmpolyeeModel.data> poost2(@Field("employee_name") String name,@Field("employee_salary") String salary,@Field("employee_age") String age,@Field("profile_image") String imag);

    @POST("api/v1/create")
    Call<EmpolyeeModel.data> poost3(@Body HashMap<Object,Object> map);
    @PUT("api/v1/update/{id}")
    Call<EmpolyeeModel.data> put(@Path("id") int id, @Body EmpolyeeModel.data empolyeeModel);


}
