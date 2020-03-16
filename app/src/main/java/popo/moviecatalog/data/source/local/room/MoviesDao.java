package popo.moviecatalog.data.source.local.room;

import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import popo.moviecatalog.data.source.local.entity.FilmCastEntity;
import popo.moviecatalog.data.source.local.entity.FilmEntity;
import popo.moviecatalog.data.source.local.entity.FilmGenreEntity;
import popo.moviecatalog.data.source.local.entity.TvShowEntity;

@Dao
public interface MoviesDao {
    @WorkerThread
    @Query("select * from moviesentities")
    LiveData<List<FilmEntity>> getMovies();

    @Query("SELECT * FROM moviesentities where favorited = 1")
    DataSource.Factory<Integer, FilmEntity> getFavoriteMovies();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertMovies(List<FilmEntity> movies);

    @Query("UPDATE moviesentities SET runtime = :runtime,revenue = :revenue  WHERE filmId = :filmId")
    int updateMoviesById(String runtime, String revenue,String filmId);

    @Update(onConflict = OnConflictStrategy.FAIL)
    int updateMovies(FilmEntity filmEntity);

    @Query("select * from tvshowentities")
    LiveData<List<TvShowEntity>> getTvShow();

    @Query("SELECT * FROM tvshowentities where favorited = 1")
    DataSource.Factory<Integer, TvShowEntity> getFavoriteTvShow();

    @Update(onConflict = OnConflictStrategy.FAIL)
    int updateTvShow(TvShowEntity tvShowEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertTvShow(List<TvShowEntity> movies);

    @Query("UPDATE tvshowentities SET runtime = :runtime,revenue = :revenue  WHERE filmId = :filmId")
    int updateTvShowById(String runtime, String revenue,String filmId);

    @Query("SELECT *  FROM moviesentities WHERE filmId = :filmId")
    LiveData<FilmEntity> getMoviesById(String filmId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertCastMovies(List<FilmCastEntity> movies);

    @Query("SELECT *  FROM filmcastentities WHERE filmId = :filmId")
    LiveData<List<FilmCastEntity>> getCastMoviesById(String filmId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertGenretMovies(List<FilmGenreEntity> filmGenreEntities);

    @Query("SELECT *  FROM filmgenrentities WHERE filmId = :filmId")
    LiveData<List<FilmGenreEntity>> getGenreMoviesById(String filmId);

    @Query("SELECT * FROM tvshowentities WHERE filmId = :filmId")
    LiveData<TvShowEntity> getTvShowById(String filmId);



}
