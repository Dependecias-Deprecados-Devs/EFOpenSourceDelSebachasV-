package com.example.demo.personnel.domain;

import com.example.demo.personnel.infrastructure.ExaminerRepository;
import com.example.demo.shared.interfaces.exceptions.BadRequestException;
import com.example.demo.shared.interfaces.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExaminerService {

    private final ExaminerRepository examinerRepository;

    public ExaminerService(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }

    public Examiner addExaminer(String firstName, String lastName, String nationalProviderIdentifier) {
        UUID uuid;
        try {
            uuid = UUID.fromString(nationalProviderIdentifier);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid UUID format");
        }

        if (examinerRepository.existsByNationalProviderIdentifier(uuid)) {
            throw new BadRequestException("nationalProviderIdentifier already exists");
        }

        Examiner examiner = new Examiner(firstName, lastName, uuid);
        return examinerRepository.save(examiner);
    }

    public Examiner getExaminerById(Long id) {
        return examinerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Examiner not found"));
    }

    public Examiner getExaminerByNationalProviderIdentifier(UUID nationalProviderIdentifier) {
        return examinerRepository.findByNationalProviderIdentifier(nationalProviderIdentifier)
                .orElseThrow(() -> new ResourceNotFoundException("Examiner not found"));
    }
}
