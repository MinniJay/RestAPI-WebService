package com.minnijay.inventory.service;

import com.minnijay.inventory.repository.Section;
import com.minnijay.inventory.repository.SectionRepository;
import com.minnijay.inventory.repository.Teacher;
import com.minnijay.inventory.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final SectionRepository sectionRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository, SectionRepository sectionRepository) {
        this.teacherRepository = teacherRepository;
        this.sectionRepository = sectionRepository;
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> save(Teacher... teachers) {
        return Arrays.stream(teachers).map(t -> teacherRepository.save(t)).collect(Collectors.toList());
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findById(int id) {
        return teacherRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Teacher does not Exist"));
    }

    @Override
    public Teacher findByName(String name) {
        return teacherRepository.findByName(name);
    }

    @Override
    public Teacher addSection(int teacherId, int sectionId) {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new IllegalArgumentException("Teacher does not Exist"));
        Section section = sectionRepository.findById(sectionId).orElseThrow(() -> new IllegalArgumentException("Section does not Exist"));

        section.setAdviser(teacher);
        teacher.getSectionList().add(section);

        sectionRepository.save(section);
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher addSections(int teacherId, List<Integer> sectionIds) {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new IllegalArgumentException("Teacher does not Exist"));
        sectionIds.forEach(s -> {
            Section section = sectionRepository.findById(s).orElseThrow(() -> new IllegalArgumentException("Section with "+s+" id does not exist"));
            section.setAdviser(teacher);
            sectionRepository.save(section);
            teacher.getSectionList().add(section);
        });
        return teacher;
    }

    @Override
    public void delete(int id) {
        teacherRepository.deleteById(id);
    }
}
