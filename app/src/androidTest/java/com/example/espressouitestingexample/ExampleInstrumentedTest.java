package com.example.espressouitestingexample;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    String testString;

    @Rule
    public ActivityScenarioRule<MainActivity> mMainActivityRule =
            new ActivityScenarioRule(MainActivity.class);


    @Before
    public void setup() {
        testString = "Hello Worl!";
    }

    @Test
    public void initialTest() {
        //identify the view you want to test
        onView(withId(R.id.example_et))
                //perform the assertion
                .check(matches(withText(testString)));
    }

    @Test
    public void ourTest() {
        String ourText = "Some other thing";

        //we click on edit text
        onView(withId(R.id.example_et))
                .perform(click(),
                        clearText(),
                        typeText(ourText),
                        closeSoftKeyboard())
                //check if our string equals what's typed in Edit text
                .check(matches(withText(ourText)));
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.espressouitestingexample", appContext.getPackageName());
    }
}