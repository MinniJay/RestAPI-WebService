
package com.minnijay.ui.project.service;

import com.minnijay.ui.project.dto.Remark;

/**
 *
 * @author MinniJay
 */
public interface RemarkService {
    void create(Remark remark);
    
    void findAll();
    
    void findById(int id);
}
