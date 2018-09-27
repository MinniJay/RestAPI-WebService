
package com.minnijay.ui.project.service;

import com.minnijay.ui.project.dto.Student;

/**
 *
 * @author MinniJay
 */
public interface StudentService {
    void create(String name, int sectionId);
    
    void findAll();
}
