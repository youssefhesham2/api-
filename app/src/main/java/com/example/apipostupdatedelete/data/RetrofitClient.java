package com.example.apipostupdatedelete.data;

import com.example.apipostupdatedelete.Models.EmpolyeeModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Path;

public class RetrofitClient {
   static RetrofitClient retrofitClient;
   static final String base_URL="http://dummy.restapiexample.com/";
   public EmpolyeeHolder empolyeeHolder;

    private RetrofitClient() {
        Retrofit retrofit=new Retrofit.Builder().baseUrl(base_URL).addConverterFactory(GsonConverterFactory.create()).build();
        empolyeeHolder=retrofit.create(EmpolyeeHolder.class);
    }


    static public RetrofitClient RetrofitInstance(){
        if (retrofitClient==null)
        {
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
   }

    public Call<EmpolyeeModel> get(){
        return empolyeeHolder.getapi();
   }

   public Call<EmpolyeeModel.data> post(EmpolyeeModel.data model)
   {
       return empolyeeHolder.post(model);

   }

    public Call<EmpolyeeModel.data> post2(String name,String salary,String age,String img)
    {
        return empolyeeHolder.poost2(name,salary,age,img);

    }
    public Call<EmpolyeeModel.data> post3(HashMap<Object,Object> map)
    {

        return empolyeeHolder.poost3(map);

    }
    public Call<EmpolyeeModel.data> put(int id,EmpolyeeModel.data model)
    {

        return empolyeeHolder.put(id,model);


    }

}
