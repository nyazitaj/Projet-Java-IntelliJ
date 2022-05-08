package com.edu.mns.control.dfs.dfsrcontrol.model;

import com.edu.mns.control.dfs.dfsrcontrol.view.AffichageUtilisateur;
import com.fasterxml.jackson.annotation.JsonView;
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
    @JsonView(AffichageUtilisateur.class)
    private Integer id;
    @JsonView(AffichageUtilisateur.class)
    private String nom;
    private  Integer prix;
    private  Integer gestionnaire_id = 4;
}
