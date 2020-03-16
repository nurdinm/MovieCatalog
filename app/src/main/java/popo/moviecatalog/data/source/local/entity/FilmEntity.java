package popo.moviecatalog.data.source.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "moviesentities")
public class FilmEntity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "filmId")
    private String filmId;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "desc")
    private String desc;

    @ColumnInfo(name = "tgl")
    private String tgl;

    @ColumnInfo(name = "img")
    private String img;

    @ColumnInfo(name = "vote")
    private String vote;

    @ColumnInfo(name = "runtime")
    private String runtime;

    @ColumnInfo(name = "lang")
    private String lang;

    @ColumnInfo(name = "revenue")
    private String revenue;

    @ColumnInfo(name = "favorited")
    private boolean favorited = false;

    public FilmEntity() {

    }

    public FilmEntity(@NonNull String filmId, String title, String desc, String tgl, String img, String progress, String runtime, String lang, String revenue, Boolean favorited) {
        this.filmId = filmId;
        this.title = title;
        this.desc = desc;
        this.tgl = tgl;
        this.img = img;
        this.vote = progress;
        this.runtime = runtime;
        this.lang = lang;
        this.revenue = revenue;
        if (favorited != null) {
            this.favorited = favorited;
        }
    }

    public FilmEntity(@NonNull String filmId, String title, String progress, String desc, String tgl, String img, String lang) {
        this.filmId = filmId;
        this.title = title;
        this.vote = progress;
        this.desc = desc;
        this.tgl = tgl;
        this.img = img;
        this.lang = lang;
    }

    public FilmEntity(@NonNull String filmId, String title, String desc, String tgl, String img, String runtime, String lang, String revenue) {
        this.filmId = filmId;
        this.title = title;
        this.desc = desc;
        this.tgl = tgl;
        this.img = img;
        this.runtime = runtime;
        this.lang = lang;
        this.revenue = revenue;
    }


    @NonNull
    public String getFilmId() {
        return filmId;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getTgl() {
        return tgl;
    }

    public String getImg() {
        return img;
    }

    public String getVote() {
        return vote;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getLang() {
        return lang;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setFilmId(@NonNull String filmId) {
        this.filmId = filmId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }
}
