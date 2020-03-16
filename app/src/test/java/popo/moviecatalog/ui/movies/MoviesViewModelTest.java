package popo.moviecatalog.ui.movies;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import popo.moviecatalog.data.source.MoviesRepository;
import popo.moviecatalog.data.source.local.entity.FilmEntity;
import popo.moviecatalog.utils.FakeDataDummy;
import popo.moviecatalog.vo.Resource;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MoviesViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private MoviesViewModel viewModel;
    private MoviesRepository moviesRepository = mock(MoviesRepository.class);
    private String USERNAME = "Muhammad Nurdin";

    @Before
    public void setUp() {
        viewModel = new MoviesViewModel(moviesRepository);
    }

    @Test
    public void getMovies() {
        Resource<List<FilmEntity>> resource = Resource.success(FakeDataDummy.generateDummyMovies());
        MutableLiveData<Resource<List<FilmEntity>>> dummyMovies = new MutableLiveData<>();
        dummyMovies.setValue(resource);

        when(moviesRepository.getAllMovies()).thenReturn(dummyMovies);

        Observer<Resource<List<FilmEntity>>> observer = mock(Observer.class);

        viewModel.setUsername(USERNAME);

        viewModel.movies.observeForever(observer);

        verify(observer).onChanged(resource);
    }
}