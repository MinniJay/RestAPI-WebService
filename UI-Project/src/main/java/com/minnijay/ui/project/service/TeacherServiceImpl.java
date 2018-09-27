package com.minnijay.ui.project.service;

import com.minnijay.ui.project.service.presenter.TeacherPresenter;
import com.minnijay.ui.project.dto.Teacher;
import com.minnijay.ui.project.restapi.TeacherApi;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TeacherServiceImpl implements TeacherService {

    private TeacherPresenter teacherPresenter;
    private TeacherApi teacherApi;

    public TeacherServiceImpl(TeacherApi teacherApi,TeacherPresenter teacherPresenter) {
        this.teacherPresenter = teacherPresenter;
        this.teacherApi = teacherApi;
    }
    
    @Override
    public void findAll() {
        teacherApi.findAll().enqueue(new Callback<List<Teacher>>() {
            @Override
            public void onResponse(Call<List<Teacher>> call, Response<List<Teacher>> rspns) {
                teacherPresenter.updateTeacherList(rspns.body());
            }

            @Override
            public void onFailure(Call<List<Teacher>> call, Throwable thrwbl) {
                thrwbl.printStackTrace();
            }
        });
    }

    @Override
    public void create(String name) {
        teacherApi.createUser(name).enqueue(new Callback<Teacher>() {
            @Override
            public void onResponse(Call<Teacher> call, Response<Teacher> rspns) {
                teacherPresenter.onTeacherCreate(rspns.body());
            }

            @Override
            public void onFailure(Call<Teacher> call, Throwable thrwbl) {
                thrwbl.printStackTrace();
            }
        });
    }

}
