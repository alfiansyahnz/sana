package com.sana.Remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IconBetterIdeaClient {
    private static Retrofit retrofit=null;
    public static Retrofit getClient(){
        if(retrofit==null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl("icons.better-idea.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
