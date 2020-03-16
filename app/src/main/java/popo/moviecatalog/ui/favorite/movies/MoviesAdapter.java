package popo.moviecatalog.ui.favorite.movies;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import popo.moviecatalog.BuildConfig;
import popo.moviecatalog.R;
import popo.moviecatalog.data.source.local.entity.FilmEntity;
import popo.moviecatalog.ui.detail.DetailFilmActivity;
import popo.moviecatalog.utils.GlideApp;

import static popo.moviecatalog.ui.detail.DetailFilmActivity.EXTRA_MOVIE;
import static popo.moviecatalog.ui.detail.DetailFilmActivity.JENIS_MOVIE;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private List<FilmEntity> mFilm = new ArrayList<>();
    private Activity activity;

    MoviesAdapter(Activity activities) {
        this.activity = activities;
    }

    private List<FilmEntity> getmFilm() {
        return mFilm;
    }

    void setListFilm(List<FilmEntity> listFilm) {
        if (listFilm == null) return;
        this.mFilm.clear();
        this.mFilm.addAll(listFilm);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_movie, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(getmFilm().get(position).getTitle());
        holder.tvDesc.setText(getmFilm().get(position).getDesc());
        holder.tvTgl.setText(getmFilm().get(position).getTgl());
        holder.tvRating.setText("Rating : " + getmFilm().get(position).getVote() + " / 10");
        String URL_IMAGE = BuildConfig.URL_IMAGE;
        GlideApp.with(holder.imgPoster.getContext())
                .load(URL_IMAGE +getmFilm().get(position).getImg())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(holder.imgPoster);
//        GlideApp.with(holder.imgPoster.getContext())
//                .load(activity.getResources().getIdentifier(getmFilm().get(position).getImg(), "drawable", activity.getPackageName()))
//                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
//                .into(holder.imgPoster);
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(activity, DetailFilmActivity.class);
            intent.putExtra(EXTRA_MOVIE, getmFilm().get(position).getFilmId());
            intent.putExtra(JENIS_MOVIE, "MOVIES");
            activity.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return getmFilm().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_poster)
        ImageView imgPoster;
        @BindView(R.id.tv_item_title)
        TextView tvTitle;
        @BindView(R.id.tv_item_desc)
        TextView tvDesc;
        @BindView(R.id.tv_item_tgl)
        TextView tvTgl;
        @BindView(R.id.tv_item_rating)
        TextView tvRating;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
