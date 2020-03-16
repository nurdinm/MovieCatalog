package popo.moviecatalog.ui.favorite;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import popo.moviecatalog.data.source.MoviesRepository;
import popo.moviecatalog.data.source.local.entity.TvShowEntity;
import popo.moviecatalog.ui.favorite.tvshow.TvShowFavoriteViewModel;
import popo.moviecatalog.vo.Resource;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TvShowFavoriteViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private TvShowFavoriteViewModel viewModel;
    private MoviesRepository moviesRepository = mock(MoviesRepository.class);

    @Before
    public void setUp() {
        viewModel = new TvShowFavoriteViewModel(moviesRepository);
    }

    @Test
    public void getMovies() {

        MutableLiveData<Resource<PagedList<TvShowEntity>>> dummyTvShow = new MutableLiveData<>();
        PagedList<TvShowEntity> pagedList = mock(PagedList.class);
        dummyTvShow.setValue(Resource.success(pagedList));

        when(moviesRepository.getFavoriteTvShow()).thenReturn(dummyTvShow);

        Observer<Resource<PagedList<TvShowEntity>>> observer = mock(Observer.class);

        viewModel.getFavoriteTvShow().observeForever(observer);

        verify(observer).onChanged(Resource.success(pagedList));
    }
}