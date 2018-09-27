package com.minnijay.ui.project.dto;

import java.io.Serializable;

/**
 *
 * @author MinniJay
 */
public class Remark implements Serializable{
    private int id;
    private String reasonForAbsence;
    private String lengthOfAbsence;
    private String guardian;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReasonForAbsence() {
        return reasonForAbsence;
    }

    public void setReasonForAbsence(String reasonForAbsence) {
        this.reasonForAbsence = reasonForAbsence;
    }

    public String getLengthOfAbsence() {
        return lengthOfAbsence;
    }

    public void setLengthOfAbsence(String lengthOfAbsence) {
        this.lengthOfAbsence = lengthOfAbsence;
    }

    public String getGuardian() {
        return guardian;
    }

    public void setGuardian(String guardian) {
        this.guardian = guardian;
    }

    @Override
    public String toString() {
        return reasonForAbsence + " " + lengthOfAbsence + " " + guardian;
    }
    
    
    
}
