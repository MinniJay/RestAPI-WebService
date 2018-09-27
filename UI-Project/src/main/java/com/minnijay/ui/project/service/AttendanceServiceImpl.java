package com.minnijay.ui.project.service;

import com.minnijay.ui.project.dto.Attendance;
import com.minnijay.ui.project.restapi.AttendanceApi;
import com.minnijay.ui.project.restapi.ServiceHelper;
import com.minnijay.ui.project.service.presenter.AttendancePresenter;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AttendanceServiceImpl implements AttendanceService {

    AttendanceApi attendanceApi;
    AttendancePresenter attendancePresenter;

    public AttendanceServiceImpl(AttendanceApi attendanceApi, AttendancePresenter attendancePresenter) {
        this.attendanceApi = attendanceApi;
        this.attendancePresenter = attendancePresenter;
    }
    
    
    @Override
    public void create(Long date, int studentId, int remarkId) {
        attendanceApi.create(date, studentId, remarkId).enqueue(new Callback<Attendance>() {
            @Override
            public void onResponse(Call<Attendance> call, Response<Attendance> rspns) {
               attendancePresenter.onAttendanceCreation(rspns.body());
            }

            @Override
            public void onFailure(Call<Attendance> call, Throwable thrwbl) {
                thrwbl.printStackTrace();
            }
        });
    }

    @Override
    public void findAll() {
        attendanceApi.findAll().enqueue(new Callback<List<Attendance>>() {
            @Override
            public void onResponse(Call<List<Attendance>> call, Response<List<Attendance>> rspns) {
                attendancePresenter.updateDisplayAttendance(rspns.body());
            }

            @Override
            public void onFailure(Call<List<Attendance>> call, Throwable thrwbl) {
                thrwbl.printStackTrace();
            }
        });
    }

}
