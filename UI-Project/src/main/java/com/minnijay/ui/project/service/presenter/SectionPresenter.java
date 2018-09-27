package com.minnijay.ui.project.service.presenter;

import com.minnijay.ui.project.dto.Section;

import java.util.List;

/**
 *
 * @author MinniJay
 */
public interface SectionPresenter {
    void onSectionCreation(Section section);

    void UpdateSectionList(List<Section> sections);
}
