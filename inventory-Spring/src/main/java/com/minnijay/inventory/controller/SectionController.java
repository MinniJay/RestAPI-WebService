package com.minnijay.inventory.controller;

import com.minnijay.inventory.dto.SectionDto;
import com.minnijay.inventory.repository.Section;
import com.minnijay.inventory.service.GradeLevelService;
import com.minnijay.inventory.service.SectionService;
import com.minnijay.inventory.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/section")
public class SectionController {

    private final SectionService sectionService;
    private final GradeLevelService gradeLevelService;
    private final TeacherService teacherService;

    @Autowired
    public SectionController(SectionService sectionService, GradeLevelService gradeLevelService, TeacherService teacherService) {
        this.sectionService = sectionService;
        this.gradeLevelService = gradeLevelService;
        this.teacherService = teacherService;
    }

    @PostMapping("/create")
    public SectionDto createSection(@RequestParam String name, @RequestParam int gradeLevelId, @RequestParam int adviserId) {
        Section section = sectionService.save(new Section(name));
        section.setGradeLevel(gradeLevelService.addSection(gradeLevelId, section.getId()));
        section.setAdviser(teacherService.addSection(adviserId, section.getId()));
        section = sectionService.save(section);
        SectionDto sectionDto = new SectionDto(section.getId(), section.getName(), section.getGradeLevel().getName(), section.getAdviser().getName());
        System.err.println(sectionDto);
        return sectionDto;
    }

    @GetMapping("/findAll")
    public List<SectionDto> findAll() {
        return sectionService.findAll().stream().map(section -> new SectionDto(section.getId(), section.getName(), section.getGradeLevel().getName(), section.getAdviser().getName())).collect(Collectors.toList());
    }

    @GetMapping("/findById")
    public SectionDto findById(@RequestParam int id) {
        Section section = sectionService.findById(id);
        return new SectionDto(section.getId(),section.getName(), section.getGradeLevel().getName(), section.getAdviser().getName());
    }

    @GetMapping("/findByName")
    public SectionDto findByName(@RequestParam String name) {
        Section section = sectionService.findByName(name);
        return new SectionDto(section.getId(),section.getName(), section.getGradeLevel().getName(), section.getAdviser().getName());
    }

    @DeleteMapping("/delete")
    public void delete(int id) {
        sectionService.delete(id);
    }

    @PutMapping("/setGradeLevel")
    public SectionDto setGradeLevel(@RequestParam int sectionId, @RequestParam int gradeLevelId) {
        Section section = sectionService.setGradeLevel(sectionId, gradeLevelId);
        SectionDto sectionDto = new SectionDto();
        sectionDto.setGradeLevel(section.getGradeLevel().getName());
        sectionDto.setName(section.getName());
        sectionDto.setId(section.getId());
        return sectionDto;
    }

    @PutMapping("/setAdviser")
    public SectionDto setAdviser(@RequestParam int sectionId, @RequestParam int adviserId) {
        Section section = sectionService.setAdviser(adviserId, sectionId);
        SectionDto sectionDto = new SectionDto();
        sectionDto.setId(section.getId());
        sectionDto.setName(section.getName());
        sectionDto.setAdviser(section.getAdviser().getName());
        return sectionDto;
    }
}
