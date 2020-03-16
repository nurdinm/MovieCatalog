package popo.moviecatalog.ui.favorite;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import popo.moviecatalog.testing.SingleFragmentActivity;
import popo.moviecatalog.ui.tvshow.TvShowFragment;
import popo.moviecatalog.utils.EspressoIdlingResource;

public class TvShowFavoriteFragmentTest {
    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private TvShowFragment tvShowFragment = new TvShowFragment();

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
        activityRule.getActivity().setFragment(tvShowFragment);
    }


    @After
    public void tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadTvShow() {
//        onView(withId(R.id.rv_film)).check(matches(isDisplayed()));
//        onView(withId(R.id.rv_film)).check(new RecyclerViewItemCountAssertion(20));
    }
}