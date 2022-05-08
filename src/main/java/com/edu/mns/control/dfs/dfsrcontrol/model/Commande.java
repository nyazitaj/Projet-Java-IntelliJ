package com.edu.mns.control.dfs.dfsrcontrol.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

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

    private Date date_paiement;
    private  Integer client_id;
}
