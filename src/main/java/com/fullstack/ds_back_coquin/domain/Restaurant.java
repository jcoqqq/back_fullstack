package com.fullstack.ds_back_coquin.domain;

import com.fullstack.ds_back_coquin.dto.TagEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "RESTAURANT")
public class Restaurant {

    @Id
    @Column(name = "ID_RESTAURANT")
    @GeneratedValue
    private int id;

    @Column(name = "NOM", columnDefinition = "varchar(90)", nullable = false)
    private String nom;

    @Column(name = "ADRESSE", columnDefinition = "varchar(255)", nullable = false)
    private String adresse;

    @Column(name = "MOYENNE_EVALUATION", columnDefinition = "FLOAT", nullable = false)
    private float moyenneEvaluation;

    @Column(name = "URL_IMAGE", columnDefinition = "TEXT")
    private String urlImage;

    @OneToOne
    @JoinColumn(name = "ID_EVALUATION_FINALE")
    private EvaluationFinale evaluationFinale;


    @OneToMany(mappedBy = "restaurant")
    private List<Evaluation> evaluations = new ArrayList<>();

    @Column(name = "TAG")
    @Enumerated(EnumType.STRING)
    private TagEnum tag;

}