
package com.minnijay.ui.project.restapi;

import com.minnijay.ui.project.dto.Remark;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 *
 * @author MinniJay
 */
public interface RemarkApi {

    @POST("api/remark/create")
    Call<Remark> create(@Body Remark remark);
    
    @GET("api/remark/findAll")
    Call<List<Remark>> findAll();
    
    @GET("api/remark/findById")
    Call<Remark> findById(@Query("id") int id);
}
