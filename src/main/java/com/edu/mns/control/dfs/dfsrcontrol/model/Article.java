package com.edu.mns.control.dfs.dfsrcontrol.model;

import com.edu.mns.control.dfs.dfsrcontrol.view.AffichageCommande;
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
    private Integer id;

    private String nom;

    @JsonView(AffichageCommande.class)
    public  float prix;

    private  Integer gestionnaire_id;
}
