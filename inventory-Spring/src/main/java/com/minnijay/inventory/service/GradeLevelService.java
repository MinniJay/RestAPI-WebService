package com.minnijay.inventory.service;

import com.minnijay.inventory.repository.GradeLevel;

import java.util.List;


public interface GradeLevelService {
    GradeLevel save(GradeLevel gradeLevel);

    GradeLevel addSection(int gradeLevelId,int sectionId);

    List<GradeLevel> findAll();

    GradeLevel findGradeLevelById(int gradeLevelId);

    GradeLevel findGradeLevelByName(String gradeLevelName);

    void delete(int id);

    void deleteAll();

    GradeLevel addSections(int gradeLevelId,List<Integer> sections);
}
