package popo.moviecatalog.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.List;

import popo.moviecatalog.data.source.MoviesRepository;
import popo.moviecatalog.data.source.local.entity.FilmCastEntity;
import popo.moviecatalog.data.source.local.entity.FilmEntity;
import popo.moviecatalog.data.source.local.entity.FilmGenreEntity;
import popo.moviecatalog.data.source.local.entity.TvShowEntity;
import popo.moviecatalog.vo.Resource;

public class DetailFilmViewModel extends ViewModel {
    private MoviesRepository moviesRepository;

    public DetailFilmViewModel(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    private MutableLiveData<String> filmId = new MutableLiveData<>();
    LiveData<Resource<FilmEntity>> moviesDetail = Transformations.switchMap(filmId,
            mFilmId -> moviesRepository.getDetailMovies(mFilmId));

    LiveData<Resource<List<FilmGenreEntity>>> moviesGenre = Transformations.switchMap(filmId,
            mFilmId -> moviesRepository.getAllGenreMovieShow(mFilmId));

    LiveData<Resource<List<FilmCastEntity>>> moviesCast = Transformations.switchMap(filmId,
            mFilmId -> moviesRepository.getAllCastMovieShow(mFilmId));

    LiveData<Resource<TvShowEntity>> tvShowDetail = Transformations.switchMap(filmId,
            mFilmId -> moviesRepository.getDetailTvShow(mFilmId));

    LiveData<Resource<List<FilmGenreEntity>>> tvshowGenre = Transformations.switchMap(filmId,
            mFilmId -> moviesRepository.getAllGenreTvShow(mFilmId));

    LiveData<Resource<List<FilmCastEntity>>> tvshowCast = Transformations.switchMap(filmId,
            mFilmId -> moviesRepository.getAllCastTvShow(mFilmId));

    public String getFilmId() {
        if (filmId.getValue() == null) return null;
        return filmId.getValue();
    }

    void setFilmId(String filmId) {
        this.filmId.setValue(filmId);
    }

    void setFavoritMovies() {
        if (moviesDetail.getValue() != null) {
            FilmEntity filmEntity = moviesDetail.getValue().data;

            if (filmEntity != null) {
                final boolean newState = !filmEntity.isFavorited();
                moviesRepository.setMoviesFavorit(filmEntity, newState);
            }
        }
    }

    void setFavoritTvShow() {
        if (tvShowDetail.getValue() != null) {
            TvShowEntity tvShowEntity = tvShowDetail.getValue().data;

            if (tvShowEntity != null) {
                final boolean newState = !tvShowEntity.isFavorited();
                moviesRepository.setTvShowFavorite(tvShowEntity, newState);
            }
        }
    }
}
