package com.fullstack.ds_back_coquin.service;

import com.fullstack.ds_back_coquin.domain.Evaluation;
import com.fullstack.ds_back_coquin.dto.response.EvaluationDto;
import com.fullstack.ds_back_coquin.exception.ResourceNotFoundException;
import com.fullstack.ds_back_coquin.repository.EvaluationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class EvaluationService {

    private EvaluationRepository evaluationRepository;

    public Evaluation ajouterEvaluation(EvaluationDto evaluationDto) {

        Evaluation evaluation = new Evaluation();
        evaluation.setNomEvaluateur(evaluationDto.getNomEvaluateur());
        evaluation.setCommentaire(evaluationDto.getCommentaire());
        evaluation.setNote(evaluationDto.getNote());
        evaluation.setDateMiseAJour(LocalDate.now());

        evaluationRepository.save(evaluation);

        return evaluation;
    }

    public Evaluation getEvaluationById(Integer id) {
        return evaluationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Evaluation with id " + id + " + not found"));

    }

    public List<Evaluation> getAllEvaluations() {
        return evaluationRepository.findAll();

    }

    public void deleteEvaluation(Integer id) {
        evaluationRepository.deleteById(id);
    }
}