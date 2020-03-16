package popo.moviecatalog.data.source.local.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import popo.moviecatalog.data.source.local.entity.FilmCastEntity;
import popo.moviecatalog.data.source.local.entity.FilmEntity;
import popo.moviecatalog.data.source.local.entity.FilmGenreEntity;
import popo.moviecatalog.data.source.local.entity.TvShowEntity;

@Database(entities = {FilmEntity.class, TvShowEntity.class, FilmGenreEntity.class, FilmCastEntity.class},
        version = 1,
        exportSchema = false)
public abstract class MoviesDatabase extends RoomDatabase {
    private static final Object sLock = new Object();
    private static MoviesDatabase INSTANCE;

    public static MoviesDatabase getInstance(Context context){
        synchronized (sLock){
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        MoviesDatabase.class, "Movies.db")
                        .build();
            }
        }
        return INSTANCE;
    }

    public abstract MoviesDao moviesDao();
}
