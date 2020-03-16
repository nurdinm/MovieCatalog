package popo.moviecatalog.ui.tvshow;


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

public class TvShowFragment extends Fragment {
    @BindView(R.id.rv_film)
    RecyclerView rvFilm;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    private TvShowAdapter tvShowAdapter;

    public TvShowFragment() {
    }

    public static Fragment newInstance() {
        return new TvShowFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tv_show, container, false);
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
            TvShowViewModel viewModel = obtainViewModel(getActivity());
            tvShowAdapter = new TvShowAdapter(getActivity());
            viewModel.setUsername("Muhammad Nurdin");
            viewModel.movies.observe(this, movies -> {
                if (movies != null) {
                    switch (movies.status) {
                        case LOADING:
                            progressBar.setVisibility(View.VISIBLE);
                            break;
                        case SUCCESS:
                            progressBar.setVisibility(View.GONE);
                            tvShowAdapter.setmFilm(movies.data);
                            tvShowAdapter.notifyDataSetChanged();
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
            rvFilm.setAdapter(tvShowAdapter);
        }
    }

    private TvShowViewModel obtainViewModel(FragmentActivity fragmentActivity){
        ViewModelFactory factory = ViewModelFactory.getInstance(fragmentActivity.getApplication());
        return ViewModelProviders.of(fragmentActivity,factory).get(TvShowViewModel.class);
    }
}
