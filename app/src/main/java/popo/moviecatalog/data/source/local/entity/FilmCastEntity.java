package popo.moviecatalog.data.source.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "filmcastentities")
public class FilmCastEntity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "castId")
    private String castId;

    @ColumnInfo(name = "filmId")
    private String filmId;

    @ColumnInfo(name = "img")
    private String img;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "title")
    private String title;

    public FilmCastEntity(@NonNull String castId, String filmId, String img, String name, String title) {
        this.castId = castId;
        this.filmId = filmId;
        this.img = img;
        this.name = name;
        this.title = title;
    }

    @NonNull
    public String getFilmId() {
        return filmId;
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public void setFilmId(@NonNull String filmId) {
        this.filmId = filmId;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NonNull
    public String getCastId() {
        return castId;
    }

    public void setCastId(@NonNull String castId) {
        this.castId = castId;
    }
}
