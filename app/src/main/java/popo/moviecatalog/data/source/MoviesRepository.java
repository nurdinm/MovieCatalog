package popo.moviecatalog.data.source;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import java.util.ArrayList;
import java.util.List;

import popo.moviecatalog.data.source.local.LocalRepository;
import popo.moviecatalog.data.source.local.entity.FilmCastEntity;
import popo.moviecatalog.data.source.local.entity.FilmEntity;
import popo.moviecatalog.data.source.local.entity.FilmGenreEntity;
import popo.moviecatalog.data.source.local.entity.TvShowEntity;
import popo.moviecatalog.data.source.remote.ApiResponse;
import popo.moviecatalog.data.source.remote.RemoteRepository;
import popo.moviecatalog.data.source.remote.response.CastResponse;
import popo.moviecatalog.data.source.remote.response.GenreResponse;
import popo.moviecatalog.data.source.remote.response.MoviesResponse;
import popo.moviecatalog.utils.AppExecutors;
import popo.moviecatalog.vo.Resource;

public class MoviesRepository implements MoviesDataSource {
    private volatile static MoviesRepository INSTANCE = null;

    private final LocalRepository localRepository;
    private final RemoteRepository remoteRepository;
    private final AppExecutors appExecutors;

    private MoviesRepository(LocalRepository localRepository,RemoteRepository remoteRepository,AppExecutors appExecutors) {
        this.localRepository = localRepository;
        this.remoteRepository = remoteRepository;
        this.appExecutors = appExecutors;
    }

    public static MoviesRepository getInstance(LocalRepository localRepository,RemoteRepository remoteData,AppExecutors appExecutors) {
        if (INSTANCE == null) {
            synchronized (MoviesRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MoviesRepository(localRepository,remoteData,appExecutors);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<Resource<List<FilmEntity>>> getAllMovies() {
        return new NetworkBoundResource<List<FilmEntity>, List<MoviesResponse>>(appExecutors){

            @Override
            protected LiveData<List<FilmEntity>> loadFromDB() {
                return localRepository.getAllMovies();
            }

            @Override
            protected Boolean shouldFetch(List<FilmEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<MoviesResponse>>> createCall() {
                return remoteRepository.getAllMoviesAsLiveData();
            }

            @Override
            protected void saveCallResult(List<MoviesResponse> response) {
                List<FilmEntity> filmEntities = new ArrayList<>();
                for (MoviesResponse moviesResponse : response) {

                    filmEntities.add(new FilmEntity(moviesResponse.getFilmId(),
                            moviesResponse.getTitle(),
                            moviesResponse.getVote(),
                            moviesResponse.getDesc(),
                            moviesResponse.getTgl(),
                            moviesResponse.getImg(),
                            moviesResponse.getLang()));
                }
                localRepository.insertMovies(filmEntities);
            }
        }.asLiveData();

    }

    @Override
    public LiveData<Resource<FilmEntity>> getDetailMovies(String filmId) {
        return new NetworkBoundResource<FilmEntity, List<MoviesResponse>>(appExecutors){

            @Override
            protected LiveData<FilmEntity> loadFromDB() {
                return localRepository.getMoviesById(filmId);
            }

            @Override
            protected Boolean shouldFetch(FilmEntity data) {
                return (data.getRuntime() == null);
            }

            @Override
            protected LiveData<ApiResponse<List<MoviesResponse>>> createCall() {
                return remoteRepository.getMoviesByIdAsLiveData(filmId);
            }

            @Override
            protected void saveCallResult(List<MoviesResponse> moviesResponses) {
                localRepository.updateMovies(moviesResponses.get(0).getRuntime(),moviesResponses.get(0).getRevenue(),filmId);
            }
        }.asLiveData();

    }

    @Override
    public LiveData<Resource<List<TvShowEntity>>> getAllTvShow() {
        return new NetworkBoundResource<List<TvShowEntity>, List<MoviesResponse>>(appExecutors){

            @Override
            protected LiveData<List<TvShowEntity>> loadFromDB() {
                return localRepository.getAllTvShow();
            }

            @Override
            protected Boolean shouldFetch(List<TvShowEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<MoviesResponse>>> createCall() {
                return remoteRepository.getAllTvShowAsLiveData();
            }

            @Override
            protected void saveCallResult(List<MoviesResponse> response) {
                List<TvShowEntity> tvShowEntities = new ArrayList<>();
                for (MoviesResponse moviesResponse : response) {

                    tvShowEntities.add(new TvShowEntity(moviesResponse.getFilmId(),
                            moviesResponse.getTitle(),
                            moviesResponse.getVote(),
                            moviesResponse.getDesc(),
                            moviesResponse.getTgl(),
                            moviesResponse.getImg(),
                            moviesResponse.getLang()));
                }
                localRepository.insertTvShow(tvShowEntities);
            }
        }.asLiveData();

    }

    @Override
    public LiveData<Resource<TvShowEntity>> getDetailTvShow(String filmId) {
        return new NetworkBoundResource<TvShowEntity, List<MoviesResponse>>(appExecutors){

            @Override
            protected LiveData<TvShowEntity> loadFromDB() {
                return localRepository.getTvShowById(filmId);
            }

            @Override
            protected Boolean shouldFetch(TvShowEntity data) {
                return (data.getRuntime() == null);
            }

            @Override
            protected LiveData<ApiResponse<List<MoviesResponse>>> createCall() {
                return remoteRepository.getTvShowByIdAsLiveData(filmId);
            }

            @Override
            protected void saveCallResult(List<MoviesResponse> moviesResponses) {
                localRepository.updateTvShow(moviesResponses.get(0).getRuntime(),moviesResponses.get(0).getRevenue(),filmId);
            }
        }.asLiveData();

    }


    @Override
    public LiveData<Resource<List<FilmGenreEntity>>> getAllGenreMovieShow(String filmId) {
        return new NetworkBoundResource<List<FilmGenreEntity>, List<GenreResponse>>(appExecutors){

            @Override
            protected LiveData<List<FilmGenreEntity>> loadFromDB() {
                return localRepository.getAllGenreMovie(filmId);
            }

            @Override
            protected Boolean shouldFetch(List<FilmGenreEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<GenreResponse>>> createCall() {
                return remoteRepository.getGenreMoviesIdAsLiveData(filmId);
            }

            @Override
            protected void saveCallResult(List<GenreResponse> genreResponses) {
                List<FilmGenreEntity> mGenre = new ArrayList<>();
                for (GenreResponse genreResponse : genreResponses) {

                    mGenre.add(new FilmGenreEntity(
                            genreResponse.getId(),
                            filmId,
                            genreResponse.getGenre()));
                }
                localRepository.insertGenreMovies(mGenre);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<List<FilmCastEntity>>> getAllCastMovieShow(String filmId) {
        return new NetworkBoundResource<List<FilmCastEntity>, List<CastResponse>>(appExecutors) {
            @Override
            protected LiveData<List<FilmCastEntity>> loadFromDB() {
                return localRepository.getAllCastMovie(filmId);
            }

            @Override
            protected Boolean shouldFetch(List<FilmCastEntity> filmCastEntity) {
                return (filmCastEntity == null || filmCastEntity.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<CastResponse>>> createCall() {
                return remoteRepository.getCastMoviesIdAsLiveData(filmId);
            }

            @Override
            protected void saveCallResult(List<CastResponse> castResponses) {

                List<FilmCastEntity> filmCastEntities = new ArrayList<>();

                for (CastResponse castResponse : castResponses) {
                    filmCastEntities.add(new FilmCastEntity(castResponse.getId(),filmId, castResponse.getImg(), castResponse.getName(), castResponse.getTitle()));
                }

                localRepository.insertCastMovies(filmCastEntities);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<List<FilmGenreEntity>>> getAllGenreTvShow(String filmId) {
        return new NetworkBoundResource<List<FilmGenreEntity>, List<GenreResponse>>(appExecutors){

            @Override
            protected LiveData<List<FilmGenreEntity>> loadFromDB() {
                return localRepository.getAllGenreMovie(filmId);
            }

            @Override
            protected Boolean shouldFetch(List<FilmGenreEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<GenreResponse>>> createCall() {
                return remoteRepository.getGenreTvShowIdAsLiveData(filmId);
            }

            @Override
            protected void saveCallResult(List<GenreResponse> genreResponses) {
                List<FilmGenreEntity> mGenre = new ArrayList<>();
                for (GenreResponse genreResponse : genreResponses) {

                    mGenre.add(new FilmGenreEntity(
                            genreResponse.getId(),
                            filmId,
                            genreResponse.getGenre()));
                }
                localRepository.insertGenreMovies(mGenre);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<List<FilmCastEntity>>> getAllCastTvShow(String filmId) {
        return new NetworkBoundResource<List<FilmCastEntity>, List<CastResponse>>(appExecutors) {
            @Override
            protected LiveData<List<FilmCastEntity>> loadFromDB() {
                return localRepository.getAllCastMovie(filmId);
            }

            @Override
            protected Boolean shouldFetch(List<FilmCastEntity> filmCastEntity) {
                return (filmCastEntity == null || filmCastEntity.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<CastResponse>>> createCall() {
                return remoteRepository.getCastTvShowIdAsLiveData(filmId);
            }

            @Override
            protected void saveCallResult(List<CastResponse> castResponses) {

                List<FilmCastEntity> filmCastEntities = new ArrayList<>();

                for (CastResponse castResponse : castResponses) {
                    filmCastEntities.add(new FilmCastEntity(castResponse.getId(),filmId, castResponse.getImg(), castResponse.getName(), castResponse.getTitle()));
                }

                localRepository.insertCastMovies(filmCastEntities);
            }
        }.asLiveData();
    }

    @Override
    public void setMoviesFavorit(FilmEntity filmEntity, boolean state) {
        Runnable runnable = () -> localRepository.setMoviesFavorite(filmEntity, state);

        appExecutors.diskIO().execute(runnable);
    }

    @Override
    public LiveData<Resource<PagedList<FilmEntity>>> getFavoriteMovies() {
        return new NetworkBoundResource<PagedList<FilmEntity>, List<MoviesResponse>>(appExecutors) {
            @Override
            protected LiveData<PagedList<FilmEntity>> loadFromDB() {
                return new LivePagedListBuilder<>(localRepository.getFavoriteMovies(), 20).build();
            }

            @Override
            protected Boolean shouldFetch(PagedList<FilmEntity> data) {
                return false;
            }

            @Override
            protected LiveData<ApiResponse<List<MoviesResponse>>> createCall() {
                return null;
            }

            @Override
            protected void saveCallResult(List<MoviesResponse> data) {

            }
        }.asLiveData();
    }

    @Override
    public void setTvShowFavorite(TvShowEntity tvShowEntity, boolean state) {
        Runnable runnable = () -> localRepository.setTvShowFavorite(tvShowEntity, state);

        appExecutors.diskIO().execute(runnable);
    }

    @Override
    public LiveData<Resource<PagedList<TvShowEntity>>> getFavoriteTvShow() {
        return new NetworkBoundResource<PagedList<TvShowEntity>, List<MoviesResponse>>(appExecutors) {
            @Override
            protected LiveData<PagedList<TvShowEntity>> loadFromDB() {
                return new LivePagedListBuilder<>(localRepository.getFavoriteTvShow(), 20).build();
            }

            @Override
            protected Boolean shouldFetch(PagedList<TvShowEntity> data) {
                return false;
            }

            @Override
            protected LiveData<ApiResponse<List<MoviesResponse>>> createCall() {
                return null;
            }

            @Override
            protected void saveCallResult(List<MoviesResponse> data) {

            }
        }.asLiveData();
    }
}
