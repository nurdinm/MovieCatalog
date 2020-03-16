package popo.moviecatalog.di;

import android.app.Application;

import popo.moviecatalog.data.source.MoviesRepository;
import popo.moviecatalog.data.source.local.LocalRepository;
import popo.moviecatalog.data.source.local.room.MoviesDatabase;
import popo.moviecatalog.data.source.remote.RemoteRepository;
import popo.moviecatalog.utils.AppExecutors;
import popo.moviecatalog.utils.JsonHelper;

public class Injection {
    public static MoviesRepository provideRepository(Application application) {

        MoviesDatabase database = MoviesDatabase.getInstance(application);

        LocalRepository localRepository = LocalRepository.getInstance(database.moviesDao());
        RemoteRepository remoteRepository = RemoteRepository.getInstance(new JsonHelper(application));
        AppExecutors appExecutors = new AppExecutors();

        return MoviesRepository.getInstance(localRepository, remoteRepository, appExecutors);
    }
}
