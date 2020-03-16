package popo.moviecatalog.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

public class CastResponse implements Parcelable {
    private String id;
    private String img;
    private String name;
    private String title;

    public CastResponse() {
    }

    public CastResponse(String id, String img, String name, String title) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.title = title;
    }

    protected CastResponse(Parcel in) {
        id = in.readString();
        img = in.readString();
        name = in.readString();
        title = in.readString();
    }

    public static final Creator<CastResponse> CREATOR = new Creator<CastResponse>() {
        @Override
        public CastResponse createFromParcel(Parcel in) {
            return new CastResponse(in);
        }

        @Override
        public CastResponse[] newArray(int size) {
            return new CastResponse[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(img);
        parcel.writeString(name);
        parcel.writeString(title);
    }
}
