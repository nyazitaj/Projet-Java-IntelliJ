package com.edu.mns.control.dfs.dfsrcontrol.controller;

import com.edu.mns.control.dfs.dfsrcontrol.dao.ArticleDao;
import com.edu.mns.control.dfs.dfsrcontrol.dao.UtilisateurDao;
import com.edu.mns.control.dfs.dfsrcontrol.model.Article;
import com.edu.mns.control.dfs.dfsrcontrol.view.AffichageArticle;
import com.edu.mns.control.dfs.dfsrcontrol.view.AffichageUtilisateur;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ArticleController {

    ArticleDao articleDao;

    @Autowired
    public ArticleController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    // Add new article
    @PostMapping("/article")
    @JsonView(AffichageArticle.class)
    public String ajouterArticle(@RequestBody Article article) {

        this.articleDao.save(article);

        return "Ok";

    }
}
