package com.fullstack.ds_back_coquin.dto;

import lombok.Data;

@Data
public class EvaluationFinaleDto {

    private int id;

    private String nomDecideur;

    private int note;

    private String descriptif;
}