package com.example.project_BE.project_BE.repository;

import com.example.project_BE.project_BE.model.Kafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KafeRepository extends JpaRepository<Kafe, Long> {
    List<Kafe> findByAdminId(Long idAdmin);
}