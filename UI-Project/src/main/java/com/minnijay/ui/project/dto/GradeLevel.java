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
public class GradeLevel implements Serializable{

    private int id;
    private String name;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.name);
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
        final GradeLevel other = (GradeLevel) obj;
        return true;
    }

    @Override
    public String toString() {
        return "GradeLevel{" + "name=" + name + '}';
    }
    
    
    

}
