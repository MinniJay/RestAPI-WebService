package com.minnijay.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section,Integer> {
    Section findByName(String name);
}
