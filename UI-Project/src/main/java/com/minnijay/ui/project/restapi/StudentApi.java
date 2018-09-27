
package com.minnijay.ui.project.restapi;

import com.minnijay.ui.project.dto.Student;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 *
 * @author MinniJay
 */
public interface StudentApi {
    
    @POST("api/student/create")
    Call<Student> create(@Query(value = "name") String name, @Query(value = "sectionId") int sectionId);
    
    @GET("api/student/findAll")
    Call<List<Student>> findAll();

}
