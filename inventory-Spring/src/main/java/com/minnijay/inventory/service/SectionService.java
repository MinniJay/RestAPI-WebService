package com.minnijay.inventory.service;

import com.minnijay.inventory.repository.Section;

import java.util.List;

public interface SectionService {

    Section save(Section section);

    List<Section> save(Section ... sections);

    List<Section> findAll();

    Section findById(int id);

    Section findByName(String name);

    Section setGradeLevel(int sectionId, int gradeLevelId);

    Section setAdviser(int teacherId, int sectionId);

    Section addStudent(int sectionId, int studentId);

    Section addStudents(int sectionId, List<Integer> studentIds);

    void delete(int id);
}
