package com.fullstack.ds_back_coquin.dto.response;

import com.fullstack.ds_back_coquin.dto.TagEnum;
import lombok.Data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Data
public class RestaurantDto {

    private int id;

    private String nom;

    private String adresse;

    private List<EvaluationDto> evaluations = new ArrayList<>();

    private float moyenneEvaluation;

    private EvaluationFinaleDto evaluationFinale;

    private File image;

    private TagEnum tag;
}