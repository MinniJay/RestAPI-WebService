package com.minnijay.ui.project.service;

import com.minnijay.ui.project.dto.Section;
import com.minnijay.ui.project.service.presenter.SectionPresenter;
import com.minnijay.ui.project.restapi.SectionApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class SectionServiceImpl implements SectionService {

    SectionApi sectionApi;
    SectionPresenter sectionPresenter;

    public SectionServiceImpl(SectionApi sectionApi, SectionPresenter sectionPresenter) {
        this.sectionApi = sectionApi;
        this.sectionPresenter = sectionPresenter;
    }

    @Override
    public void create(String name, int gradeLevelId, int adviserId) {
        sectionApi.createUser(name, gradeLevelId, adviserId).enqueue(new Callback<Section>() {
            @Override
            public void onResponse(Call<Section> call, Response<Section> rspns) {
                sectionPresenter.onSectionCreation(rspns.body());
            }

            @Override
            public void onFailure(Call<Section> call, Throwable thrwbl) {
                thrwbl.printStackTrace();
            }
        });
    }

    @Override
    public void findAll() {
        sectionApi.findAll().enqueue(new Callback<List<Section>>() {
            @Override
            public void onResponse(Call<List<Section>> call, Response<List<Section>> response) {
                sectionPresenter.UpdateSectionList(response.body());
            }

            @Override
            public void onFailure(Call<List<Section>> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
