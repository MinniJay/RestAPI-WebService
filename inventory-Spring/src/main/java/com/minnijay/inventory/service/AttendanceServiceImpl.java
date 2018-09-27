package com.minnijay.inventory.service;

import com.minnijay.inventory.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final StudentRepository studentRepository;
    private final RemarkRepository remarkRepository;

    @Autowired
    public AttendanceServiceImpl(AttendanceRepository attendanceRepository, StudentRepository studentRepository, RemarkRepository remarkRepository){
        this.attendanceRepository = attendanceRepository;
        this.studentRepository = studentRepository;
        this.remarkRepository = remarkRepository;
    }

    @Override
    public Attendance save(Attendance attendance) {
        attendance.setDate(attendance.getDate());
        return attendanceRepository.save(attendance);
    }

    @Override
    public List<Attendance> save(Attendance... attendances) {
        return Arrays.stream(attendances).map(attendanceRepository::save).collect(Collectors.toList());
    }

    @Override
    public List<Attendance> findAll() {
        return attendanceRepository.findAll();
    }

    @Override
    public Attendance findById(int id) {
        return attendanceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Attendance does not exist"));
    }

    @Override
    public void deleteById(int id) {
        attendanceRepository.deleteById(id);
    }

    @Override
    public Attendance setStudent(int attendanceId, int studentId) {
        Student student = studentRepository.findById(studentId).get();
        Attendance attendance = attendanceRepository.findById(attendanceId).get();
        attendance.setStudent(student);
        return attendanceRepository.save(attendance);
    }

    @Override
    public Attendance setRemark(int attendanceId, int remarkId) {
        Remark remark = remarkRepository.findById(remarkId).get();
        Attendance attendance = attendanceRepository.findById(attendanceId).get();
        attendance.setRemark(remark);
        return attendanceRepository.save(attendance);
    }
}
