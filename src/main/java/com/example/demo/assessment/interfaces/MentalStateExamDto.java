package com.example.demo.assessment.interfaces;

import lombok.Data;

@Data
public class MentalStateExamDto {
    private Long patientId;
    private String examinerNationalProviderIdentifier;
    private String examDate;
    private int orientationScore;
    private int registrationScore;
    private int attentionAndCalculationScore;
    private int recallScore;
    private int languageScore;
}
