package popo.moviecatalog.ui.detail;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import popo.moviecatalog.data.source.MoviesRepository;
import popo.moviecatalog.data.source.local.entity.FilmCastEntity;
import popo.moviecatalog.data.source.local.entity.FilmEntity;
import popo.moviecatalog.data.source.local.entity.FilmGenreEntity;
import popo.moviecatalog.data.source.local.entity.TvShowEntity;
import popo.moviecatalog.utils.FakeDataDummy;
import popo.moviecatalog.vo.Resource;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailFilmActivityViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private MoviesRepository moviesRepository = mock(MoviesRepository.class);
    private DetailFilmViewModel viewModel;
    private FilmEntity dummyFilm = FakeDataDummy.generateDummyMovies().get(0);
    private TvShowEntity dummyTvShow = FakeDataDummy.generateDummyTvShow().get(0);
    private String filmId = dummyFilm.getFilmId();
    private String tvshowId = dummyTvShow.getFilmId();

    @Before
    public void setUp(){
        viewModel = new DetailFilmViewModel(moviesRepository);
        viewModel.setFilmId(filmId);
        viewModel.setFavoritMovies();

    }

    @Test
    public void getMovies() {
        Resource<FilmEntity> resource = Resource.success(FakeDataDummy.generateDummyFavoriteMovie(dummyFilm, true));
        MutableLiveData<Resource<FilmEntity>> movieEntities = new MutableLiveData<>();
        movieEntities.setValue(resource);

        when(moviesRepository.getDetailMovies(filmId)).thenReturn(movieEntities);

        Observer<Resource<FilmEntity>> observer = mock(Observer.class);

        viewModel.moviesDetail.observeForever(observer);

        verify(observer).onChanged(resource);
    }

    @Test
    public void getCastMovies() {
        Resource<List<FilmCastEntity>> resource = Resource.success(FakeDataDummy.generateCastFilm(filmId));
        MutableLiveData<Resource<List<FilmCastEntity>>> castEntities = new MutableLiveData<>();
        castEntities.setValue(resource);

        when(moviesRepository.getAllCastMovieShow(filmId)).thenReturn(castEntities);

        Observer<Resource<List<FilmCastEntity>>> observer = mock(Observer.class);

        viewModel.moviesCast.observeForever(observer);

        verify(observer).onChanged(resource);
    }

    @Test
    public void getGenreMovies() {
        Resource<List<FilmGenreEntity>> resource = Resource.success(FakeDataDummy.generateGenreFilm(filmId));
        MutableLiveData<Resource<List<FilmGenreEntity>>> genreEntities = new MutableLiveData<>();
        genreEntities.setValue(resource);

        when(moviesRepository.getAllGenreMovieShow(filmId)).thenReturn(genreEntities);

        Observer<Resource<List<FilmGenreEntity>>> observer = mock(Observer.class);

        viewModel.moviesGenre.observeForever(observer);

        verify(observer).onChanged(resource);
    }

    @Test
    public void getTvShow() {
        Resource<TvShowEntity> resource = Resource.success(FakeDataDummy.generateDummyFavoriteTvShow(dummyTvShow, true));
        MutableLiveData<Resource<TvShowEntity>> movieEntities = new MutableLiveData<>();
        movieEntities.setValue(resource);

        when(moviesRepository.getDetailTvShow(tvshowId)).thenReturn(movieEntities);

        Observer<Resource<TvShowEntity>> observer = mock(Observer.class);

        viewModel.tvShowDetail.observeForever(observer);

        verify(observer).onChanged(resource);
    }

}