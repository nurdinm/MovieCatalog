package popo.moviecatalog.ui.movies;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import java.util.List;

import popo.moviecatalog.data.source.local.entity.FilmEntity;
import popo.moviecatalog.data.source.MoviesRepository;
import popo.moviecatalog.vo.Resource;

public class MoviesViewModel extends ViewModel {
    private MoviesRepository moviesRepository;

    public MoviesViewModel(MoviesRepository mMoviesRepository) {
        this.moviesRepository = mMoviesRepository;
    }

    private MutableLiveData<String> mLogin = new MutableLiveData<>();
    LiveData<Resource<List<FilmEntity>>> movies = Transformations.switchMap(mLogin,
            data -> moviesRepository.getAllMovies());

    void setUsername(String username) {
        mLogin.setValue(username);
    }
}
