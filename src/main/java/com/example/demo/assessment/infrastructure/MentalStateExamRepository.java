package com.example.demo.assessment.infrastructure;

import com.example.demo.assessment.domain.MentalStateExam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentalStateExamRepository extends JpaRepository<MentalStateExam, Long> {
}
