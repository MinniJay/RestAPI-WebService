package com.minnijay.ui.project.service;

import com.minnijay.ui.project.dto.Student;
import com.minnijay.ui.project.restapi.StudentApi;
import com.minnijay.ui.project.service.presenter.StudentPresenter;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class StudentServiceImpl implements StudentService {

    StudentApi studentApi;
    StudentPresenter studentPresenter;

    public StudentServiceImpl(StudentApi studentApi, StudentPresenter studentPresenter) {
        this.studentApi = studentApi;
        this.studentPresenter = studentPresenter;
    }
    
    @Override
    public void create(String name, int sectionId) {
        studentApi.create(name, sectionId).enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> rspns) {
                studentPresenter.onStudentCreation(rspns.body());
            }

            @Override
            public void onFailure(Call<Student> call, Throwable thrwbl) {
                thrwbl.printStackTrace();
            }
        });
    }

    @Override
    public void findAll() {
        studentApi.findAll().enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> rspns) {
                studentPresenter.updateStudentDisplay(rspns.body());
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable thrwbl) {
                thrwbl.printStackTrace();
            }
        });
    }

}
