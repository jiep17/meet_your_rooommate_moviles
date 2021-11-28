package pe.edu.upc.meetyourroommate.data.remote.services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\'J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\nH\'\u00a8\u0006\u000b"}, d2 = {"Lpe/edu/upc/meetyourroommate/data/remote/services/PropertyService;", "", "createProperty", "Lretrofit2/Call;", "Lpe/edu/upc/meetyourroommate/data/model/Property;", "requestBody", "fetchProperties", "Lpe/edu/upc/meetyourroommate/data/remote/responses/PropertyResponse;", "fetchPropertyById", "id", "", "app_debug"})
public abstract interface PropertyService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "properties")
    public abstract retrofit2.Call<pe.edu.upc.meetyourroommate.data.remote.responses.PropertyResponse> fetchProperties();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "properties/{propertyId}")
    public abstract retrofit2.Call<pe.edu.upc.meetyourroommate.data.model.Property> fetchPropertyById(@retrofit2.http.Path(value = "propertyId")
    int id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "properties")
    @retrofit2.http.Headers(value = {"Content-Type: application/json"})
    public abstract retrofit2.Call<pe.edu.upc.meetyourroommate.data.model.Property> createProperty(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    pe.edu.upc.meetyourroommate.data.model.Property requestBody);
}