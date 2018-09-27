package com.minnijay.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance,Integer>{
    List<Attendance> findByDate(Date date);
}
