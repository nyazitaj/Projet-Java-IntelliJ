package com.edu.mns.control.dfs.dfsrcontrol.dao;

import com.edu.mns.control.dfs.dfsrcontrol.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer> {

    @Query("SELECT COUNT(*) FROM Utilisateur")
    Integer compteUtilisateur();

    // @Query("DELETE FROM Utilisateur U INNER JOIN Employe E ON E.id != U.id WHERE U.id=:id")
    @Query("DELETE FROM Utilisateur U WHERE NOT U.id IN (FROM Employe E WHERE E.id=:id) AND U.id=:id")
    String supprimeUtilisateur(Integer id);

}
