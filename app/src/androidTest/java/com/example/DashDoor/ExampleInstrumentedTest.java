package com.example.DashDoor;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;

import static org.junit.Assert.assertEquals;

import android.content.Context;
import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.intent.Intents;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.GrantPermissionRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.DashDoor", appContext.getPackageName());
    }

    @Before
    public void setUp() {
        Intents.init();
    }

    @After
    public void tearDown() {
        Intents.release();
    }

    @Test
    public void testBurgerButtonLaunchesBurgerActivity() {
        ActivityScenario.launch(OrderPageActivity.class);

        onView(withId(R.id.buttonBurger)).perform(click());

        intended(hasComponent(BurgerActivity.class.getName()));
    }

    @Test
    public void testPizzaButtonLaunchePizzaActivity() {
        ActivityScenario.launch(OrderPageActivity.class);

        onView(withId(R.id.buttonPizza)).perform(click());

        intended(hasComponent(PizzaActivity.class.getName()));
    }


    /**
     * Test to check if the Place Order button launches the CheckoutActivity.
     * Andre Gutierrez
     */
    @Test
    public void testPlaceOrderButtonLaunchesCheckoutActivity() {
        ActivityScenario.launch(OrderPageActivity.class);

        onView(withId(R.id.placeOrderButton)).perform(click());

        intended(hasComponent(CheckoutActivity.class.getName()));
    }

    /**
     * Test to check if the Admin login works.
     * Andre Gutierrez
     */
    @Test
    public void loginAsAdmin() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra("username", "admin");
        intent.putExtra("password", "admin");
        ActivityScenario.launch(intent);
    }

    /**
     * Test to check if the User login works.
     * Andre Gutierrez
     */
    @Test
    public void loginAsUser() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra("username", "user");
        intent.putExtra("password", "user");
        ActivityScenario.launch(intent);
    }

    /**
     * testing admin login
     * Rene
     */
    @Test
    public void loginAdmin() {
        ActivityScenario.launch(LoginActivity.class);


        String username = "admin1";
        String password = "admin1";

        onView(withId(R.id.userNameLoginEditText))
                .perform(typeText(username));

        onView(withId(R.id.passwordLoginEditText))
                .perform(typeText(password));

        onView(withId(R.id.loginButton)).perform(click());

        intended(hasComponent(MainActivity.class.getName()));
    }
}