package com.minnijay.inventory.service;

import com.minnijay.inventory.repository.Student;

import java.util.List;

public interface StudentService {
    Student save(Student student);

    List<Student> save(Student ... students);

    List<Student> findAll();

    Student findById(int id);

    Student findByName(String name);

    Student setSection(int sectionId, int studentId);

    void delete(int id);
}
