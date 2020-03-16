package popo.moviecatalog.ui.detail;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import popo.moviecatalog.R;
import popo.moviecatalog.data.source.local.entity.FilmEntity;
import popo.moviecatalog.data.source.local.entity.TvShowEntity;
import popo.moviecatalog.viewmodel.ViewModelFactory;

import static popo.moviecatalog.BuildConfig.URL_IMAGE;

public class DetailFilmActivity extends AppCompatActivity {
    public static String EXTRA_MOVIE = "extra_movie";
    public static String JENIS_MOVIE = "jenis_movie";
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_tahun)
    TextView tvTahun;
    @BindView(R.id.tv_runtime)
    TextView tvRuntime;
    @BindView(R.id.tv_revenue)
    TextView tvRevenue;
    @BindView(R.id.tv_lang)
    TextView tvLang;
    @BindView(R.id.tv_desc)
    TextView tvDesc;
    @BindView(R.id.rv_cast)
    RecyclerView rvCast;
    @BindView(R.id.rv_genre)
    RecyclerView rvGenre;
    @BindView(R.id.img_poster)
    ImageView imgPoster;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private DetailFilmAdapter adapter;
    private DetailGenreFilmAdapter adapterGenre;
    private DetailFilmViewModel detailFilmViewModel;
    private Menu menu;
    private String jenis;

    @NonNull
    private static DetailFilmViewModel obtainViewModel(AppCompatActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());

        return ViewModelProviders.of(activity, factory).get(DetailFilmViewModel.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);
        ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        adapter = new DetailFilmAdapter(this);
        adapterGenre = new DetailGenreFilmAdapter(this);
        detailFilmViewModel = obtainViewModel(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String filmId = bundle.getString(EXTRA_MOVIE);
            jenis = bundle.getString(JENIS_MOVIE);
            if (filmId != null) {
                progressBar.setVisibility(View.VISIBLE);
                detailFilmViewModel.setFilmId(filmId);

                if (jenis != null) {
                    if (jenis.equals("MOVIES")) {
                        detailFilmViewModel.moviesGenre.observe(this, genre -> {
                            if (genre != null) {

                                switch (genre.status) {
                                    case LOADING:
                                        progressBar.setVisibility(View.VISIBLE);
                                        break;
                                    case SUCCESS:
                                        if (genre.data != null) {
                                            progressBar.setVisibility(View.GONE);
                                            adapterGenre.setGenreFilm(genre.data);
                                            adapterGenre.notifyDataSetChanged();
                                        }
                                        break;
                                    case ERROR:
                                        progressBar.setVisibility(View.GONE);
                                        Toast.makeText(getApplicationContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                                        break;
                                }

                            }
                        });
                        detailFilmViewModel.moviesCast.observe(this, cast -> {
                            if (cast != null) {

                                switch (cast.status) {
                                    case LOADING:
                                        progressBar.setVisibility(View.VISIBLE);
                                        break;
                                    case SUCCESS:
                                        if (cast.data != null) {
                                            progressBar.setVisibility(View.GONE);
                                            adapter.setCastFilm(cast.data);
                                            adapter.notifyDataSetChanged();
                                        }
                                        break;
                                    case ERROR:
                                        progressBar.setVisibility(View.GONE);
                                        Toast.makeText(getApplicationContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                                        break;
                                }

                            }
                        });
                    } else if (jenis.equals("TVSHOW")) {
                        detailFilmViewModel.tvshowGenre.observe(this, genre -> {
                            if (genre != null) {

                                switch (genre.status) {
                                    case LOADING:
                                        progressBar.setVisibility(View.VISIBLE);
                                        break;
                                    case SUCCESS:
                                        if (genre.data != null) {
                                            progressBar.setVisibility(View.GONE);
                                            adapterGenre.setGenreFilm(genre.data);
                                            adapterGenre.notifyDataSetChanged();
                                        }
                                        break;
                                    case ERROR:
                                        progressBar.setVisibility(View.GONE);
                                        Toast.makeText(getApplicationContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                                        break;
                                }

                            }
                        });
                        detailFilmViewModel.tvshowCast.observe(this, cast -> {
                            if (cast != null) {

                                switch (cast.status) {
                                    case LOADING:
                                        progressBar.setVisibility(View.VISIBLE);
                                        break;
                                    case SUCCESS:
                                        if (cast.data != null) {
                                            progressBar.setVisibility(View.GONE);
                                            adapter.setCastFilm(cast.data);
                                            adapter.notifyDataSetChanged();
                                        }
                                        break;
                                    case ERROR:
                                        progressBar.setVisibility(View.GONE);
                                        Toast.makeText(getApplicationContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                                        break;
                                }

                            }
                        });
                    }
                }

                if (jenis != null) {
                    if (jenis.equals("MOVIES")) {
                        detailFilmViewModel.moviesDetail.observe(this, moviesWithModuleResource -> {
                            if (moviesWithModuleResource != null) {

                                switch (moviesWithModuleResource.status) {
                                    case LOADING:
                                        progressBar.setVisibility(View.VISIBLE);
                                        break;
                                    case SUCCESS:
                                        if (moviesWithModuleResource.data != null) {
                                            progressBar.setVisibility(View.GONE);
                                            populateFilm(moviesWithModuleResource.data);
                                        }
                                        break;
                                    case ERROR:
                                        progressBar.setVisibility(View.GONE);
                                        Toast.makeText(getApplicationContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                                        break;
                                }

                            }
                        });

                    } else if (jenis.equals("TVSHOW")) {
                        Log.e("THISISI","IN");
                        detailFilmViewModel.tvShowDetail.observe(this, tvShowWithModuleResource -> {
                            if (tvShowWithModuleResource != null) {
                                switch (tvShowWithModuleResource.status) {
                                    case LOADING:
                                        progressBar.setVisibility(View.VISIBLE);
                                        break;
                                    case SUCCESS:
                                        if (tvShowWithModuleResource.data != null) {
                                            progressBar.setVisibility(View.GONE);
                                            populateTvShow(tvShowWithModuleResource.data);
                                        }
                                        break;
                                    case ERROR:
                                        progressBar.setVisibility(View.GONE);
                                        Toast.makeText(getApplicationContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                                        break;
                                }

                            }
                        });
                    }
                }
            }
        }

        rvCast.setNestedScrollingEnabled(false);
        rvCast.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvCast.setHasFixedSize(true);
        rvCast.setAdapter(adapter);
        rvGenre.setNestedScrollingEnabled(false);
        rvGenre.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvGenre.setHasFixedSize(true);
        rvGenre.setAdapter(adapterGenre);
    }

    @SuppressLint("SetTextI18n")
    private void populateFilm(FilmEntity film) {
        tvTitle.setText(film.getTitle());
        tvTahun.setText(film.getTgl());
        tvRevenue.setText(film.getRevenue());
        tvRuntime.setText(film.getRuntime()+"m");
        tvLang.setText(film.getLang());
        tvDesc.setText(film.getDesc());
        Glide.with(getApplicationContext())
                .load(URL_IMAGE+film.getImg())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(imgPoster);
    }

    @SuppressLint("SetTextI18n")
    private void populateTvShow(TvShowEntity film) {
        tvTitle.setText(film.getTitle());
        tvTahun.setText(film.getTgl());
        tvRevenue.setText(film.getRevenue());
        tvRuntime.setText(film.getRuntime()+"m");
        tvLang.setText(film.getLang());
        tvDesc.setText(film.getDesc());
        Glide.with(getApplicationContext())
                .load(URL_IMAGE+film.getImg())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(imgPoster);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_favorite, menu);
        this.menu = menu;
        if (jenis != null) {
            if (jenis.equals("MOVIES")) {
                detailFilmViewModel.moviesDetail.observe(this, movies -> {
                    if (movies != null) {
                        switch (movies.status) {
                            case LOADING:
                                progressBar.setVisibility(View.VISIBLE);
                                break;
                            case SUCCESS:
                                if (movies.data != null) {
                                    progressBar.setVisibility(View.GONE);
                                    boolean state = movies.data.isFavorited();
                                    setFavoriteState(state);
                                }
                                break;
                            case ERROR:
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(getApplicationContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });

            } else if (jenis.equals("TVSHOW")) {
                detailFilmViewModel.tvShowDetail.observe(this, tvShowWithModuleResource -> {
                    if (tvShowWithModuleResource != null) {
                        switch (tvShowWithModuleResource.status) {
                            case LOADING:
                                progressBar.setVisibility(View.VISIBLE);
                                break;
                            case SUCCESS:
                                if (tvShowWithModuleResource.data != null) {
                                    progressBar.setVisibility(View.GONE);
                                    boolean state = tvShowWithModuleResource.data.isFavorited();
                                    setFavoriteState(state);
                                }
                                break;
                            case ERROR:
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(getApplicationContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                                break;
                        }

                    }
                });
            }
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_favorite) {
            if (jenis.equals("MOVIES")) {
                detailFilmViewModel.setFavoritMovies();
            }else if (jenis.equals("TVSHOW")) {
                detailFilmViewModel.setFavoritTvShow();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setFavoriteState(boolean state) {
        if (menu == null) return;
        MenuItem menuItem = menu.findItem(R.id.action_favorite);
        if (state) {
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_favorite_border_24dp));
        } else {
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white));
        }
    }
}
