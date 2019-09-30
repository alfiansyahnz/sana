package com.sana.Interface;



import com.sana.Common.Common;
import com.sana.models.News;
import com.sana.models.WebSite;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface NewsService {
    @GET("v2/sources?language=en&apiKey="+ Common.API_KEY)
    public Call<WebSite> getSources();

    @GET
    Call<News> getNewsestArticles(@Url String url);

    public void getNewestArticles();

    public void getNewestArticles(String apiUrl);
}
