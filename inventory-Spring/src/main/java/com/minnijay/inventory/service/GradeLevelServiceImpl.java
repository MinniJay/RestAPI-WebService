package com.minnijay.inventory.service;

import com.minnijay.inventory.repository.GradeLevel;
import com.minnijay.inventory.repository.GradeLevelRepository;
import com.minnijay.inventory.repository.Section;
import com.minnijay.inventory.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeLevelServiceImpl implements GradeLevelService {

    private final GradeLevelRepository gradeLevelRepository;
    private final SectionRepository sectionRepository;

    @Autowired
    public GradeLevelServiceImpl(GradeLevelRepository gradeLevelRepository, SectionRepository sectionRepository) {
        this.gradeLevelRepository = gradeLevelRepository;
        this.sectionRepository = sectionRepository;
    }


    @Override
    public GradeLevel save(GradeLevel gradeLevel) {
        return gradeLevelRepository.save(gradeLevel);
    }

    @Override
    public GradeLevel addSection(int gradeLevelId, int sectionId) {
        GradeLevel gradeLevel = gradeLevelRepository.findById(gradeLevelId).get();
        Section section = sectionRepository.findById(sectionId).get();

        gradeLevel.getSectionList().add(section);
        section.setGradeLevel(gradeLevel);

        sectionRepository.save(section);
        return gradeLevelRepository.save(gradeLevel);
    }

    @Override
    public GradeLevel addSections(int gradeLevelId, List<Integer> sections) {
        GradeLevel gradeLevel = gradeLevelRepository.findById(gradeLevelId).get();
        sections.forEach(s ->{
            Section section = sectionRepository.findById(s).orElseThrow(() -> new IllegalArgumentException("Section with "+s+" id does not Exist"));
            gradeLevel.getSectionList().add(section);
            section.setGradeLevel(gradeLevel);
            sectionRepository.save(section);
        });
        return gradeLevelRepository.save(gradeLevel);
    }

    @Override
    public List<GradeLevel> findAll() {
        return gradeLevelRepository.findAll();
    }

    public GradeLevel findGradeLevelById(int gradeLevelId) {
        return gradeLevelRepository.findById(gradeLevelId).get();
    }

    public GradeLevel findGradeLevelByName(String gradeLevelName) {
        return gradeLevelRepository.findByName(gradeLevelName);
    }

    @Override
    public void delete(int id) {
        if (gradeLevelRepository.existsById(id)){
            gradeLevelRepository.deleteById(id);
        }
    }

    public void deleteAll(){
        gradeLevelRepository.deleteAll();
    }

}
