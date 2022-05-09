package com.edu.mns.control.dfs.dfsrcontrol.model;

import com.edu.mns.control.dfs.dfsrcontrol.view.AffichageCommande;
import com.edu.mns.control.dfs.dfsrcontrol.view.AffichageEmploye;
import com.edu.mns.control.dfs.dfsrcontrol.view.AffichageUtilisateur;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {

    public Utilisateur() {
    }

    public Utilisateur(String login) {
        this.login = login;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({AffichageUtilisateur.class, AffichageEmploye.class})
    private Integer id;

    @JsonView(AffichageCommande.class)
    private String login;

    private  String password;

    @ManyToMany
    private Set<MoyenPaiement> listeMoyenPaiement = new HashSet<>();

    @OneToMany(mappedBy = "client")
    private Set<Commande> listeCommande = new HashSet<>();
}
