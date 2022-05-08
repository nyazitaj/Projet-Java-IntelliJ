package com.edu.mns.control.dfs.dfsrcontrol.controller;

import com.edu.mns.control.dfs.dfsrcontrol.dao.EmployeDao;
import com.edu.mns.control.dfs.dfsrcontrol.view.AffichageEmploye;
import com.edu.mns.control.dfs.dfsrcontrol.view.AffichageUtilisateur;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.OptBoolean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class EmployeController {

    EmployeDao employeDao;
    HashMap<String, Object> employeHashMap = new HashMap<>();

    @Autowired
    public EmployeController(EmployeDao employeDao) {

        this.employeDao = employeDao;

    }

    // Get employe by id and display its article list
    @GetMapping("/employe/{id}")
    @JsonView(AffichageEmploye.class)
    public HashMap<String, Object> employe(@PathVariable int id) {

        this.employeHashMap.clear();

        this.employeHashMap = this.employeDao.getEmploye(id);
        this.employeHashMap.put("listeArticleAgerer",this.employeDao.listeArticle(id) );

        return this.employeHashMap;
    }

    // List employe
    @GetMapping("/liste-employe")
    @JsonView(AffichageEmploye.class)
    public List<Object> listeEmploye() {
        return this.employeDao.listeEmploye();
    }

    // Total administrators
    @GetMapping("/compte-administrateur")
    @JsonView(AffichageEmploye.class)
    public Integer compteAdministrator() {

        return employeDao.compteAdministrator();

    }
}
