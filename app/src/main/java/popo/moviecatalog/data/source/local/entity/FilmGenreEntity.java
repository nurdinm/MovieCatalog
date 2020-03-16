package popo.moviecatalog.data.source.local.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "filmgenrentities")
public class FilmGenreEntity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "genreId")
    private String genreId;

    @ColumnInfo(name = "filmId")
    private String filmId;

    @ColumnInfo(name = "title")
    private String title;

    public FilmGenreEntity(String genreId,String filmId, String title) {
        this.genreId = genreId;
        this.filmId = filmId;
        this.title = title;
    }

    @NonNull
    public String getGenreId() {
        return genreId;
    }

    public void setGenreId(@NonNull String genreId) {
        this.genreId = genreId;
    }

    public String getFilmId() {
        return filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
