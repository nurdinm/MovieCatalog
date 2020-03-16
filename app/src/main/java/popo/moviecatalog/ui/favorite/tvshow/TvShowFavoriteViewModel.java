package popo.moviecatalog.ui.favorite.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import popo.moviecatalog.data.source.MoviesRepository;
import popo.moviecatalog.data.source.local.entity.TvShowEntity;
import popo.moviecatalog.vo.Resource;

public class TvShowFavoriteViewModel extends ViewModel {
    private MoviesRepository moviesRepository;

    public TvShowFavoriteViewModel(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    public LiveData<Resource<PagedList<TvShowEntity>>> getFavoriteTvShow() {
        return moviesRepository.getFavoriteTvShow();
    }

    void setFavoriteMovies(TvShowEntity tvShowEntity) {
        final boolean newState = !tvShowEntity.isFavorited();
        moviesRepository.setTvShowFavorite(tvShowEntity, newState);
    }

}
