package com.minnijay.inventory.dto;

import java.io.Serializable;
import java.util.Objects;

public class StudentDto implements Serializable{
    private int id;
    private String name;
    private String section;

    public StudentDto() {
    }

    public StudentDto(int id, String name, String section) {
        this.id = id;
        this.name = name;
        this.section = section;
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

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDto that = (StudentDto) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(section, that.section);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, section);
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", section=" + section +
                '}';
    }
}
