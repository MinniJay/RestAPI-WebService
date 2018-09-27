package com.minnijay.inventory.controller;

import com.minnijay.inventory.dto.GradeLevelDto;
import com.minnijay.inventory.repository.GradeLevel;
import com.minnijay.inventory.service.GradeLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/gradelevel")
public class GradeLevelController {

    private final GradeLevelService gradeLevelService;

    @Autowired
    public GradeLevelController(GradeLevelService gradeLevelService) {
        this.gradeLevelService = gradeLevelService;
    }

    @PostMapping("/create")
    public GradeLevelDto create(@RequestParam(name = "name") String gradeLevelName) {
        GradeLevel gradeLevel = new GradeLevel();
        gradeLevel.setName(gradeLevelName);
        gradeLevel = gradeLevelService.save(gradeLevel);
        return new GradeLevelDto(gradeLevel.getId(), gradeLevel.getName(), new ArrayList<>());
    }

    @GetMapping("/findAll")
    public List<GradeLevelDto> findAll() {
        return gradeLevelService.findAll().stream().map(gradeLevel -> {
            List<String> sections = new ArrayList<>();
            gradeLevel.getSectionList().forEach(section -> sections.add(section.getName()));
            return new GradeLevelDto(gradeLevel.getId(), gradeLevel.getName(), sections);
        }).collect(Collectors.toList());
    }

    @GetMapping("/findById")
    public GradeLevelDto findGradeLevelById(@RequestParam int id) {
        GradeLevel gradeLevel = gradeLevelService.findGradeLevelById(id);
        List<String> sections = new ArrayList<>();
        gradeLevel.getSectionList().forEach(section -> sections.add(section.getName()));
       return new GradeLevelDto(gradeLevel.getId(),gradeLevel.getName(),sections);
    }

    @GetMapping("/findByName/{gradeLevelName}")
    public GradeLevelDto findByGradeLevelName(@PathVariable String gradeLevelName) {
        GradeLevel gradeLevel = gradeLevelService.findGradeLevelByName(gradeLevelName);
        return new GradeLevelDto(gradeLevel.getId(), gradeLevel.getName());
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam int id) {
        gradeLevelService.delete(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        gradeLevelService.deleteAll();
    }

    @PutMapping("/addSection")
    public GradeLevelDto addSection(@RequestParam int gradeLevelId, @RequestParam int sectionId) {
        GradeLevel gradeLevel = gradeLevelService.addSection(gradeLevelId, sectionId);
        List<String> sections = new ArrayList<>();
        gradeLevel.getSectionList().forEach(section -> sections.add(section.getName()));
        return new GradeLevelDto(gradeLevel.getId(),gradeLevel.getName(),sections);
    }

    @PutMapping("/addSections")
    public GradeLevel addSections(@RequestBody AssignThingyRequest request) {
        return gradeLevelService.addSections(request.getId(), request.getIds());
    }

}
