package com.sana.Common;


import com.sana.Interface.IconBetterIdeaService;
import com.sana.Interface.NewsService;
import com.sana.Remote.IconBetterIdeaClient;
import com.sana.Remote.RetrofitClient;

public class Common {
    private static final String BASE_URL="https://newsapi.org/";

    public static final String API_KEY="64eaf6514c554f73b733c7394acf3af8";

    public static NewsService getNewsService()
    {
        return RetrofitClient.getClient(BASE_URL).create(NewsService.class);
    }

    public static IconBetterIdeaService getIconService()
    {
        return IconBetterIdeaClient.getClient().create(IconBetterIdeaService.class);
    }

    //https://newsapi.org/v2/everything?q=bitcoin&from=2019-08-19&sortBy=publishedAt&apiKey=64eaf6514c554f73b733c7394acf3af8
    public static String getAPIUrl(String source, String sortBy,String apiKEY)
    {
        StringBuilder apiUrl = new StringBuilder("https://newsapi.org/v2/top-headlines?sources=");
        return apiUrl.append(source)
                .append("&apiKey=")
                .append(apiKEY)
                .toString();
    }
}
