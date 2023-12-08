package com.fullstack.ds_back_coquin.web.api;

import com.fullstack.ds_back_coquin.domain.Evaluation;
import com.fullstack.ds_back_coquin.dto.response.EvaluationDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/v1/evaluation")
public interface IEvaluationRest {

    @PostMapping("/ajouter")
    Evaluation ajouterEvaluation(EvaluationDto evaluationDto);

    @GetMapping("/{id}")
    Evaluation getEvaluationById(@PathVariable Integer id);

    @GetMapping("/")
    List<Evaluation> getAllEvaluations();

    @DeleteMapping("/")
    void deleteEvaluation(@PathVariable Integer id);
}