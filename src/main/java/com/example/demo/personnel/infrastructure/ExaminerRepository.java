package com.example.demo.personnel.infrastructure;

import com.example.demo.personnel.domain.Examiner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ExaminerRepository extends JpaRepository<Examiner, Long> {
    boolean existsByNationalProviderIdentifier(UUID nationalProviderIdentifier);
    Optional<Examiner> findByNationalProviderIdentifier(UUID nationalProviderIdentifier);
}
