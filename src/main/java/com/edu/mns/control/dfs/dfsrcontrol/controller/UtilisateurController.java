package com.edu.mns.control.dfs.dfsrcontrol.controller;

import com.edu.mns.control.dfs.dfsrcontrol.dao.CommandeDao;
import com.edu.mns.control.dfs.dfsrcontrol.dao.UtilisateurDao;
import com.edu.mns.control.dfs.dfsrcontrol.model.Commande;
import com.edu.mns.control.dfs.dfsrcontrol.model.Utilisateur;
import com.edu.mns.control.dfs.dfsrcontrol.view.AffichageUtilisateur;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UtilisateurController {
    UtilisateurDao utilisateurDao;

    @Autowired
    public UtilisateurController(UtilisateurDao utilisateurDao) {

        this.utilisateurDao = utilisateurDao;

    }

    // Total Users
    @GetMapping("/compte-utilisateur")
    @JsonView(AffichageUtilisateur.class)
    public Integer compteUtilisateur() {

        return utilisateurDao.compteUtilisateur();

    }

    // Total administrator
    @GetMapping("/compte-administrateur")
    @JsonView(AffichageUtilisateur.class)
    public Integer compteAdministrator() {

        return utilisateurDao.compteAdministrator();

    }


    // Delete a user
    @DeleteMapping("/utilisateur/{id}")
    @JsonView(AffichageUtilisateur.class)
    public String supprimeUtilisateur( @PathVariable int id ) {

        utilisateurDao.deleteById(id);
        return "Supprimé";

    }
}
