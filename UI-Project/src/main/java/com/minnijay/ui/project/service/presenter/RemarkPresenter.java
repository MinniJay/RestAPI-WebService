
package com.minnijay.ui.project.service.presenter;

import com.minnijay.ui.project.dto.Remark;
import java.util.List;

/**
 *
 * @author MinniJay
 */
public interface RemarkPresenter {
   void updateDisplayRemark(List<Remark> remarks);
    
    void onRemarkCreation(Remark remark);
}
