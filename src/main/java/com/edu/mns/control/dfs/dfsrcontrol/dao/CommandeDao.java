package com.edu.mns.control.dfs.dfsrcontrol.dao;

import com.edu.mns.control.dfs.dfsrcontrol.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Integer> {

    @Query("FROM Commande C WHERE C.id < 3")
    List<Commande> listeCommande();

}
