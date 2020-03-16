package popo.moviecatalog.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

public class GenreResponse implements Parcelable {
    private String id;
    private String genre;

    public GenreResponse() {

    }

    public GenreResponse(String id, String genre) {
        this.id = id;
        this.genre = genre;
    }

    protected GenreResponse(Parcel in) {
        id = in.readString();
        genre = in.readString();
    }

    public static final Creator<GenreResponse> CREATOR = new Creator<GenreResponse>() {
        @Override
        public GenreResponse createFromParcel(Parcel in) {
            return new GenreResponse(in);
        }

        @Override
        public GenreResponse[] newArray(int size) {
            return new GenreResponse[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(genre);
    }
}
