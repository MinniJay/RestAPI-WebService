package com.minnijay.inventory.controller;

import com.minnijay.inventory.dto.StudentDto;
import com.minnijay.inventory.repository.Student;
import com.minnijay.inventory.service.SectionService;
import com.minnijay.inventory.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;
    private final SectionService sectionService;

    @Autowired
    public StudentController(StudentService studentService, SectionService sectionService) {
        this.studentService = studentService;
        this.sectionService = sectionService;
    }

   @PostMapping("/create")
    public StudentDto createStudent(@RequestParam String name, @RequestParam int sectionId){
        Student student = studentService.save(new Student(name, sectionService.findById(sectionId)));
        return new StudentDto(student.getId(),student.getName(),student.getSection().getName());
    }

    @GetMapping("/findAll")
    public List<StudentDto> findAll(){
        return studentService.findAll().stream().map(student -> new StudentDto(student.getId(),student.getName(),student.getSection().getName())).collect(Collectors.toList());
    }

    @GetMapping("/findById")
    public StudentDto findById(@RequestParam int id){
        Student student = studentService.findById(id);
        return new StudentDto(student.getId(),student.getName(),student.getSection().getName());
    }

    @GetMapping("/findByName")
    public StudentDto findByName(@RequestParam String name){
        Student student =  studentService.findByName(name);
        return new StudentDto(student.getId(),student.getName(),student.getSection().getName());
    }

    @DeleteMapping("/delete")
    public void delete(int id){
        studentService.delete(id);
    }
}
