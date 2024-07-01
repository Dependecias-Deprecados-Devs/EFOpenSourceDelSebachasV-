package com.example.demo.personnel.interfaces;

import com.example.demo.personnel.domain.Examiner;
import com.example.demo.personnel.domain.ExaminerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/examiners")
public class ExaminerController {

    private final ExaminerService examinerService;

    public ExaminerController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @PostMapping
    public ResponseEntity<Examiner> addExaminer(@RequestBody ExaminerDto examinerDto) {
        Examiner examiner = examinerService.addExaminer(
                examinerDto.getFirstName(),
                examinerDto.getLastName(),
                examinerDto.getNationalProviderIdentifier()
        );
        return new ResponseEntity<>(examiner, HttpStatus.CREATED);
    }
}
