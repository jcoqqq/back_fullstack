package com.fullstack.ds_back_coquin.web.controller;

import com.fullstack.ds_back_coquin.domain.Evaluation;
import com.fullstack.ds_back_coquin.dto.response.EvaluationDto;
import com.fullstack.ds_back_coquin.service.EvaluationService;
import com.fullstack.ds_back_coquin.web.api.IEvaluationRest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
public class EvaluationController implements IEvaluationRest {

    private EvaluationService evaluationService;


    @Override
    public Evaluation ajouterEvaluation(EvaluationDto evaluationDto) {
        log.info("appel de ajouterEvaluation");
        Evaluation evaluation = evaluationService.ajouterEvaluation(evaluationDto);
        log.info("retour de ajouterEvaluation");
        return evaluation;
    }

    @Override
    public Evaluation getEvaluationById(Integer id) {
        log.info("appel de getEvaluationById");
        Evaluation evaluation = evaluationService.getEvaluationById(id);
        log.info("retour de getEvaluationById");
        return evaluation;
    }

    @Override
    public List<Evaluation> getAllEvaluations() {
        log.info("appel de getAllEvaluations");
        List<Evaluation> evaluations = evaluationService.getAllEvaluations();
        log.info("retour de getAllEvaluations");
        return evaluations;
    }

    @Override
    public void deleteEvaluation(Integer id) {
        log.info("appel de deleteEvaluation");
        evaluationService.deleteEvaluation(id);
        log.info("retour de deleteEvaluation");
    }
}