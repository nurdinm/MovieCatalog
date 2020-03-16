package popo.moviecatalog.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

public class MoviesResponse implements Parcelable {
    private String filmId;
    private String title;
    private String desc;
    private String tgl;
    private String img;
    private String vote;
    private String runtime;
    private String lang;
    private String revenue;

    public MoviesResponse() {

    }

    public MoviesResponse(String filmId, String title, String desc, String tgl, String img, String vote, String runtime, String lang, String revenue) {
        this.filmId = filmId;
        this.title = title;
        this.desc = desc;
        this.tgl = tgl;
        this.img = img;
        this.vote = vote;
        this.runtime = runtime;
        this.lang = lang;
        this.revenue = revenue;
    }

    private MoviesResponse(Parcel in) {
        filmId = in.readString();
        title = in.readString();
        desc = in.readString();
        tgl = in.readString();
        img = in.readString();
        vote = in.readString();
        runtime = in.readString();
        lang = in.readString();
        revenue = in.readString();
    }

    public static final Creator<MoviesResponse> CREATOR = new Creator<MoviesResponse>() {
        @Override
        public MoviesResponse createFromParcel(Parcel in) {
            return new MoviesResponse(in);
        }

        @Override
        public MoviesResponse[] newArray(int size) {
            return new MoviesResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(filmId);
        parcel.writeString(title);
        parcel.writeString(desc);
        parcel.writeString(tgl);
        parcel.writeString(img);
        parcel.writeString(vote);
        parcel.writeString(runtime);
        parcel.writeString(lang);
        parcel.writeString(revenue);
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }
}
