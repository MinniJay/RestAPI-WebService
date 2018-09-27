package com.minnijay.inventory.controller;

import java.util.List;

public class AssignThingyRequest {
    private int id;
    private List<Integer> ids;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
