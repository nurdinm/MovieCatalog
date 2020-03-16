package popo.moviecatalog.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import popo.moviecatalog.R;
import popo.moviecatalog.ui.detail.DetailFilmActivity;
import popo.moviecatalog.ui.favorite.FavoriteFragment;
import popo.moviecatalog.ui.movies.MoviesFragment;
import popo.moviecatalog.ui.tvshow.TvShowFragment;

public class HomeActivity extends AppCompatActivity  {
    @BindView(R.id.nav_view) BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onNewIntent(getIntent());
        ButterKnife.bind(this);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        if (savedInstanceState != null) {
            String SELECTED_MENU = "selected_menu";
            savedInstanceState.getInt(SELECTED_MENU);
        } else {
            navigationView.setSelectedItemId(R.id.nav_movies);
        }


    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = item -> {
        Fragment fragment = null;
        if (item.getItemId() == R.id.nav_movies) {
            fragment = MoviesFragment.newInstance();
        } else if (item.getItemId() == R.id.nav_tvshow) {
            fragment = TvShowFragment.newInstance();
        }else if (item.getItemId() == R.id.nav_favorite) {
            fragment = FavoriteFragment.newInstance();
        }

        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.content_main, fragment)
                    .commit();
        }
        return true;
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String action = intent.getAction();
        String data = intent.getDataString();
        if (Intent.ACTION_VIEW.equals(action) && data != null) {
            String filmId = data.substring(data.lastIndexOf("/") + 1);
            String JENIS = data.substring(31,37);
            Intent detail = new Intent(this, DetailFilmActivity.class);
            detail.putExtra(DetailFilmActivity.EXTRA_MOVIE, filmId);
            detail.putExtra(DetailFilmActivity.JENIS_MOVIE, JENIS);
            startActivity(detail);
        }
    }

}
