package popo.moviecatalog.ui.favorite;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import popo.moviecatalog.testing.SingleFragmentActivity;
import popo.moviecatalog.ui.favorite.movies.MoviesFavoriteFragment;
import popo.moviecatalog.utils.EspressoIdlingResource;

public class MoviesFavoriteFragmentTest {
    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private MoviesFavoriteFragment moviesFragment = new MoviesFavoriteFragment();

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
        activityRule.getActivity().setFragment(moviesFragment);
    }

    @After
    public void tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void load() {
//        onView(withId(R.id.rv_film)).check(matches(isDisplayed()));
//        onView(withId(R.id.rv_film)).check(new RecyclerViewItemCountAssertion(20));
    }
}