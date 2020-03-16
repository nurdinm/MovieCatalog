package popo.moviecatalog.ui.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.List;

import popo.moviecatalog.data.source.MoviesRepository;
import popo.moviecatalog.data.source.local.entity.TvShowEntity;
import popo.moviecatalog.vo.Resource;

public class TvShowViewModel extends ViewModel {
    private MoviesRepository moviesRepository;

    public TvShowViewModel(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    private MutableLiveData<String> mLogin = new MutableLiveData<>();
    LiveData<Resource<List<TvShowEntity>>> movies = Transformations.switchMap(mLogin,
            data -> moviesRepository.getAllTvShow());

    void setUsername(String username) {
        mLogin.setValue(username);
    }

}
