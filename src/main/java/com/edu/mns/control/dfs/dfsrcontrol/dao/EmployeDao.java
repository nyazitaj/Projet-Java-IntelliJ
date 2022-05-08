package com.edu.mns.control.dfs.dfsrcontrol.dao;

import com.edu.mns.control.dfs.dfsrcontrol.model.Article;
import com.edu.mns.control.dfs.dfsrcontrol.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface EmployeDao  extends JpaRepository<Employe, Integer> {

    @Query("SELECT new map(U.login AS login) FROM Utilisateur U INNER JOIN Employe E ON U.id=E.id WHERE E.id=:id")
    HashMap<String, Object> getEmploye(Integer id);


    @Query("SELECT new map(A.nom AS nom) FROM Article A INNER JOIN Employe E ON A.gestionnaire_id=E.id WHERE E.id=:id")
    List<Object>  listeArticle(Integer id);


    @Query("SELECT new map(U.id AS id, U.login AS login, E.administrateur AS administrateur) FROM Utilisateur U INNER JOIN Employe E ON U.id=E.id")
    List<Object> listeEmploye();


    @Query("SELECT COUNT(E.administrateur) FROM Employe E WHERE E.administrateur = 1")
    Integer compteAdministrator();
    
}
