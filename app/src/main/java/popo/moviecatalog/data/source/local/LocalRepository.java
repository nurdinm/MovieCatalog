package popo.moviecatalog.data.source.local;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;

import java.util.List;

import popo.moviecatalog.data.source.local.entity.FilmCastEntity;
import popo.moviecatalog.data.source.local.entity.FilmEntity;
import popo.moviecatalog.data.source.local.entity.FilmGenreEntity;
import popo.moviecatalog.data.source.local.entity.TvShowEntity;
import popo.moviecatalog.data.source.local.room.MoviesDao;

public class LocalRepository {
    private static LocalRepository INSTANCE;
    private final MoviesDao mMoviesDao;

    private LocalRepository(MoviesDao mMoviesDao) {
        this.mMoviesDao = mMoviesDao;
    }

    public static LocalRepository getInstance(MoviesDao moviesDao) {
        if (INSTANCE == null) {
            INSTANCE = new LocalRepository(moviesDao);
        }
        return INSTANCE;
    }

    public LiveData<List<FilmEntity>> getAllMovies() {
        return mMoviesDao.getMovies();
    }

    public void insertMovies(List<FilmEntity> movies) {
        mMoviesDao.insertMovies(movies);
    }

    public LiveData<FilmEntity> getMoviesById(final String moviesId) {
        return mMoviesDao.getMoviesById(moviesId);
    }

    public LiveData<List<TvShowEntity>> getAllTvShow() {
        return mMoviesDao.getTvShow();
    }

    public LiveData<TvShowEntity> getTvShowById(final String moviesId) {
        return mMoviesDao.getTvShowById(moviesId);
    }

    public void insertTvShow(List<TvShowEntity> movies) {
        mMoviesDao.insertTvShow(movies);
    }

    public LiveData<List<FilmCastEntity>> getAllCastMovie(final String moviesId) {
        return mMoviesDao.getCastMoviesById(moviesId);
    }

    public LiveData<List<FilmGenreEntity>> getAllGenreMovie(String moviesId) {
        return mMoviesDao.getGenreMoviesById(moviesId);
    }

    public void insertGenreMovies(List<FilmGenreEntity> filmGenreEntities) {
        mMoviesDao.insertGenretMovies(filmGenreEntities);
    }

    public void insertCastMovies(List<FilmCastEntity> filmCastEntities) {
        mMoviesDao.insertCastMovies(filmCastEntities);
    }

    public void updateMovies(String runtime, String revenue,String filmId) {
        mMoviesDao.updateMoviesById(runtime, revenue,filmId);
    }

    public void updateTvShow(String runtime, String revenue,String filmId) {
        mMoviesDao.updateTvShowById(runtime, revenue,filmId);
    }

    public void setMoviesFavorite(FilmEntity filmEntity, boolean newState) {
        filmEntity.setFavorited(newState);
        mMoviesDao.updateMovies(filmEntity);
    }

    public DataSource.Factory<Integer, FilmEntity> getFavoriteMovies() {
        return mMoviesDao.getFavoriteMovies();
    }

    public void setTvShowFavorite(TvShowEntity tvShowEntity, boolean newState) {
        tvShowEntity.setFavorited(newState);
        mMoviesDao.updateTvShow(tvShowEntity);
    }

    public DataSource.Factory<Integer, TvShowEntity> getFavoriteTvShow() {
        return mMoviesDao.getFavoriteTvShow();
    }
}
