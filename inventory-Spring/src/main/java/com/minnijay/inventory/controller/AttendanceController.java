package com.minnijay.inventory.controller;

import com.minnijay.inventory.dto.AttendanceDto;
import com.minnijay.inventory.dto.StudentDto;
import com.minnijay.inventory.repository.Attendance;
import com.minnijay.inventory.repository.Remark;
import com.minnijay.inventory.repository.Section;
import com.minnijay.inventory.repository.Student;
import com.minnijay.inventory.service.AttendanceService;
import com.minnijay.inventory.service.RemarkService;
import com.minnijay.inventory.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;
    private final StudentService studentService;
    private final RemarkService remarkService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService, StudentService studentService, RemarkService remarkService) {
        this.attendanceService = attendanceService;
        this.studentService = studentService;
        this.remarkService = remarkService;
    }

    @PostMapping("/create")
    public AttendanceDto create(@RequestParam long date, @RequestParam int studentId, @RequestParam int remarkId) {
        Student student = studentService.findById(studentId);
        Remark remark = remarkService.findById(remarkId);
        Attendance attendance = attendanceService.save(new Attendance(date, student, remark));
        return new AttendanceDto(attendance.getId(), attendance.getDate(), attendance.getStudent().getName(), attendance.getRemark());
    }

    @GetMapping("/findAll")
    public List<AttendanceDto> findAll() {
       return attendanceService.findAll().stream().map(attendance -> new AttendanceDto(attendance.getId(), attendance.getDate(), attendance.getStudent().getName(), attendance.getRemark())).collect(Collectors.toList());
    }

    @GetMapping("/findById")
    public AttendanceDto findById(@RequestParam int id) {
        Attendance attendance = attendanceService.findById(id);
        return new AttendanceDto(attendance.getId(), attendance.getDate(), attendance.getStudent().getName(), attendance.getRemark());
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam int id) {
        attendanceService.deleteById(id);
    }
}
