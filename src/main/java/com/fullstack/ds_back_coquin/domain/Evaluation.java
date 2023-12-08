package com.fullstack.ds_back_coquin.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "EVALUATION")
public class Evaluation {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "NOM_EVALUATEUR", columnDefinition = "varchar(50)", nullable = false)
    private String nomEvaluateur;

    @Column(name = "COMMENTAIRE", columnDefinition = "varchar(255)", nullable = false)
    private String commentaire;

    @Column(name = "NOTE", columnDefinition = "INTEGER", nullable = false)
    private int note;

    @Column(name = "DATE_CREATION", columnDefinition = "DATE", nullable = false)
    private LocalDate dateCreation;

    @Column(name = "DATE_MISE_A_JOUR", columnDefinition = "DATE", nullable = false)
    private LocalDate dateMiseAJour;



    @ManyToOne
    @JoinColumn(name = "ID_RESTAURANT", nullable = false)
    private Restaurant restaurant;

    //private List<String> urlImage;
}