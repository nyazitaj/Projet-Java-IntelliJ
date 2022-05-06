package com.edu.mns.control.dfs.dfsrcontrol.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Commande {

    public Commande() {
    }

    public Commande(String datePaiment) {
        this.date_paiement = date_paiement;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String date_paiement;
    private  String client_id;
}
