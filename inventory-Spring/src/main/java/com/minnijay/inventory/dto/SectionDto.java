package com.minnijay.inventory.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class SectionDto implements Serializable{

    private int id;
    private String name;
    private String gradeLevel;
    private String adviser;
    private List<String> students;

    public SectionDto() {
    }

    public SectionDto(int id, String name, String gradeLevel, String adviser) {
        this.id = id;
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.adviser = adviser;
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

    public List<String> getStudents() {
        return students;
    }

    public void setStudents(List<String> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectionDto that = (SectionDto) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(gradeLevel, that.gradeLevel) &&
                Objects.equals(adviser, that.adviser) &&
                Objects.equals(students, that.students);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, gradeLevel, adviser, students);
    }

    @Override
    public String toString() {
        return "SectionDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gradeLevel=" + gradeLevel +
                ", adviser=" + adviser +
                ", students=" + students +
                '}';
    }
}
