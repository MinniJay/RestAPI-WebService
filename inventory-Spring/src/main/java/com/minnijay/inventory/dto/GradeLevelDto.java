package com.minnijay.inventory.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class GradeLevelDto implements Serializable {
    private int id;
    private String name;
    private List<String> sections;

    public GradeLevelDto() {
    }

    public GradeLevelDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public GradeLevelDto(int id, String name, List<String> sections) {
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
        GradeLevelDto that = (GradeLevelDto) o;
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
        return "GradeLevelDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sections=" + sections +
                '}';
    }
}
