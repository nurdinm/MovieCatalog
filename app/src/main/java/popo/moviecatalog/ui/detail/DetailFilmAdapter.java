package popo.moviecatalog.ui.detail;

import android.app.Activity;
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
import popo.moviecatalog.R;
import popo.moviecatalog.data.source.local.entity.FilmCastEntity;
import popo.moviecatalog.utils.GlideApp;

import static popo.moviecatalog.BuildConfig.URL_IMAGE;

class DetailFilmAdapter extends RecyclerView.Adapter<DetailFilmAdapter.ViewHolder> {
    private List<FilmCastEntity> mFilm = new ArrayList<>();
    private Activity activity;

    DetailFilmAdapter(Activity activity) {
        this.activity = activity;
    }

    void setCastFilm(List<FilmCastEntity> listCastFilm) {
        if (listCastFilm == null) return;
        mFilm.clear();
        mFilm.addAll(listCastFilm);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_cast, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvCastName.setText(mFilm.get(position).getName());
        holder.tvCastTitle.setText(mFilm.get(position).getTitle());
        GlideApp.with(holder.itemView.getContext())
                .load(URL_IMAGE+mFilm.get(position).getImg())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(holder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return mFilm.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_cast_name)
        TextView tvCastName;
        @BindView(R.id.tv_cast_title)
        TextView tvCastTitle;
        @BindView(R.id.img_poster)
        ImageView imgPoster;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
