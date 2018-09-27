package com.minnijay.ui.project.restapi;


import com.minnijay.ui.project.dto.GradeLevel;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 *
 * @author MinniJay
 */
public interface GradeLevelApi {

    @GET("api/gradelevel/findAll")
    Call<List<GradeLevel>> findAll();
    
    @GET("api/gradelevel/findByName/{name}")
     Call<GradeLevel> findByName(@Path("name") String name);

    @POST("api/gradelevel/create")
    Call<GradeLevel> createUser(@Query(value = "name") String name);
    
    @PUT("api/gradelevel/addSection")
    Call<GradeLevel> addSection(@Query(value = "gradeLevelId") int gradeLevelId,@Query(value = "sectionId") int sectionId);
    
}
