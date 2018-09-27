package com.minnijay.inventory.controller;

import com.minnijay.inventory.repository.Section;

import java.util.List;

public class GradeLevelRequest {
    private String name;
    private List<Integer> sections;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getSections() {
        return sections;
    }

    public void setSections(List<Integer> sections) {
        this.sections = sections;
    }
}
