package popo.moviecatalog.ui.favorite.movies;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ShareCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import popo.moviecatalog.R;
import popo.moviecatalog.data.source.local.entity.FilmEntity;
import popo.moviecatalog.viewmodel.ViewModelFactory;

public class MoviesFavoriteFragment extends Fragment implements MoviesFavoriteFragmentCallback {
    @BindView(R.id.rv_film) RecyclerView rvFilm;
    @BindView(R.id.progress_bar) ProgressBar progressBar;
    private MoviesFavoriteAdapter moviesAdapter;
    private MoviesFavoriteViewModel moviesViewModel;

    private ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
        @Override
        public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return makeMovementFlags(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        }

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return true;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            if (getView() != null) {
                int swipedPosition = viewHolder.getAdapterPosition();

                FilmEntity filmEntity = moviesAdapter.getItemById(swipedPosition);

                moviesViewModel.setFavoriteMovies(filmEntity);

                Snackbar snackbar = Snackbar.make(getView(), R.string.pesan, Snackbar.LENGTH_LONG);

                snackbar.setAction(R.string.berhasil, v -> moviesViewModel.setFavoriteMovies(filmEntity));

                snackbar.show();
            }
        }
    });

    public MoviesFavoriteFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            progressBar.setVisibility(View.VISIBLE);
            moviesViewModel = obtainViewModel(getActivity());
            moviesAdapter = new MoviesFavoriteAdapter(this);
            moviesViewModel.getFavoriteMovies().observe(this, movies -> {
                if (movies != null) {
                    switch (movies.status) {
                        case LOADING:
                            progressBar.setVisibility(View.VISIBLE);
                            break;
                        case SUCCESS:
                            progressBar.setVisibility(View.GONE);
                            moviesAdapter.submitList(movies.data);
                            moviesAdapter.notifyDataSetChanged();
                            break;
                        case ERROR:
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(getContext(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                            break;

                    }
                }
            });

            rvFilm.setLayoutManager(new LinearLayoutManager(getContext()));
            rvFilm.setHasFixedSize(true);
            rvFilm.setAdapter(moviesAdapter);

            itemTouchHelper.attachToRecyclerView(rvFilm);
        }
    }

    private MoviesFavoriteViewModel obtainViewModel(FragmentActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity,factory).get(MoviesFavoriteViewModel.class);
    }

    @Override
    public void onShareClick(FilmEntity filmEntity) {
        if (getActivity() != null) {
            String mimeType = "text/plain";
            ShareCompat.IntentBuilder
                    .from(getActivity())
                    .setType(mimeType)
                    .setChooserTitle("Bagikan Film Favorite mu")
                    .setText("Film Favorite yang menurut saya wajib kamu tonton " + filmEntity.getTitle() + " http://moviecatalog.com/recipe/MOVIES/"+filmEntity.getFilmId())
                    .startChooser();
        }
    }
}
