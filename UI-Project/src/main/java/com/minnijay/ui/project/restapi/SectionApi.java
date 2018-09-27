
package com.minnijay.ui.project.restapi;

import com.minnijay.ui.project.dto.Section;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;;
import retrofit2.http.Query;

/**
 *
 * @author MinniJay
 */
public interface SectionApi {
    
    @GET("api/section/findAll")
    Call<List<Section>> findAll();
    
    @POST("api/section/create")
    Call<Section> createUser(@Query(value = "name") String name, @Query(value = "gradeLevelId") int gradeLevelId, @Query(value = "adviserId") int adviserId);
}
