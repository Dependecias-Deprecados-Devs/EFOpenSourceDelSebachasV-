package com.example.demo.assessment.domain;

import com.example.demo.assessment.infrastructure.MentalStateExamRepository;
import com.example.demo.personnel.domain.ExaminerService;
import com.example.demo.shared.interfaces.exceptions.BadRequestException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class MentalStateExamService {
    private final MentalStateExamRepository mentalStateExamRepository;
    private final ExaminerService examinerService;

    public MentalStateExamService(MentalStateExamRepository mentalStateExamRepository, ExaminerService examinerService) {
        this.mentalStateExamRepository = mentalStateExamRepository;
        this.examinerService = examinerService;
    }

    public MentalStateExam addMentalStateExam(Long patientId, String examinerNationalProviderIdentifier,
                                              String examDate, int orientationScore, int registrationScore,
                                              int attentionAndCalculationScore, int recallScore, int languageScore) {
        UUID uuid;
        try {
            uuid = UUID.fromString(examinerNationalProviderIdentifier);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid UUID format");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = sdf.parse(examDate);
        } catch (ParseException e) {
            throw new BadRequestException("Invalid date format, should be YYYY-MM-DD");
        }

        if (date.after(new Date())) {
            throw new BadRequestException("Exam date cannot be in the future");
        }

        if (orientationScore < 0 || orientationScore > 10 ||
                registrationScore < 0 || registrationScore > 3 ||
                attentionAndCalculationScore < 0 || attentionAndCalculationScore > 5 ||
                recallScore < 0 || recallScore > 3 ||
                languageScore < 0 || languageScore > 9) {
            throw new BadRequestException("Invalid score values");
        }

        MentalStateExam mentalStateExam = new MentalStateExam(
                patientId,
                uuid,
                date,
                orientationScore,
                registrationScore,
                attentionAndCalculationScore,
                recallScore,
                languageScore
        );

        return mentalStateExamRepository.save(mentalStateExam);
    }
}
