package popo.moviecatalog.data.source.remote;

import android.os.Handler;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import popo.moviecatalog.data.source.remote.response.CastResponse;
import popo.moviecatalog.data.source.remote.response.GenreResponse;
import popo.moviecatalog.data.source.remote.response.MoviesResponse;
import popo.moviecatalog.utils.EspressoIdlingResource;
import popo.moviecatalog.utils.JsonHelper;

public class RemoteRepository {
    private static RemoteRepository INSTANCE;
    private final long SERVICE_LATENCY_IN_MILLIS = 2000;
    private JsonHelper jsonHelper;
    private ArrayList<MoviesResponse> list = new ArrayList<>();
    private ArrayList<MoviesResponse> listTvShow = new ArrayList<>();
    private ArrayList<MoviesResponse> listDetailMovies = new ArrayList<>();
    private ArrayList<GenreResponse> listGenreMovie = new ArrayList<>();
    private ArrayList<CastResponse> listCastMovie = new ArrayList<>();


    private RemoteRepository(JsonHelper jsonHelper) {
        this.jsonHelper = jsonHelper;
    }

    public static RemoteRepository getInstance(JsonHelper helper) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteRepository(helper);
        }
        return INSTANCE;
    }

    private ArrayList<MoviesResponse> getListTvShow() {
        return listTvShow;
    }

    public void setListTvShow(ArrayList<MoviesResponse> listTvShow) {
        this.listTvShow = listTvShow;
    }

    public ArrayList<MoviesResponse> getList() {
        return list;
    }

    public void setList(ArrayList<MoviesResponse> list) {
        this.list = list;
    }

    public ArrayList<MoviesResponse> getListDetailMovies() {
        return listDetailMovies;
    }

    public void setListDetailMovies(ArrayList<MoviesResponse> listDetailMovies) {
        this.listDetailMovies = listDetailMovies;
    }

    public ArrayList<GenreResponse> getListGenreMovie() {
        return listGenreMovie;
    }

    public void setListGenreMovie(ArrayList<GenreResponse> listGenreMovie) {
        this.listGenreMovie = listGenreMovie;
    }

    public ArrayList<CastResponse> getListCastMovie() {
        return listCastMovie;
    }

    public void setListCastMovie(ArrayList<CastResponse> listCastMovie) {
        this.listCastMovie = listCastMovie;
    }

    public LiveData<ApiResponse<List<MoviesResponse>>> getAllMoviesAsLiveData(){
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<MoviesResponse>>> resultMovie = new MutableLiveData<>();
        jsonHelper.loadMovies(list);
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            resultMovie.setValue(ApiResponse.success(getList()));
            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                EspressoIdlingResource.decrement();
            }
        }, SERVICE_LATENCY_IN_MILLIS);
        return resultMovie;
    }

    public LiveData<ApiResponse<List<MoviesResponse>>> getAllTvShowAsLiveData(){
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<MoviesResponse>>> resultMovie = new MutableLiveData<>();
        jsonHelper.loadTvShow(listTvShow);
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            resultMovie.setValue(ApiResponse.success(getListTvShow()));
            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                EspressoIdlingResource.decrement();
            }
        }, SERVICE_LATENCY_IN_MILLIS);
        return resultMovie;
    }

    public LiveData<ApiResponse<List<MoviesResponse>>> getMoviesByIdAsLiveData(String filmId){
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<MoviesResponse>>> resultMovieById = new MutableLiveData<>();
        jsonHelper.loadDetailMovies(listDetailMovies,filmId);
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            resultMovieById.setValue(ApiResponse.success(getListDetailMovies()));
            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                EspressoIdlingResource.decrement();
            }
        }, SERVICE_LATENCY_IN_MILLIS);
        return resultMovieById;
    }

    public LiveData<ApiResponse<List<MoviesResponse>>> getTvShowByIdAsLiveData(String filmId){
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<MoviesResponse>>> resultMovieById = new MutableLiveData<>();
        jsonHelper.loadDetailTvShow(listDetailMovies,filmId);
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            resultMovieById.setValue(ApiResponse.success(getListDetailMovies()));
            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                EspressoIdlingResource.decrement();
            }
        }, SERVICE_LATENCY_IN_MILLIS);
        return resultMovieById;
    }

    public LiveData<ApiResponse<List<GenreResponse>>> getGenreMoviesIdAsLiveData(String filmId){
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<GenreResponse>>> resultGenreById = new MutableLiveData<>();
        jsonHelper.loadGenreMovies(listGenreMovie,filmId);
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            resultGenreById.setValue(ApiResponse.success(getListGenreMovie()));
            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                EspressoIdlingResource.decrement();
            }
        }, SERVICE_LATENCY_IN_MILLIS);
        return resultGenreById;
    }

    public LiveData<ApiResponse<List<CastResponse>>> getCastMoviesIdAsLiveData(String filmId){
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<CastResponse>>> resultCastById = new MutableLiveData<>();
        jsonHelper.loadCastMovies(listCastMovie,filmId);
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            resultCastById.setValue(ApiResponse.success(getListCastMovie()));
            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                EspressoIdlingResource.decrement();
            }
        }, SERVICE_LATENCY_IN_MILLIS);
        return resultCastById;
    }

    public LiveData<ApiResponse<List<GenreResponse>>> getGenreTvShowIdAsLiveData(String filmId){
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<GenreResponse>>> resultGenreById = new MutableLiveData<>();
        jsonHelper.loadGenreTvShow(listGenreMovie,filmId);
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            resultGenreById.setValue(ApiResponse.success(getListGenreMovie()));
            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                EspressoIdlingResource.decrement();
            }
        }, SERVICE_LATENCY_IN_MILLIS);
        return resultGenreById;
    }

    public LiveData<ApiResponse<List<CastResponse>>> getCastTvShowIdAsLiveData(String filmId){
        EspressoIdlingResource.increment();
        MutableLiveData<ApiResponse<List<CastResponse>>> resultCastById = new MutableLiveData<>();
        jsonHelper.loadCastTvShow(listCastMovie,filmId);
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            resultCastById.setValue(ApiResponse.success(getListCastMovie()));
            if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow()) {
                EspressoIdlingResource.decrement();
            }
        }, SERVICE_LATENCY_IN_MILLIS);
        return resultCastById;
    }

}
