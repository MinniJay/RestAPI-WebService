package com.minnijay.inventory.service;

import com.minnijay.inventory.repository.Section;
import com.minnijay.inventory.repository.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher save(Teacher teacher);

    List<Teacher> save(Teacher ... teachers);

    List<Teacher> findAll();

    Teacher findById(int id);

    Teacher findByName(String name);

    Teacher addSection(int teacherId, int sectionId);

    Teacher addSections(int teacherId, List<Integer> sectionIds);

    void delete(int id);
}
