package com.example.demo.assessment.application;

import com.example.demo.assessment.domain.MentalStateExam;
import com.example.demo.assessment.domain.MentalStateExamService;
import org.springframework.stereotype.Service;

@Service
public class MentalStateExamFacade {

    private final MentalStateExamService mentalStateExamService;

    public MentalStateExamFacade(MentalStateExamService mentalStateExamService) {
        this.mentalStateExamService = mentalStateExamService;
    }

    public MentalStateExam addMentalStateExam(Long patientId, String examinerNationalProviderIdentifier,
                                              String examDate, int orientationScore, int registrationScore,
                                              int attentionAndCalculationScore, int recallScore, int languageScore) {
        return mentalStateExamService.addMentalStateExam(patientId, examinerNationalProviderIdentifier, examDate,
                orientationScore, registrationScore,
                attentionAndCalculationScore, recallScore, languageScore);
    }
}
