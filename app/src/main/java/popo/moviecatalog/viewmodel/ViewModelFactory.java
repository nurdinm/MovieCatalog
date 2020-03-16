package popo.moviecatalog.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import popo.moviecatalog.data.source.MoviesRepository;
import popo.moviecatalog.di.Injection;
import popo.moviecatalog.ui.detail.DetailFilmViewModel;
import popo.moviecatalog.ui.favorite.movies.MoviesFavoriteViewModel;
import popo.moviecatalog.ui.favorite.tvshow.TvShowFavoriteViewModel;
import popo.moviecatalog.ui.movies.MoviesViewModel;
import popo.moviecatalog.ui.tvshow.TvShowViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;

    private final MoviesRepository mMoviesRepository;

    private ViewModelFactory(MoviesRepository moviesRepository) {
        mMoviesRepository = moviesRepository;
    }

    public static ViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(Injection.provideRepository(application));
                }
            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MoviesViewModel.class)) {
            return (T) new MoviesViewModel(mMoviesRepository);
        }else if(modelClass.isAssignableFrom(TvShowViewModel.class)){
            return (T) new TvShowViewModel(mMoviesRepository);
        }else if(modelClass.isAssignableFrom(DetailFilmViewModel.class)){
            return (T) new DetailFilmViewModel(mMoviesRepository);
        }else if(modelClass.isAssignableFrom(TvShowFavoriteViewModel.class)){
            return (T) new TvShowFavoriteViewModel(mMoviesRepository);
        }else if(modelClass.isAssignableFrom(MoviesFavoriteViewModel.class)){
            return (T) new MoviesFavoriteViewModel(mMoviesRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
