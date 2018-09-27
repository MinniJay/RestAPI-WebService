package com.minnijay.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeLevelRepository extends JpaRepository<GradeLevel,Integer> {
    GradeLevel findByName(String name);
}
