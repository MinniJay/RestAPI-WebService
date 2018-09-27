package com.minnijay.inventory.service;

import com.minnijay.inventory.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class SectionServiceImpl implements SectionService{

    private final SectionRepository sectionRepository;
    private final GradeLevelRepository gradeLevelRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public SectionServiceImpl(SectionRepository sectionRepository, GradeLevelRepository gradeLevelRepository, TeacherRepository teacherRepository, StudentRepository studentRepository) {
        this.sectionRepository = sectionRepository;
        this.gradeLevelRepository = gradeLevelRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Section save(Section section) {
        return sectionRepository.save(section);
    }

    @Override
    public List<Section> save(Section... sections) {
        return Arrays.stream(sections).map(s -> sectionRepository.save(s)).collect(Collectors.toList());
    }

    @Override
    public List<Section> findAll() {
        return sectionRepository.findAll();
    }

    @Override
    public Section findById(int id) {
        return sectionRepository.findById(id).get();
    }

    @Override
    public Section findByName(String name) {
        return sectionRepository.findByName(name);
    }

    @Override
    public Section setGradeLevel(int sectionId, int gradeLevelId) {
        GradeLevel gradeLevel = gradeLevelRepository.findById(gradeLevelId).orElseThrow(() -> new IllegalArgumentException("Grade Level does not Exist"));
        Section section = sectionRepository.findById(sectionId).orElseThrow(() -> new IllegalArgumentException("Section does not Exist"));

        gradeLevel.getSectionList().add(section);
        section.setGradeLevel(gradeLevel);

        gradeLevelRepository.save(gradeLevel);
        return sectionRepository.save(section);
    }

    @Override
    public Section setAdviser(int teacherId, int sectionId) {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new IllegalArgumentException("Teacher does not Exist"));
        Section section = sectionRepository.findById(sectionId).orElseThrow(() -> new IllegalArgumentException("Section does not Exist"));

        teacher.getSectionList().add(section);
        section.setAdviser(teacher);

        teacherRepository.save(teacher);
        return sectionRepository.save(section);
    }

    @Override
    public Section addStudent(int sectionId, int studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalArgumentException("Student does not Exist"));
        Section section = sectionRepository.findById(sectionId).orElseThrow(() -> new IllegalArgumentException("Section does not Exist"));

        student.setSection(section);
        section.getStudentList().add(student);

        studentRepository.save(student);
        return sectionRepository.save(section);
    }

    @Override
    public Section addStudents(int sectionId, List<Integer> studentIds) {
        Section section = sectionRepository.findById(sectionId).orElseThrow(() -> new IllegalArgumentException("Section does not Exist"));
        studentIds.forEach(s -> {
            Student student =studentRepository.findById(s).orElseThrow(() -> new IllegalArgumentException("Student with "+s+" id does not exist"));
            section.getStudentList().add(student);
            student.setSection(section);
            studentRepository.save(student);
        });
        return sectionRepository.save(section);
    }

    @Override
    public void delete(int id) {
        sectionRepository.deleteById(id);
    }
}
