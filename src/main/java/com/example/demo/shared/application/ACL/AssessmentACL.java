package com.example.demo.shared.application.ACL;

import com.example.demo.assessment.domain.MentalStateExamService;
import org.springframework.stereotype.Component;

@Component
public class AssessmentACL {

    private final MentalStateExamService mentalStateExamService;

    public AssessmentACL(MentalStateExamService mentalStateExamService) {
        this.mentalStateExamService = mentalStateExamService;
    }
}
