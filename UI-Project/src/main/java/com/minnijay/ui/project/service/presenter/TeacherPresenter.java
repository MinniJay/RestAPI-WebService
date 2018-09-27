package com.minnijay.ui.project.service.presenter;

import com.minnijay.ui.project.dto.Teacher;
import java.util.List;

/**
 *
 * @author MinniJay
 */
public interface TeacherPresenter {
    
    void updateTeacherList(List<Teacher> teachers);
    
    void onTeacherCreate(Teacher teacher);

}
