
package com.minnijay.ui.project.service.presenter;

import com.minnijay.ui.project.dto.Attendance;
import com.minnijay.ui.project.dto.Teacher;
import java.util.List;

/**
 *
 * @author MinniJay
 */
public interface AttendancePresenter {
    
    void updateDisplayAttendance(List<Attendance> Attendance);
    
    void onAttendanceCreation(Attendance Attendance);
}
