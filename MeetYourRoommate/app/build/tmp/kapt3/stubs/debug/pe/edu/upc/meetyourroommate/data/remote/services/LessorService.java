package pe.edu.upc.meetyourroommate.data.remote.services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\'\u00a8\u0006\t"}, d2 = {"Lpe/edu/upc/meetyourroommate/data/remote/services/LessorService;", "", "fetchLessorById", "Lretrofit2/Call;", "Lpe/edu/upc/meetyourroommate/data/model/Lessor;", "id", "", "fetchLessors", "Lpe/edu/upc/meetyourroommate/data/remote/responses/LessorResponse;", "app_debug"})
public abstract interface LessorService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "lessors")
    public abstract retrofit2.Call<pe.edu.upc.meetyourroommate.data.remote.responses.LessorResponse> fetchLessors();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "lessors/{lessorId}")
    public abstract retrofit2.Call<pe.edu.upc.meetyourroommate.data.model.Lessor> fetchLessorById(@retrofit2.http.Path(value = "lessorId")
    int id);
}