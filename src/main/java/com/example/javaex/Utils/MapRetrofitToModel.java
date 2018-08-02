package com.example.javaex.Utils;

import com.example.javaex.DAO.ItemService;
import com.example.javaex.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import retrofit2.Response;

import javax.ws.rs.NotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class MapRetrofitToModel {

    @Autowired
    ItemService itemService;

    public Item returnArticle (Long id) {
        try {
            Response response = itemService.getArticle(id.toString()).execute();
            return (Article)response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Article article = Optional.ofNullable(mapRetrofitToModel.returnArticle(id)).orElseThrow(NotFoundException::new);
        return mapArticleToItem(article);
    }

    public List<Article> returnArticles () {
        try {
            Response response = itemService.getArticles().execute();
            return (List<Article>)response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Item mapArticleToItem(Article article){

    };
}
