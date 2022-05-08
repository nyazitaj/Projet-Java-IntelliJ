package com.edu.mns.control.dfs.dfsrcontrol.dao;

import com.edu.mns.control.dfs.dfsrcontrol.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Integer> {

    @Query("SELECT new map(C.id as id, U.login As login, LC.quantite As quantite, A.prix As prix) FROM Commande C INNER JOIN Utilisateur U ON U.id=C.client_id INNER JOIN LigneCommande LC ON C.id=LC.commande_id INNER JOIN Article A ON LC.article_id=A.id")
    List<Object> commandes();

}
