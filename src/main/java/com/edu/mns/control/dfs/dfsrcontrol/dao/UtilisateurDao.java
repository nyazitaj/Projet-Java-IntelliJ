package com.edu.mns.control.dfs.dfsrcontrol.dao;

import com.edu.mns.control.dfs.dfsrcontrol.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer> {

    @Query("SELECT COUNT(*) FROM Utilisateur")
    Integer compteUtilisateur();


    @Query("SELECT COUNT(E.administrateur) FROM Employe E WHERE E.administrateur = 1")
    Integer compteAdministrator();

}
