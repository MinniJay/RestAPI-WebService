package com.minnijay.inventory.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class TeacherDto implements Serializable{
    private int id;
    private String name;
    private List<String> sections;


    public TeacherDto() {
    }

    public TeacherDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public TeacherDto(int id, String name, List<String> sections) {
        this.id = id;
        this.name = name;
        this.sections = sections;
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

    public List<String> getSections() {
        return sections;
    }

    public void setSections(List<String> sections) {
        this.sections = sections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherDto that = (TeacherDto) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(sections, that.sections);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, sections);
    }

    @Override
    public String toString() {
        return "TeacherDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sections=" + sections +
                '}';
    }
}
