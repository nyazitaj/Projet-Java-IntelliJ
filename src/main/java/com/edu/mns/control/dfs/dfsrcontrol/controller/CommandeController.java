package com.edu.mns.control.dfs.dfsrcontrol.controller;

import com.edu.mns.control.dfs.dfsrcontrol.dao.CommandeDao;
import com.edu.mns.control.dfs.dfsrcontrol.dao.UtilisateurDao;
import com.edu.mns.control.dfs.dfsrcontrol.view.AffichageCommande;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class CommandeController {

    CommandeDao commandeDao;
    UtilisateurDao utilisateurDao;

    List<Object> commandeList = new ArrayList<>();

    HashMap<String, Object> commandeHashMap = new HashMap<>();

    HashMap<String, Object> commandeArticlePrix = new HashMap<>();
    HashMap<String, Integer> commandePrix = new HashMap<>();
    List<Object> listeLigneCommande = new ArrayList<>();
    HashMap<String, Object> articlePrix = new HashMap<>();

    HashMap<String, String> login = new HashMap<>();

    HashMap<String, Object> listeLigneCommandeElem = new HashMap<>();
    Integer i = 0;

    @Autowired
    public CommandeController(CommandeDao commandeDao, UtilisateurDao utilisateurDao) {

        this.commandeDao = commandeDao;
        this.utilisateurDao = utilisateurDao;

    }

    // Orders list
    @GetMapping("/liste-commande")
    @JsonView(AffichageCommande.class)
    public List<Object> commandes() {

        this.commandeList.clear();
        this.listeLigneCommande.clear();
        this.commandeHashMap.clear();

        for(Object param: this.commandeDao.commandes()) {

            this.commandeArticlePrix.put("quantite", 4);
            this.commandePrix.put("prix", 10);
            this.commandeArticlePrix.put("article", this.commandePrix);
            this.commandeHashMap.put("listeLigneCommande", this.commandeArticlePrix);

            this.login.put("login", "admin");
            this.commandeHashMap.put("client", this.login);
            this.commandeList.add(param);

            this.i ++;

        }

        return this.commandeList;

    }

}
