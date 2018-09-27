
package com.minnijay.ui.project.restapi;

import com.minnijay.ui.project.dto.Attendance;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 *
 * @author MinniJay
 */
public interface AttendanceApi {

    @POST("api/attendance/create")
    Call<Attendance> create(@Query("date")long date, @Query("studentId")int studentId,@Query("remarkId") int remarkId);
    
    @GET("api/attendance/findAll")
    Call<List<Attendance>> findAll();
    
    @GET("api/findById")
    Call<Attendance> findByID();
}
