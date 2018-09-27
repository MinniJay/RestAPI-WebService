package com.minnijay.ui.project.service.presenter;

import com.minnijay.ui.project.dto.Student;
import java.util.List;

/**
 *
 * @author MinniJay
 */
public interface StudentPresenter {
    void onStudentCreation(Student student);
    void updateStudentDisplay(List<Student> student);
}
