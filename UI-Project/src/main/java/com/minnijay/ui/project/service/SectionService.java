
package com.minnijay.ui.project.service;

import com.minnijay.ui.project.dto.GradeLevel;

/**
 *
 * @author MinniJay
 */
public interface SectionService {

    void create(String name, int gradeLevelId, int adviserId);
    
    void findAll();
}
