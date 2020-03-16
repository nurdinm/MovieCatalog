package popo.moviecatalog.ui.favorite.movies;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import popo.moviecatalog.data.source.MoviesRepository;
import popo.moviecatalog.data.source.local.entity.FilmEntity;
import popo.moviecatalog.vo.Resource;

public class MoviesFavoriteViewModel extends ViewModel {
    private MoviesRepository moviesRepository;

    public MoviesFavoriteViewModel(MoviesRepository mMoviesRepository) {
        this.moviesRepository = mMoviesRepository;
    }

    public LiveData<Resource<PagedList<FilmEntity>>> getFavoriteMovies() {
        return moviesRepository.getFavoriteMovies();
    }

    void setFavoriteMovies(FilmEntity filmEntity) {
        final boolean newState = !filmEntity.isFavorited();
        moviesRepository.setMoviesFavorit(filmEntity, newState);
    }
}
