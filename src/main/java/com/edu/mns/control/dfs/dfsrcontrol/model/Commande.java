package com.edu.mns.control.dfs.dfsrcontrol.model;

import com.edu.mns.control.dfs.dfsrcontrol.view.AffichageCommande;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Commande {

    public Commande() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonView(AffichageCommande.class)
    private Date date_paiement;

    @ManyToOne
    @JsonView(AffichageCommande.class)
    private Utilisateur client;

    @OneToMany(mappedBy = "commande")
    @JsonView(AffichageCommande.class)
    private List<LigneCommande> listeLigneCommande;

}
