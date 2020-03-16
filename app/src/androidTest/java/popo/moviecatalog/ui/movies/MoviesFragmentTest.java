package popo.moviecatalog.ui.movies;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import popo.moviecatalog.R;
import popo.moviecatalog.testing.SingleFragmentActivity;
import popo.moviecatalog.utils.EspressoIdlingResource;
import popo.moviecatalog.utils.RecyclerViewItemCountAssertion;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class MoviesFragmentTest {
    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private MoviesFragment moviesFragment = new MoviesFragment();

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
        onView(withId(R.id.rv_film)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_film)).check(new RecyclerViewItemCountAssertion(20));
    }
}