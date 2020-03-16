package popo.moviecatalog.ui.favorite.tvshow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import popo.moviecatalog.BuildConfig;
import popo.moviecatalog.R;
import popo.moviecatalog.data.source.local.entity.TvShowEntity;
import popo.moviecatalog.ui.detail.DetailFilmActivity;
import popo.moviecatalog.utils.GlideApp;

public class TvShowFavoriteAdapter extends PagedListAdapter<TvShowEntity, TvShowFavoriteAdapter.ViewHolder> {

    private static DiffUtil.ItemCallback<TvShowEntity> DIFF_CALLBACK =
        new DiffUtil.ItemCallback<TvShowEntity>() {
            @Override
            public boolean areItemsTheSame(@NonNull TvShowEntity oldItem, @NonNull TvShowEntity newItem) {
                return oldItem.getFilmId().equals(newItem.getFilmId());
            }

            @SuppressLint("DiffUtilEquals")
            @Override
            public boolean areContentsTheSame(@NonNull TvShowEntity oldItem, @NonNull TvShowEntity newItem) {
                return oldItem.equals(newItem);
            }
        };
    private TvShowFavoriteFragmentCallback callback;

    TvShowFavoriteAdapter(TvShowFavoriteFragmentCallback callback) {
        super(DIFF_CALLBACK);

        this.callback = callback;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final TvShowEntity favorite = getItem(position);
        String URL_IMAGE = BuildConfig.URL_IMAGE;
        if (favorite != null) {
            holder.tvTitle.setText(favorite.getTitle());
            holder.tvDesc.setText(favorite.getDesc());
            holder.tvTgl.setText(favorite.getTgl());
            holder.tvRating.setText("Rating : " + favorite.getVote() + " / 10");
            GlideApp.with(holder.imgPoster.getContext())
                    .load(URL_IMAGE+favorite.getImg())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(holder.imgPoster);
            holder.itemView.setOnClickListener(v -> {
                Context context = holder.itemView.getContext();
                Intent intent = new Intent(context, DetailFilmActivity.class);
                String filmId = favorite.getFilmId();
                intent.putExtra(DetailFilmActivity.EXTRA_MOVIE, filmId);
                intent.putExtra(DetailFilmActivity.JENIS_MOVIE, "MOVIES");
                context.startActivity(intent);
            });

            holder.imgShare.setOnClickListener(v -> {
                TvShowEntity tvShowEntity = new TvShowEntity(favorite.getFilmId(),
                        favorite.getTitle(),
                        favorite.getVote(),
                        favorite.getDesc(),
                        favorite.getTgl(),
                        favorite.getImg(),
                        favorite.getLang());
                callback.onShareClick(tvShowEntity);
            });


        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_favorite, parent, false);
        return new ViewHolder(view);
    }

    TvShowEntity getItemById(int swipedPosition) {
        return getItem(swipedPosition);
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
        @BindView(R.id.img_share)
        ImageButton imgShare;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}