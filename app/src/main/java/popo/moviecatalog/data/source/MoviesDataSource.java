package popo.moviecatalog.data.source;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import java.util.List;

import popo.moviecatalog.data.source.local.entity.FilmCastEntity;
import popo.moviecatalog.data.source.local.entity.FilmEntity;
import popo.moviecatalog.data.source.local.entity.FilmGenreEntity;
import popo.moviecatalog.data.source.local.entity.TvShowEntity;
import popo.moviecatalog.vo.Resource;

public interface MoviesDataSource {
    LiveData<Resource<List<FilmEntity>>> getAllMovies();

    LiveData<Resource<FilmEntity>> getDetailMovies(String filmId);

    LiveData<Resource<List<TvShowEntity>>> getAllTvShow();

    LiveData<Resource<TvShowEntity>> getDetailTvShow(String filmId);

    LiveData<Resource<List<FilmGenreEntity>>> getAllGenreMovieShow(String filmId);

    LiveData<Resource<List<FilmCastEntity>>> getAllCastMovieShow(String filmId);

    LiveData<Resource<List<FilmGenreEntity>>> getAllGenreTvShow(String filmId);

    LiveData<Resource<List<FilmCastEntity>>> getAllCastTvShow(String filmId);

    void setMoviesFavorit(FilmEntity filmEntity, boolean state);

    LiveData<Resource<PagedList<FilmEntity>>> getFavoriteMovies();

    void setTvShowFavorite(TvShowEntity tvShowEntity, boolean state);

    LiveData<Resource<PagedList<TvShowEntity>>> getFavoriteTvShow();

}
