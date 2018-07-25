package com.example.javaex.DAO;

import com.example.javaex.model.Article;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface ItemService {

    @GET("/articles")
    public Call<List<Article>> getArticles();

    @GET("/articles/{articleId}")
    public Call<Article> getArticle(@Path("articleId") String articleId);
}
