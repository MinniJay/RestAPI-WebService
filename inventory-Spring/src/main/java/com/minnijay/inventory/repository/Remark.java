package com.minnijay.inventory.repository;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "remark")
public class Remark implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Remark remark = (Remark) o;
        return id == remark.id &&
                Objects.equals(reasonForAbsence, remark.reasonForAbsence) &&
                Objects.equals(lengthOfAbsence, remark.lengthOfAbsence) &&
                Objects.equals(guardian, remark.guardian);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, reasonForAbsence, lengthOfAbsence, guardian);
    }

    @Override
    public String toString() {
        return "Remark{" +
                "id=" + id +
                ", reasonForAbsence='" + reasonForAbsence + '\'' +
                ", lengthOfAbsence='" + lengthOfAbsence + '\'' +
                ", guardian='" + guardian + '\'' +
                '}';
    }
}
