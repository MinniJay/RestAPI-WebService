package com.minnijay.inventory.service;

import com.minnijay.inventory.repository.Section;
import com.minnijay.inventory.repository.SectionRepository;
import com.minnijay.inventory.repository.Student;
import com.minnijay.inventory.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final SectionRepository sectionRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, SectionRepository sectionRepository) {
        this.studentRepository = studentRepository;
        this.sectionRepository = sectionRepository;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> save(Student... students) {
        return Arrays.stream(students).map(studentRepository::save).collect(Collectors.toList());
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student findByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public Student setSection(int sectionId, int studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalArgumentException("Student does not Exist"));
        Section section = sectionRepository.findById(sectionId).orElseThrow(() -> new IllegalArgumentException("Section does not exist"));

        section.getStudentList().add(student);
        student.setSection(section);

        sectionRepository.save(section);
        return studentRepository.save(student);
    }

    @Override
    public void delete(int id) {
        studentRepository.deleteById(id);
    }
}
