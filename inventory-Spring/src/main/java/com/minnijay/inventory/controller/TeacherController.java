package com.minnijay.inventory.controller;

import com.minnijay.inventory.dto.TeacherDto;
import com.minnijay.inventory.repository.Teacher;
import com.minnijay.inventory.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/create")
    public TeacherDto create(@RequestParam String name) {
        Teacher teacher = teacherService.save(new Teacher(name));
        return new TeacherDto(teacher.getId(), teacher.getName());
    }

    @GetMapping("/findAll")
    public List<TeacherDto> findAll() {
        return teacherService.findAll().stream().map(teacher -> {
            List<String> sections = new ArrayList<>();
            teacher.getSectionList().forEach(section -> sections.add(section.getName()));
            return new TeacherDto(teacher.getId(), teacher.getName(), sections);
        }).collect(Collectors.toList());
    }

    @GetMapping("/findById")
    public TeacherDto findById(@RequestParam int id) {
        Teacher teacher = teacherService.findById(id);
        List<String> sections = new ArrayList<>();
        teacher.getSectionList().forEach(section -> sections.add(section.getName()));
        return new TeacherDto(teacher.getId(), teacher.getName(), sections);
    }

    @GetMapping("/findByName")
    public TeacherDto findByName(@RequestParam String name) {
        Teacher teacher = teacherService.findByName(name);
        List<String> sections = new ArrayList<>();
        teacher.getSectionList().forEach(section -> sections.add(section.getName()));
        return new TeacherDto(teacher.getId(), teacher.getName(), sections);
    }
}
