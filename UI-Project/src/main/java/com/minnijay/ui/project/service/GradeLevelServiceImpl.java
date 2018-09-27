package com.minnijay.ui.project.service;

import com.minnijay.ui.project.service.presenter.GradeLevelPresenter;
import com.minnijay.ui.project.dto.GradeLevel;
import com.minnijay.ui.project.restapi.GradeLevelApi;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GradeLevelServiceImpl implements GradeLevelService {

    private GradeLevelApi gradeLevelApi;
    private GradeLevelPresenter gradeLevelPresenter;

    public GradeLevelServiceImpl(GradeLevelApi gradeLevelApi, GradeLevelPresenter gradeLevelPresenter) {
        this.gradeLevelApi = gradeLevelApi;
        this.gradeLevelPresenter = gradeLevelPresenter;
    }
    
    @Override
    public void create(String name) {
        gradeLevelApi.createUser(name).enqueue(new Callback<GradeLevel>() {
            @Override
            public void onResponse(Call<GradeLevel> call, Response<GradeLevel> rspns) {
               gradeLevelPresenter.onGradeLevelCreate(rspns.body());
            }

            @Override
            public void onFailure(Call<GradeLevel> call, Throwable thrwbl) {
                thrwbl.printStackTrace();
            }
        });
    }

    @Override
    public void findAll() {
        gradeLevelApi.findAll().enqueue(new Callback<List<GradeLevel>>() {
            @Override
            public void onResponse(Call<List<GradeLevel>> call, Response<List<GradeLevel>> rspns) {
                gradeLevelPresenter.updateGradeLevelTableDisplay(rspns.body());
            }

            @Override
            public void onFailure(Call<List<GradeLevel>> call, Throwable thrwbl) {
                
            }
        });
    }

}
