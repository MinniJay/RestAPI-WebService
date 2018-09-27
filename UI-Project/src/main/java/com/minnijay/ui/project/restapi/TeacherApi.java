package com.minnijay.ui.project.restapi;

import com.minnijay.ui.project.dto.Teacher;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 *
 * @author MinniJay
 */

public interface TeacherApi {

    @GET("api/teacher/findAll")
    Call<List<Teacher>> findAll();
    
    @POST("api/teacher/create")
     Call<Teacher> createUser(@Query(value = "name") String name);
}
