package com.minnijay.inventory.dto;

import com.minnijay.inventory.repository.Remark;
import java.io.Serializable;

import java.util.Objects;

public class AttendanceDto implements Serializable{
    private int id;
    private long date;
    private String studentname;
    private Remark remark;

    public AttendanceDto(int id, long date, String studentname, Remark remark) {
        this.id = id;
        this.date = date;
        this.studentname = studentname;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public Remark getRemark() {
        return remark;
    }

    public void setRemark(Remark remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttendanceDto that = (AttendanceDto) o;
        return id == that.id &&
                date == that.date &&
                Objects.equals(studentname, that.studentname) &&
                Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, date, studentname, remark);
    }

    @Override
    public String toString() {
        return "AttendanceDto{" +
                "id=" + id +
                ", date=" + date +
                ", studentname='" + studentname + '\'' +
                ", remark=" + remark +
                '}';
    }
}
