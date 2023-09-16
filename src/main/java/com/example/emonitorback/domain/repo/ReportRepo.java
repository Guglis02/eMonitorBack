package com.example.emonitorback.domain.repo;

import com.example.emonitorback.domain.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepo extends JpaRepository<Report, Long> {
}
