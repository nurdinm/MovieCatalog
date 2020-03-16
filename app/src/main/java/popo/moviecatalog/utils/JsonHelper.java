package popo.moviecatalog.utils;

import android.app.Application;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import popo.moviecatalog.BuildConfig;
import popo.moviecatalog.data.source.remote.response.CastResponse;
import popo.moviecatalog.data.source.remote.response.GenreResponse;
import popo.moviecatalog.data.source.remote.response.MoviesResponse;

public class JsonHelper {
    private static final String API_KEY = BuildConfig.API_KEY;
    private static final String URL_MOVIES = BuildConfig.URL_MOVIES;
    private static final String URL_TVSHOW = BuildConfig.URL_TVSHOW;
    private static final String URL_DETAILMOVIE = BuildConfig.URL_DETAILMOVIE;
    private static final String URL_DETAILTVSHOW = BuildConfig.URL_DETAILTVSHOW;

    private Application application;

    public JsonHelper(Application application) {
        this.application = application;
        AndroidNetworking.initialize(application);
    }

    public void loadMovies(ArrayList<MoviesResponse> list) {
        list.clear();
        String url = URL_MOVIES+API_KEY;
        Log.e("MOVIES",url);
        AndroidNetworking.get(url)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray resultArray = response.getJSONArray("results");
                            for (int i = 0; i < resultArray.length(); i++) {
                                JSONObject movie = resultArray.getJSONObject(i);
                                MoviesResponse moviesResponse = new MoviesResponse();
                                Log.e("MOVIE", movie.getString("vote_average"));
                                moviesResponse.setFilmId(movie.getString("id"));
                                moviesResponse.setTitle(movie.getString("title"));
                                moviesResponse.setDesc(movie.getString("overview"));
                                moviesResponse.setTgl(movie.getString("release_date"));
                                moviesResponse.setImg(movie.getString("poster_path"));
                                moviesResponse.setVote(movie.getString("vote_average"));
                                moviesResponse.setLang(movie.getString("original_language"));

                                list.add(moviesResponse);
                            }

                        } catch (JSONException e) {
                            Log.e("ERROR DATA",e.getMessage());
                        }
                    }
                    @Override
                    public void onError(ANError error) {
                        Log.e("ERROR CONNECTION",error.getMessage());
                    }
                });

    }

    public void loadTvShow(ArrayList<MoviesResponse> list) {
        list.clear();
        String url = URL_TVSHOW+API_KEY;
        Log.e("MOVIES",url);
        AndroidNetworking.get(url)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray resultArray = response.getJSONArray("results");
                            for (int i = 0; i < resultArray.length(); i++) {
                                JSONObject movie = resultArray.getJSONObject(i);
                                MoviesResponse moviesResponse = new MoviesResponse();
                                Log.e("MOVIE", movie.getString("original_name"));
                                moviesResponse.setFilmId(movie.getString("id"));
                                moviesResponse.setTitle(movie.getString("original_name"));
                                moviesResponse.setDesc(movie.getString("overview"));
                                moviesResponse.setTgl(movie.getString("first_air_date"));
                                moviesResponse.setImg(movie.getString("poster_path"));
                                moviesResponse.setVote(movie.getString("vote_average"));
                                moviesResponse.setLang(movie.getString("original_language"));

                                list.add(moviesResponse);
                            }

                        } catch (JSONException e) {
                            Log.e("ERROR DATA",e.getMessage());
                        }
                    }
                    @Override
                    public void onError(ANError error) {
                        Log.e("ERROR CONNECTION",error.getMessage());
                    }
                });

    }

    public void loadDetailMovies(ArrayList<MoviesResponse> list,String filmId) {
        list.clear();
        String url = URL_DETAILMOVIE+filmId+"?api_key="+API_KEY;
        Log.e("MOVIES",url);
        AndroidNetworking.get(url)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject movie) {
                        try {
                            MoviesResponse moviesResponse = new MoviesResponse();
                            moviesResponse.setFilmId(movie.getString("id"));
                            moviesResponse.setTitle(movie.getString("original_title"));
                            moviesResponse.setDesc(movie.getString("overview"));
                            moviesResponse.setTgl(movie.getString("release_date"));
                            moviesResponse.setImg(movie.getString("poster_path"));
                            moviesResponse.setRevenue(movie.getString("revenue"));
                            moviesResponse.setLang(movie.getString("original_language"));
                            moviesResponse.setRuntime(movie.getString("runtime"));

                            list.add(moviesResponse);

                        } catch (JSONException e) {
                            Log.e("ERROR DATA",e.getMessage());
                        }
                    }
                    @Override
                    public void onError(ANError error) {
                        Log.e("ERROR CONNECTION",error.getMessage());
                    }
                });

    }

    public void loadDetailTvShow(ArrayList<MoviesResponse> list,String filmId) {
        list.clear();
        String url = URL_DETAILTVSHOW+filmId+"?api_key="+API_KEY;
        Log.e("MOVIES",url);
        AndroidNetworking.get(url)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject movie) {
                        try {
                            MoviesResponse moviesResponse = new MoviesResponse();
                            moviesResponse.setFilmId(movie.getString("id"));
                            moviesResponse.setTitle(movie.getString("original_name"));
                            moviesResponse.setDesc(movie.getString("overview"));
                            moviesResponse.setTgl(movie.getString("first_air_date"));
                            moviesResponse.setImg(movie.getString("poster_path"));
                            moviesResponse.setRevenue("-");
                            moviesResponse.setLang(movie.getString("original_language"));
                            moviesResponse.setRuntime(String.valueOf(movie.getJSONArray("episode_run_time").getString(0)));

                            list.add(moviesResponse);

                        } catch (JSONException e) {
                            Log.e("ERROR DATA",e.getMessage());
                        }
                    }
                    @Override
                    public void onError(ANError error) {
                        Log.e("ERROR CONNECTION",error.getMessage());
                    }
                });

    }

    public void loadGenreMovies(ArrayList<GenreResponse> list, String filmId) {
        list.clear();
        String url = URL_DETAILMOVIE+filmId+"?api_key="+API_KEY;
        Log.e("MOVIESGENRE",url);
        AndroidNetworking.get(url)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray resultArray = response.getJSONArray("genres");
                            for (int i = 0; i < resultArray.length(); i++) {
                                JSONObject item = resultArray.getJSONObject(i);
                                GenreResponse genreResponse = new GenreResponse();
                                genreResponse.setId(item.getString("id"));
                                genreResponse.setGenre(item.getString("name"));
                                list.add(genreResponse);
                            }

                        } catch (JSONException e) {
                            Log.e("ERROR DATA",e.getMessage());
                        }
                    }
                    @Override
                    public void onError(ANError error) {
                        Log.e("ERROR CONNECTION",error.getMessage());
                    }
                });

    }

    public void loadCastMovies(ArrayList<CastResponse> list, String filmId) {
        list.clear();
        String url = URL_DETAILMOVIE+filmId+"/credits?api_key="+API_KEY;
        Log.e("MOVIES",url);
        AndroidNetworking.get(url)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray resultArray = response.getJSONArray("cast");
                            for (int i = 0; i < 6; i++) {
                                JSONObject item = resultArray.getJSONObject(i);
                                CastResponse castResponse = new CastResponse();
                                castResponse.setId(item.getString("id"));
                                castResponse.setImg(item.getString("profile_path"));
                                castResponse.setName(item.getString("name"));
                                castResponse.setTitle(item.getString("character"));
                                list.add(castResponse);
                            }

                        } catch (JSONException e) {
                            Log.e("ERROR DATA",e.getMessage());
                        }
                    }
                    @Override
                    public void onError(ANError error) {
                        Log.e("ERROR CONNECTION",error.getMessage());
                    }
                });

    }

    public void loadGenreTvShow(ArrayList<GenreResponse> list, String filmId) {
        list.clear();
        String url = URL_DETAILTVSHOW+filmId+"?api_key="+API_KEY;
        Log.e("MOVIES",url);
        AndroidNetworking.get(url)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray resultArray = response.getJSONArray("genres");
                            for (int i = 0; i < resultArray.length(); i++) {
                                JSONObject item = resultArray.getJSONObject(i);
                                GenreResponse genreResponse = new GenreResponse();
                                genreResponse.setId(item.getString("id"));
                                genreResponse.setGenre(item.getString("name"));
                                list.add(genreResponse);
                            }

                        } catch (JSONException e) {
                            Log.e("ERROR DATA",e.getMessage());
                        }
                    }
                    @Override
                    public void onError(ANError error) {
                        Log.e("ERROR CONNECTION",error.getMessage());
                    }
                });

    }

    public void loadCastTvShow(ArrayList<CastResponse> list, String filmId) {
        list.clear();
        String url = URL_DETAILTVSHOW+filmId+"/credits?api_key="+API_KEY;
        Log.e("MOVIES",url);
        AndroidNetworking.get(url)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray resultArray = response.getJSONArray("cast");
                            for (int i = 0; i < 6; i++) {
                                JSONObject item = resultArray.getJSONObject(i);
                                CastResponse castResponse = new CastResponse();
                                castResponse.setId(item.getString("id"));
                                castResponse.setImg(item.getString("profile_path"));
                                castResponse.setName(item.getString("name"));
                                castResponse.setTitle(item.getString("character"));
                                list.add(castResponse);
                            }

                        } catch (JSONException e) {
                            Log.e("ERROR DATA",e.getMessage());
                        }
                    }
                    @Override
                    public void onError(ANError error) {
                        Log.e("ERROR CONNECTION",error.getMessage());
                    }
                });

    }
}
