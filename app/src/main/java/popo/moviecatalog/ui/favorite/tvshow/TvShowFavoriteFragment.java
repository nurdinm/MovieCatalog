package popo.moviecatalog.ui.favorite.tvshow;


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
import popo.moviecatalog.data.source.local.entity.TvShowEntity;
import popo.moviecatalog.viewmodel.ViewModelFactory;

public class TvShowFavoriteFragment extends Fragment implements TvShowFavoriteFragmentCallback{
    @BindView(R.id.rv_film)
    RecyclerView rvFilm;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    private TvShowFavoriteAdapter tvShowAdapter;
    private TvShowFavoriteViewModel viewModel;

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

                TvShowEntity tvShowEntity = tvShowAdapter.getItemById(swipedPosition);

                viewModel.setFavoriteMovies(tvShowEntity);

                Snackbar snackbar = Snackbar.make(getView(), R.string.pesan, Snackbar.LENGTH_LONG);

                snackbar.setAction(R.string.berhasil, v -> viewModel.setFavoriteMovies(tvShowEntity));

                snackbar.show();
            }
        }
    });

    public TvShowFavoriteFragment() {
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
            viewModel = obtainViewModel(getActivity());
            tvShowAdapter = new TvShowFavoriteAdapter(this);
            viewModel.getFavoriteTvShow().observe(this, movies -> {
                if (movies != null) {
                    switch (movies.status) {
                        case LOADING:
                            progressBar.setVisibility(View.VISIBLE);
                            break;
                        case SUCCESS:
                            progressBar.setVisibility(View.GONE);
                            tvShowAdapter.submitList(movies.data);
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

            itemTouchHelper.attachToRecyclerView(rvFilm);
        }
    }

    private TvShowFavoriteViewModel obtainViewModel(FragmentActivity fragmentActivity){
        ViewModelFactory factory = ViewModelFactory.getInstance(fragmentActivity.getApplication());
        return ViewModelProviders.of(fragmentActivity,factory).get(TvShowFavoriteViewModel.class);
    }

    @Override
    public void onShareClick(TvShowEntity tvShowEntity) {
        if (getActivity() != null) {
            String mimeType = "text/plain";
            ShareCompat.IntentBuilder
                    .from(getActivity())
                    .setType(mimeType)
                    .setChooserTitle("Bagikan Tv Show Favorite mu")
                    .setText("Tv Show Favorite yang menurut saya wajib kamu tonton "+ tvShowEntity.getTitle() + " http://moviecatalog.com/recipe/TVSHOW/"+tvShowEntity.getFilmId())
                    .startChooser();
        }
    }
}
