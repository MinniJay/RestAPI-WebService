package com.minnijay.ui.project.service.presenter;

import com.minnijay.ui.project.dto.GradeLevel;
import java.util.List;

/**
 *
 * @author MinniJay
 */
public interface GradeLevelPresenter {

    void onGradeLevelCreate(GradeLevel gradeLevel);
    
    void updateGradeLevelTableDisplay(List<GradeLevel> gradeLevels);
}
