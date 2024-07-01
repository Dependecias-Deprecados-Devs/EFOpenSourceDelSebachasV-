package com.example.demo.assessment.domain;

import com.example.demo.shared.domain.AuditModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "mental_state_exams")
public class MentalStateExam extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long patientId;

    @Column(nullable = false)
    private UUID examinerNationalProviderIdentifier;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date examDate;

    @Column(nullable = false)
    private int orientationScore;

    @Column(nullable = false)
    private int registrationScore;

    @Column(nullable = false)
    private int attentionAndCalculationScore;

    @Column(nullable = false)
    private int recallScore;

    @Column(nullable = false)
    private int languageScore;

    public MentalStateExam(Long patientId, UUID examinerNationalProviderIdentifier, Date examDate, int orientationScore,
                           int registrationScore, int attentionAndCalculationScore, int recallScore, int languageScore) {
        this.patientId = patientId;
        this.examinerNationalProviderIdentifier = examinerNationalProviderIdentifier;
        this.examDate = examDate;
        this.orientationScore = orientationScore;
        this.registrationScore = registrationScore;
        this.attentionAndCalculationScore = attentionAndCalculationScore;
        this.recallScore = recallScore;
        this.languageScore = languageScore;
    }
}
