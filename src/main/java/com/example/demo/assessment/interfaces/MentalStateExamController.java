package com.example.demo.assessment.interfaces;

import com.example.demo.assessment.domain.MentalStateExam;
import com.example.demo.assessment.domain.MentalStateExamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/mental-state-exams")
public class MentalStateExamController {

    private final MentalStateExamService mentalStateExamService;

    public MentalStateExamController(MentalStateExamService mentalStateExamService) {
        this.mentalStateExamService = mentalStateExamService;
    }

    @PostMapping
    public ResponseEntity<MentalStateExam> addMentalStateExam(@RequestBody MentalStateExamDto mentalStateExamDto) {
        MentalStateExam mentalStateExam = mentalStateExamService.addMentalStateExam(
                mentalStateExamDto.getPatientId(),
                mentalStateExamDto.getExaminerNationalProviderIdentifier(),
                mentalStateExamDto.getExamDate(),
                mentalStateExamDto.getOrientationScore(),
                mentalStateExamDto.getRegistrationScore(),
                mentalStateExamDto.getAttentionAndCalculationScore(),
                mentalStateExamDto.getRecallScore(),
                mentalStateExamDto.getLanguageScore()
        );
        return new ResponseEntity<>(mentalStateExam, HttpStatus.CREATED);
    }
}
