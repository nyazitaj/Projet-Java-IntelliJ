package com.edu.mns.control.dfs.dfsrcontrol.model;

import com.edu.mns.control.dfs.dfsrcontrol.view.AffichagePropriete;
import com.edu.mns.control.dfs.dfsrcontrol.view.AffichageArticle;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Caracteristique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({ AffichagePropriete.class, AffichageArticle.class })
    private Integer id;
    @JsonView({ AffichagePropriete.class, AffichageArticle.class })
    private String article_id;
    private  String propriete_id;
    private  String valeur;
}
