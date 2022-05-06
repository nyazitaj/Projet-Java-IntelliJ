package com.edu.mns.control.dfs.dfsrcontrol.controller;

import com.edu.mns.control.dfs.dfsrcontrol.dao.CommandeDao;
import com.edu.mns.control.dfs.dfsrcontrol.dao.UtilisateurDao;
import com.edu.mns.control.dfs.dfsrcontrol.model.Commande;
import com.edu.mns.control.dfs.dfsrcontrol.view.AffichageCommande;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CommandeController {

    CommandeDao commandeDao;



    @Autowired
    public CommandeController(CommandeDao commandeDao) {

        this.commandeDao = commandeDao;

    }

    // Orders list
    @GetMapping("/liste-commande")
    @JsonView(AffichageCommande.class)
    public List<Commande> commandes() {

        return this.commandeDao.findAll();

    }

}
