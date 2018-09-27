package com.minnijay.inventory.repository;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "section")
public class Section implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private GradeLevel gradeLevel;
    @ManyToOne
    private Teacher adviser;
    @OneToMany(mappedBy = "section", fetch = FetchType.EAGER)
    private List<Student> studentList;

    public Section() {
    }

    public Section(String name, GradeLevel gradeLevel) {
        this.name = name;
        this.gradeLevel = gradeLevel;
    }

    public Section(String name) {
        this.name = name;
    }

    public Section(String name, GradeLevel gradeLevel, Teacher teacher) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.adviser = teacher;
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

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public GradeLevel getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(GradeLevel gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public Teacher getAdviser() {
        return adviser;
    }

    public void setAdviser(Teacher adviser) {
        this.adviser = adviser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return id == section.id &&
                Objects.equals(name, section.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
