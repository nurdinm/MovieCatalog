package popo.moviecatalog.ui.detail;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import popo.moviecatalog.R;
import popo.moviecatalog.data.source.local.entity.FilmGenreEntity;

class DetailGenreFilmAdapter extends RecyclerView.Adapter<DetailGenreFilmAdapter.ViewHolder> {
    private List<FilmGenreEntity> mFilm = new ArrayList<>();
    private Activity activity;

    DetailGenreFilmAdapter(Activity activity) {
        this.activity = activity;
    }

    void setGenreFilm(List<FilmGenreEntity> listGenreFilm) {
        if (listGenreFilm == null) return;
        mFilm.clear();
        mFilm.addAll(listGenreFilm);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_genre, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvGenreFilm.setText(mFilm.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mFilm.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_genre)
        TextView tvGenreFilm;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
