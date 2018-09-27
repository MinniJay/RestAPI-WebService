package com.minnijay.ui.project.restapi;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 *
 * @author MinniJay
 */
public enum ServiceHelper {
    
    INSTANCE;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://localhost:8080")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();
 
    public GradeLevelApi gradeLevelService(){
       return retrofit.create(GradeLevelApi.class);
    }
    
     public TeacherApi teacherService(){
       return retrofit.create(TeacherApi.class);
    }
     
     public SectionApi sectionApi(){
         return retrofit.create(SectionApi.class);
     }
     
     public StudentApi studentApi(){
         return retrofit.create(StudentApi.class);
     }
     
     public AttendanceApi attendanceApi(){
         return retrofit.create(AttendanceApi.class);
     }

     public RemarkApi remarkApi(){
         return retrofit.create(RemarkApi.class);
     }
}
