package com.minnijay.ui.project.service;

import com.minnijay.ui.project.dto.Remark;
import com.minnijay.ui.project.restapi.RemarkApi;
import com.minnijay.ui.project.service.presenter.RemarkPresenter;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RemarkServiceImpl implements RemarkService {

    RemarkApi remarkApi;
    RemarkPresenter remarkPresenter;

    public RemarkServiceImpl(RemarkApi remarkApi, RemarkPresenter remarkPresenter) {
        this.remarkApi = remarkApi;
        this.remarkPresenter = remarkPresenter;
    }
    
    
    
    @Override
    public void create(Remark remark) {
        remarkApi.create(remark).enqueue(new Callback<Remark>() {
            @Override
            public void onResponse(Call<Remark> call, Response<Remark> rspns) {
                remarkPresenter.onRemarkCreation(rspns.body());
            }

            @Override
            public void onFailure(Call<Remark> call, Throwable thrwbl) {
                thrwbl.printStackTrace();
            }
        });
    }

    @Override
    public void findAll() {
        remarkApi.findAll().enqueue(new Callback<List<Remark>>() {
            @Override
            public void onResponse(Call<List<Remark>> call, Response<List<Remark>> rspns) {
                remarkPresenter.updateDisplayRemark(rspns.body());
            }

            @Override
            public void onFailure(Call<List<Remark>> call, Throwable thrwbl) {
                thrwbl.printStackTrace();
            }
        });
    }

    @Override
    public void findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
