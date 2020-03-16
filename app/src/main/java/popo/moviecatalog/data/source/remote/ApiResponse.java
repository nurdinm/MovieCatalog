package popo.moviecatalog.data.source.remote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static popo.moviecatalog.data.source.remote.StatusResponse.EMPTY;
import static popo.moviecatalog.data.source.remote.StatusResponse.ERROR;
import static popo.moviecatalog.data.source.remote.StatusResponse.SUCCESS;


public class ApiResponse<T> {

    @NonNull
    public final StatusResponse status;

    @Nullable
    public final String message;

    @Nullable
    public final T body;

    public ApiResponse(@NonNull StatusResponse status, @Nullable T body, @Nullable String message) {
        this.status = status;
        this.body = body;
        this.message = message;
    }

    public static <T> ApiResponse<T> success(@Nullable T body) {
        return new ApiResponse<>(SUCCESS, body, null);
    }

    public static <T> ApiResponse<T> empty(String msg, @Nullable T body) {
        return new ApiResponse<>(EMPTY, body, msg);
    }

    public static <T> ApiResponse<T> error(String msg, @Nullable T body) {
        return new ApiResponse<>(ERROR, body, msg);
    }

}

