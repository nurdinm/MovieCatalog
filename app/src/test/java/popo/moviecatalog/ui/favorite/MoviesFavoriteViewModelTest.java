package popo.moviecatalog.ui.favorite;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import popo.moviecatalog.data.source.MoviesRepository;
import popo.moviecatalog.data.source.local.entity.FilmEntity;
import popo.moviecatalog.ui.favorite.movies.MoviesFavoriteViewModel;
import popo.moviecatalog.vo.Resource;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MoviesFavoriteViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private MoviesFavoriteViewModel viewModel;
    private MoviesRepository moviesRepository = mock(MoviesRepository.class);

    @Before
    public void setUp() {
        viewModel = new MoviesFavoriteViewModel(moviesRepository);
    }

    @Test
    public void getMovies() {

        MutableLiveData<Resource<PagedList<FilmEntity>>> dummyMovies = new MutableLiveData<>();
        PagedList<FilmEntity> pagedList = mock(PagedList.class);
        dummyMovies.setValue(Resource.success(pagedList));

        when(moviesRepository.getFavoriteMovies()).thenReturn(dummyMovies);

        Observer<Resource<PagedList<FilmEntity>>> observer = mock(Observer.class);

        viewModel.getFavoriteMovies().observeForever(observer);

        verify(observer).onChanged(Resource.success(pagedList));
    }
}