
package com.minnijay.ui.project.service;

/**
 *
 * @author MinniJay
 */
public interface AttendanceService {
    void create(Long date, int studentId, int remarkId);
    
    void findAll();
}
