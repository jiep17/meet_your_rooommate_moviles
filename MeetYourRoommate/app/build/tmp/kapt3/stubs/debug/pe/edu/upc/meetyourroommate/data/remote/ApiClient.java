package pe.edu.upc.meetyourroommate.data.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\bJ\u0006\u0010\u0011\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\fJ\u0006\u0010\u0013\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lpe/edu/upc/meetyourroommate/data/remote/ApiClient;", "", "()V", "API_BASE_URL", "", "friendRequestService", "Lpe/edu/upc/meetyourroommate/data/remote/services/FriendRequestService;", "lessorService", "Lpe/edu/upc/meetyourroommate/data/remote/services/LessorService;", "propertyService", "Lpe/edu/upc/meetyourroommate/data/remote/services/PropertyService;", "studentService", "Lpe/edu/upc/meetyourroommate/data/remote/services/StudentService;", "userService", "Lpe/edu/upc/meetyourroommate/data/remote/services/UserService;", "buildFriendRequest", "buildLessor", "buildProperty", "buildStudent", "buildUser", "app_debug"})
public final class ApiClient {
    @org.jetbrains.annotations.NotNull()
    public static final pe.edu.upc.meetyourroommate.data.remote.ApiClient INSTANCE = null;
    private static final java.lang.String API_BASE_URL = "https://meetyourroommateapi.herokuapp.com/api/";
    private static pe.edu.upc.meetyourroommate.data.remote.services.PropertyService propertyService;
    private static pe.edu.upc.meetyourroommate.data.remote.services.LessorService lessorService;
    private static pe.edu.upc.meetyourroommate.data.remote.services.StudentService studentService;
    private static pe.edu.upc.meetyourroommate.data.remote.services.UserService userService;
    private static pe.edu.upc.meetyourroommate.data.remote.services.FriendRequestService friendRequestService;
    
    private ApiClient() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final pe.edu.upc.meetyourroommate.data.remote.services.PropertyService buildProperty() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final pe.edu.upc.meetyourroommate.data.remote.services.LessorService buildLessor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final pe.edu.upc.meetyourroommate.data.remote.services.StudentService buildStudent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final pe.edu.upc.meetyourroommate.data.remote.services.UserService buildUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final pe.edu.upc.meetyourroommate.data.remote.services.FriendRequestService buildFriendRequest() {
        return null;
    }
}