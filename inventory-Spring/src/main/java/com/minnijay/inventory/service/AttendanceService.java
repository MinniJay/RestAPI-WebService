package com.minnijay.inventory.service;

import com.minnijay.inventory.repository.Attendance;

import java.util.List;

public interface AttendanceService {
    Attendance save(Attendance attendance);

    List<Attendance> save(Attendance ... attendances);

    List<Attendance> findAll();

    Attendance findById(int id);

    void deleteById(int id);

    Attendance setStudent(int attendanceId, int studentId);

    Attendance setRemark(int attendanceId, int remarkId);
}
