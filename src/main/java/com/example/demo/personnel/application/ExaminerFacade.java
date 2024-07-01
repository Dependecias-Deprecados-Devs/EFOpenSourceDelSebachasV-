package com.example.demo.personnel.application;

import com.example.demo.personnel.domain.Examiner;
import com.example.demo.personnel.domain.ExaminerService;
import org.springframework.stereotype.Service;

@Service
public class ExaminerFacade {

    private final ExaminerService examinerService;

    public ExaminerFacade(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    public Examiner addExaminer(String firstName, String lastName, String nationalProviderIdentifier) {
        return examinerService.addExaminer(firstName, lastName, nationalProviderIdentifier);
    }

    public Examiner getExaminerById(Long id) {
        return examinerService.getExaminerById(id);
    }
}