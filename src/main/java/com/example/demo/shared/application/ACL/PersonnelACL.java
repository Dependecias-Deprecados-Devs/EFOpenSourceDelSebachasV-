package com.example.demo.shared.application.ACL;

import com.example.demo.personnel.domain.Examiner;
import com.example.demo.personnel.domain.ExaminerService;
import com.example.demo.shared.interfaces.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PersonnelACL {

    private final ExaminerService examinerService;

    public PersonnelACL(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    public boolean isValidExaminer(UUID examinerNationalProviderIdentifier) {
        try {
            Examiner examiner = examinerService.getExaminerByNationalProviderIdentifier(examinerNationalProviderIdentifier);
            return examiner != null;
        } catch (ResourceNotFoundException e) {
            return false;
        }
    }
}
