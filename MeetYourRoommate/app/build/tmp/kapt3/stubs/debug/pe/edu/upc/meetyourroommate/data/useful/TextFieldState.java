package pe.edu.upc.meetyourroommate.data.useful;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B1\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0007J\u0006\u0010\u001d\u001a\u00020\u001eJ\n\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0016J\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0005J\u0006\u0010\"\u001a\u00020\u0005R+\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00058B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u0010\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR+\u0010\u0013\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\u0014\u0010\u0016\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u000bR+\u0010\u0017\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00048F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lpe/edu/upc/meetyourroommate/data/useful/TextFieldState;", "", "validator", "Lkotlin/Function1;", "", "", "errorFor", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "<set-?>", "displayError", "getDisplayError", "()Z", "setDisplayError", "(Z)V", "displayError$delegate", "Landroidx/compose/runtime/MutableState;", "isFocuseDirty", "setFocuseDirty", "isFocuseDirty$delegate", "isFocused", "setFocused", "isFocused$delegate", "isValid", "text", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "text$delegate", "enableShowErrors", "", "getError", "onFocusedChange", "focused", "showErrors", "app_debug"})
public class TextFieldState {
    private final kotlin.jvm.functions.Function1<java.lang.String, java.lang.Boolean> validator = null;
    private final kotlin.jvm.functions.Function1<java.lang.String, java.lang.String> errorFor = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState text$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState isFocuseDirty$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState isFocused$delegate = null;
    private final androidx.compose.runtime.MutableState displayError$delegate = null;
    
    public TextFieldState() {
        super();
    }
    
    public TextFieldState(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, java.lang.Boolean> validator, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, java.lang.String> errorFor) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getText() {
        return null;
    }
    
    public final void setText(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean isFocuseDirty() {
        return false;
    }
    
    public final void setFocuseDirty(boolean p0) {
    }
    
    public final boolean isFocused() {
        return false;
    }
    
    public final void setFocused(boolean p0) {
    }
    
    private final boolean getDisplayError() {
        return false;
    }
    
    private final void setDisplayError(boolean p0) {
    }
    
    public boolean isValid() {
        return false;
    }
    
    public final void onFocusedChange(boolean focused) {
    }
    
    public final void enableShowErrors() {
    }
    
    public final boolean showErrors() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getError() {
        return null;
    }
}