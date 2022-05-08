package com.edu.mns.control.dfs.dfsrcontrol.dao;

import com.edu.mns.control.dfs.dfsrcontrol.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDao  extends JpaRepository<Article, Integer> {

    @Query("SELECT COUNT(L.quantite) FROM LigneCommande L")
    Integer article();
}
