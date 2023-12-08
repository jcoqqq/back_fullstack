package com.fullstack.ds_back_coquin.dto;

import lombok.Data;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class EvaluationDto {

    private int id;

    private String nomEvaluateur;

    private String commentaire;

    private int note;

    private LocalDate dateCreation;

    private LocalDate dateMiseAJour;

    private List<File> photos = new ArrayList<>();
}