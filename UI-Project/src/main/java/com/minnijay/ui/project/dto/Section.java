package com.minnijay.ui.project.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author MinniJay
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Section implements Serializable{

    private int id;
    private String name;
    private String gradeLevel;
    private String adviser;
    private List<String> students;

    public Section() {
    }

    public Section(int id, String name, String gradeLevel, String adviser, List<String> students) {
        this.id = id;
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.adviser = adviser;
        this.students = students;
    }

    public List<String> getStudents() {
        return students;
    }

    public void setStudents(List<String> students) {
        this.students = students;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public String getAdviser() {
        return adviser;
    }

    public void setAdviser(String adviser) {
        this.adviser = adviser;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.gradeLevel);
        hash = 59 * hash + Objects.hashCode(this.adviser);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Section other = (Section) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.gradeLevel, other.gradeLevel)) {
            return false;
        }
        if (!Objects.equals(this.adviser, other.adviser)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return "Section{" + "id=" + id + ", name=" + name + ", gradeLevel=" + gradeLevel + ", adviser=" + adviser + '}';
    }

    
}
