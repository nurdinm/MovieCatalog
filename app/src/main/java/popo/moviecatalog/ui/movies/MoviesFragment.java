package popo.moviecatalog.ui.movies;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import popo.moviecatalog.R;
import popo.moviecatalog.viewmodel.ViewModelFactory;

public class MoviesFragment extends Fragment {
    @BindView(R.id.rv_film) RecyclerView rvFilm;
    @BindView(R.id.progress_bar) ProgressBar progressBar;
    private MoviesAdapter moviesAdapter;

    public MoviesFragment() {

    }

    public static Fragment newInstance() {
        return new MoviesFragment();
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
            MoviesViewModel moviesViewModel = obtainViewModel(getActivity());
            moviesAdapter = new MoviesAdapter(getActivity());
            moviesViewModel.setUsername("Muhammad Nurdin");
            moviesViewModel.movies.observe(this, movies -> {
                if (movies != null) {
                    switch (movies.status) {
                        case LOADING:
                            progressBar.setVisibility(View.VISIBLE);
                            break;
                        case SUCCESS:
                            progressBar.setVisibility(View.GONE);
                            moviesAdapter.setListFilm(movies.data);
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
        }
    }

    private MoviesViewModel obtainViewModel(FragmentActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity,factory).get(MoviesViewModel.class);
    }
}
