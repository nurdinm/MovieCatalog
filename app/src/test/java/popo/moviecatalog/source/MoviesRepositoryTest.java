package popo.moviecatalog.source;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PagedList;

import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import popo.moviecatalog.data.source.local.LocalRepository;
import popo.moviecatalog.data.source.local.entity.FilmCastEntity;
import popo.moviecatalog.data.source.local.entity.FilmEntity;
import popo.moviecatalog.data.source.local.entity.FilmGenreEntity;
import popo.moviecatalog.data.source.local.entity.TvShowEntity;
import popo.moviecatalog.data.source.remote.RemoteRepository;
import popo.moviecatalog.data.source.remote.response.CastResponse;
import popo.moviecatalog.data.source.remote.response.GenreResponse;
import popo.moviecatalog.data.source.remote.response.MoviesResponse;
import popo.moviecatalog.utils.FakeDataDummy;
import popo.moviecatalog.utils.InstantAppExecutors;
import popo.moviecatalog.utils.LiveDataTestUtil;
import popo.moviecatalog.utils.PagedListUtil;
import popo.moviecatalog.vo.Resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MoviesRepositoryTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private LocalRepository local = mock(LocalRepository.class);
    private RemoteRepository remote = mock(RemoteRepository.class);
    private InstantAppExecutors instantAppExecutors = mock(InstantAppExecutors.class);
    private FakeMoviesRepository moviesRepository = new FakeMoviesRepository(local, remote, instantAppExecutors);

    private ArrayList<MoviesResponse> moviesResponses = FakeDataDummy.generateRemoteDummyMovies();
    private List<FilmEntity> filmEntities = FakeDataDummy.generateDummyMovies();
    private String filmId = moviesResponses.get(0).getFilmId();
    private ArrayList<MoviesResponse> tvshowResponses = FakeDataDummy.generateRemoteDummyTvShow();
    private List<TvShowEntity> tvShowEntities = FakeDataDummy.generateDummyTvShow();
    private String tvshowId = tvshowResponses.get(0).getFilmId();
    private ArrayList<GenreResponse> genreResponses = FakeDataDummy.generateRemoteGenreFilm(filmId);
    private List<FilmGenreEntity> filmGenreEntities = FakeDataDummy.generateGenreFilm(filmId);
    private ArrayList<CastResponse> castResponses = FakeDataDummy.generateRemoteCastFilm(filmId);
    private List<FilmCastEntity> filmCastEntities = FakeDataDummy.generateCastFilm(filmId);

    @Test
    public void getAllMovies() {
        MutableLiveData<List<FilmEntity>> dummyMovies = new MutableLiveData<>();
        dummyMovies.setValue(FakeDataDummy.generateDummyMovies());

        when(local.getAllMovies()).thenReturn(dummyMovies);

        Resource<List<FilmEntity>> result = LiveDataTestUtil.getValue(moviesRepository.getAllMovies());

        verify(local).getAllMovies();
        assertNotNull(result.data);
        assertEquals(moviesResponses.size(), result.data.size());
    }

    @Test
    public void getAllTvShow() {
        MutableLiveData<List<TvShowEntity>> dummyMovies = new MutableLiveData<>();
        dummyMovies.setValue(FakeDataDummy.generateDummyTvShow());

        when(local.getAllTvShow()).thenReturn(dummyMovies);

        Resource<List<TvShowEntity>> result = LiveDataTestUtil.getValue(moviesRepository.getAllTvShow());

        verify(local).getAllTvShow();
        assertNotNull(result.data);
        assertEquals(moviesResponses.size(), result.data.size());
    }

    @Test
    public void getAllGenre() {
        MutableLiveData<List<FilmGenreEntity>> dummyGenre = new MutableLiveData<>();
        dummyGenre.setValue(FakeDataDummy.generateGenreFilm(filmId));

        when(local.getAllGenreMovie(filmId)).thenReturn(dummyGenre);

        Resource<List<FilmGenreEntity>> result = LiveDataTestUtil.getValue(moviesRepository.getAllGenreMovieShow(filmId));

        verify(local).getAllGenreMovie(filmId);
        assertNotNull(result.data);
        assertEquals(genreResponses.size(), result.data.size());
    }

    @Test
    public void getAllCast() {
        MutableLiveData<List<FilmCastEntity>> dummyCast = new MutableLiveData<>();
        dummyCast.setValue(FakeDataDummy.generateCastFilm(filmId));

        when(local.getAllCastMovie(filmId)).thenReturn(dummyCast);

        Resource<List<FilmCastEntity>> result = LiveDataTestUtil.getValue(moviesRepository.getAllCastMovieShow(filmId));

        verify(local).getAllCastMovie(filmId);
        assertNotNull(result.data);
        assertEquals(castResponses.size(), result.data.size());
    }

    @Test
    public void getFavoriteMovies() {

        DataSource.Factory<Integer, FilmEntity> dataSourceFactory = mock(DataSource.Factory.class);

        when(local.getFavoriteMovies()).thenReturn(dataSourceFactory);
        moviesRepository.getFavoriteMovies();
        Resource<PagedList<FilmEntity>> result = Resource.success(PagedListUtil.mockPagedList(filmEntities));

        verify(local).getFavoriteMovies();
        assertNotNull(result.data);
        assertEquals(filmEntities.size(), result.data.size());
    }

    @Test
    public void getFavoriteTvShow() {

        DataSource.Factory<Integer, TvShowEntity> dataSourceFactory = mock(DataSource.Factory.class);

        when(local.getFavoriteTvShow()).thenReturn(dataSourceFactory);
        moviesRepository.getFavoriteTvShow();
        Resource<PagedList<TvShowEntity>> result = Resource.success(PagedListUtil.mockPagedList(tvShowEntities));

        verify(local).getFavoriteTvShow();
        assertNotNull(result.data);
        assertEquals(tvShowEntities.size(), result.data.size());
    }

}