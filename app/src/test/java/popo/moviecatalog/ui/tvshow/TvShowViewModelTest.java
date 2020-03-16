package popo.moviecatalog.ui.tvshow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import popo.moviecatalog.data.source.MoviesRepository;
import popo.moviecatalog.data.source.local.entity.TvShowEntity;
import popo.moviecatalog.utils.FakeDataDummy;
import popo.moviecatalog.vo.Resource;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TvShowViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private TvShowViewModel viewModel;
    private MoviesRepository moviesRepository = mock(MoviesRepository.class);
    private String USERNAME = "Muhammad Nurdin";

    @Before
    public void setUp() {
        viewModel = new TvShowViewModel(moviesRepository);
    }

    @Test
    public void getMovies() {
        Resource<List<TvShowEntity>> resource = Resource.success(FakeDataDummy.generateDummyTvShow());
        MutableLiveData<Resource<List<TvShowEntity>>> dummyTvShow = new MutableLiveData<>();
        dummyTvShow.setValue(resource);

        when(moviesRepository.getAllTvShow()).thenReturn(dummyTvShow);

        Observer<Resource<List<TvShowEntity>>> observer = mock(Observer.class);

        viewModel.setUsername(USERNAME);

        viewModel.movies.observeForever(observer);

        verify(observer).onChanged(resource);
    }
}