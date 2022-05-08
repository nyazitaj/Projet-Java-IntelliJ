package com.edu.mns.control.dfs.dfsrcontrol.dao;

import com.edu.mns.control.dfs.dfsrcontrol.model.Commande;
import com.edu.mns.control.dfs.dfsrcontrol.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Integer> {
    
//    @Query("SELECT U.login, C.date_paiement, COUNT(LC.quantite) FROM ((Utilisateur U INNER JOIN Commande C ON U.id=C.client_id) INNER JOIN LigneCommande LC ON C.id=LC.commande_id)")
//    List<Object> commande();

//    @Query("SELECT COUNT(L.quantite) FROM LigneCommande L")
//    Integer quantityCommande();
//
//    @Query("SELECT U.login FROM Utilisateur Utilisateur U ON U.id")
//    List<Object> utilisateurLogin();

    // @Query("SELECT U.login As login, SUM(LC.quantite) As quantite FROM Commande C INNER JOIN Utilisateur U ON U.id=C.client_id INNER JOIN LigneCommande LC ON C.id=LC.commande_id")
    @Query("SELECT new map(C.id as id, U.login As login, LC.quantite As quantite, A.prix As prix) FROM Commande C INNER JOIN Utilisateur U ON U.id=C.client_id INNER JOIN LigneCommande LC ON C.id=LC.commande_id INNER JOIN Article A ON LC.article_id=A.id")
    List<Object> commandes();

}
