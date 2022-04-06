package com.cst2335.exercises;


import static android.service.autofill.Validators.not;

import androidx.test.espresso.ViewInteraction;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.WindowManager;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {
    @Rule
    public ActivityScenarioRule<MainActivity> mActivityRule =
            new ActivityScenarioRule<>(MainActivity.class);


    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.cst2335.exercises", appContext.getPackageName());
    }

    @Test
    public void ensureInitialForm_OK() {
        ViewInteraction textView = onView(
                allOf(withId(R.id.enterEmailId), withText("Enter Email"),
                        withParent(withParent(withId(R.id.flContainer))),
                        isDisplayed()));
        textView.check(matches(withText("Enter Email")));

        ViewInteraction editText = onView(
                allOf(withId(R.id.inputEmailId),
                        withParent(withParent(withId(R.id.flContainer))),
                        isDisplayed()));
        editText.check(matches(withText("")));

        //Name
        ViewInteraction textView2 = onView(
                allOf(withId(R.id.enterNameId), withText("Enter Name"),
                        withParent(withParent(withId(R.id.flContainer))),
                        isDisplayed()));
        textView2.check(matches(withText("Enter Name")));

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.inputNameId),
                        withParent(withParent(withId(R.id.flContainer))),
                        isDisplayed()));
        editText2.check(matches(withText("")));

        ViewInteraction button = onView (
                allOf(withId(R.id.saveButton), withText("Submit"),
                        withParent(withParent(withId(R.id.flContainer))),
                        isDisplayed()));

        button.check(matches(notNullValue()));
        button.check(matches(withText("Submit")));
    }

    @Test
    public void ensureInfoInput_OK() {
        // Type text and then press the button.

        //Enter the name
        //Name
        ViewInteraction textView2 = onView(
                allOf(withId(R.id.enterNameId), withText("Enter Name"),
                        withParent(withParent(withId(R.id.flContainer))),
                        isDisplayed()));
        textView2.check(matches(withText("Enter Name")));

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.inputNameId),
                        withParent(withParent(withId(R.id.flContainer))),
                        isDisplayed()));

        editText2.perform(typeText("Robert Smith"), closeSoftKeyboard());

        // withId() is a ViewMatcher
        onView(withId(R.id.inputEmailId))
                .perform(typeText("hello@company.com"), closeSoftKeyboard());

        // Check that the text was changed.
        // withId() is a ViewMatcher
        // matches() is a ViewAssertion
        onView(withId(R.id.inputEmailId)).check(matches(withText("hello@company.com")));

        // withId() is a ViewMatcher
        // click() is a ViewAction
        // matches() is a ViewAssertion
        onView(withId(R.id.saveButton)).perform(click());

        //Check that the new fragment appears
        onView(withId(R.id.infoSavedId)).check(matches(withText(R.string.user_info_saved)));
    }



    @Test
    public void checkForInvalidName_Error() {

        //Name
        ViewInteraction textView2 = onView(
                allOf(withId(R.id.enterNameId), withText("Enter Name"),
                        withParent(withParent(withId(R.id.flContainer))),
                        isDisplayed()));
        textView2.check(matches(withText("Enter Name")));

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.inputNameId),
                        withParent(withParent(withId(R.id.flContainer))),
                        isDisplayed()));
        editText2.check(matches(withText("")));

        ViewInteraction button = onView (
                allOf(withId(R.id.saveButton), withText("Submit"),
                        withParent(withParent(withId(R.id.flContainer))),
                        isDisplayed()));

        button.check(matches(withText("Submit")));

        onView(withId(R.id.saveButton)).perform(click());

        onView(withId(R.id.inputNameId))
                .check(matches(hasErrorText("Enter a valid name here")));


    }


}