package com.edu.mns.control.dfs.dfsrcontrol.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @JsonView(AffichageUtilisateur.class)
    private Integer id;
    // @JsonView(AffichageUtilisateur.class)
    private String nom;
    private  String prix;
    private  String gestionnaire_id;
}
