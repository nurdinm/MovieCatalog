package popo.moviecatalog.ui.detail;

import android.content.Context;
import android.content.Intent;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import popo.moviecatalog.R;
import popo.moviecatalog.data.source.local.entity.FilmEntity;
import popo.moviecatalog.utils.EspressoIdlingResource;
import popo.moviecatalog.utils.FakeDataDummy;
import popo.moviecatalog.utils.RecyclerViewItemCountAssertion;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class DetailFilmActivityTest {
    private FilmEntity dummyFilm = FakeDataDummy.generateDummyMovies().get(0);

    @Rule
    public ActivityTestRule<DetailFilmActivity> activityRule = new ActivityTestRule<DetailFilmActivity>(DetailFilmActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(targetContext, DetailFilmActivity.class);
            result.putExtra(DetailFilmActivity.EXTRA_MOVIE, dummyFilm.getFilmId());
            result.putExtra(DetailFilmActivity.JENIS_MOVIE, "MOVIES");
            return result;
        }
    };

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadFilm() {
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title)).check(matches(withText(dummyFilm.getTitle())));
    }

    @Test
    public void loadGenre() {
        onView(withId(R.id.rv_genre)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_genre)).check(new RecyclerViewItemCountAssertion(3));
    }

    @Test
    public void loadCast() {
        onView(withId(R.id.rv_cast)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_cast)).check(new RecyclerViewItemCountAssertion(6));
    }
}