package com.fullstack.ds_back_coquin.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "EVALUATION_FINALE")
public class EvaluationFinale {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "NOM_DECIDEUR", columnDefinition = "varchar(50)", nullable = false)
    private String nomDecideur;

    @Column(name = "NOTE", columnDefinition = "INTEGER", nullable = false)
    private int note;

    @Column(name = "COMMENTAIRE", columnDefinition = "TEXT", nullable = false)
    private String descriptif;

    @OneToOne(mappedBy = "evaluationFinale")
    private Restaurant restaurant;


}