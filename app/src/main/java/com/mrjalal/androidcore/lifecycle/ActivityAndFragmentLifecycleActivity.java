package com.mrjalal.androidcore.lifecycle;

import android.app.Fragment;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.mrjalal.androidcore.R;

public class ActivityAndFragmentLifecycleActivity extends AppCompatActivity {

    /*
    *** sequence on LIFECYCLE steps that triggered one after another for an activity

    ActivityAndFragmentLifecycleActivity: onCreate(Bundle savedInstanceState)
    ActivityAndFragmentLifecycleActivity: onContentChanged()
    ActivityAndFragmentLifecycleActivity: onStart()
    ActivityAndFragmentLifecycleActivity: onPostCreate(@Nullable Bundle savedInstanceState)
    ActivityAndFragmentLifecycleActivity: onResume()
    ActivityAndFragmentLifecycleActivity: onPostResume()
    ActivityAndFragmentLifecycleActivity: onAttachedToWindow()
    ActivityAndFragmentLifecycleActivity: onCreateOptionsMenu(Menu menu)
    ActivityAndFragmentLifecycleActivity: onPrepareOptionsMenu(Menu menu) // activity is Visible
    ******** activity is live NOW ********
    ActivityAndFragmentLifecycleActivity: onPause()                       // activity is Invisible
    ActivityAndFragmentLifecycleActivity: onStop()
    ActivityAndFragmentLifecycleActivity: onDestroy()


    *** sequence on LIFECYCLE steps that triggered on after another for a fragment which has been hosted by an activity ***

    ActivityAndFragmentLifecycleActivity: onCreate(Bundle savedInstanceState)
    ActivityAndFragmentLifecycleActivity: onContentChanged()
    ActivityAndFragmentLifecycleActivity: onStart()
    FragmentLifecycleFragment:            onAttach(Context context)
    FragmentLifecycleFragment:            onCreate(@Nullable Bundle savedInstanceState)
    FragmentLifecycleFragment:            onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    FragmentLifecycleFragment:            onViewCreated(View view, @Nullable Bundle savedInstanceState)
    FragmentLifecycleFragment:            onActivityCreated(@Nullable Bundle savedInstanceState)
    FragmentLifecycleFragment:            onViewStateRestored(@Nullable Bundle savedInstanceState)
    FragmentLifecycleFragment:            onStart()
    ActivityAndFragmentLifecycleActivity: onPostCreate(@Nullable Bundle savedInstanceState)
    ActivityAndFragmentLifecycleActivity: onResume()
    FragmentLifecycleFragment:            onResume()
    ActivityAndFragmentLifecycleActivity: onPostResume()
    ActivityAndFragmentLifecycleActivity: onAttachedToWindow()
    ActivityAndFragmentLifecycleActivity: onCreateOptionsMenu(Menu menu)
    ActivityAndFragmentLifecycleActivity: onPrepareOptionsMenu(Menu menu) // activity and fragment are Visible
    ******** activity and fragment are live NOW ********
    ActivityAndFragmentLifecycleActivity: onPause()                       // activity and fragment are Invisible
    FragmentLifecycleFragment:            onPause()
    ActivityAndFragmentLifecycleActivity: onStop()
    FragmentLifecycleFragment:            onStop()
    ActivityAndFragmentLifecycleActivity: onDestroy()
    FragmentLifecycleFragment:            onDestroyView()
    FragmentLifecycleFragment:            onDestroy()
    FragmentLifecycleFragment:            onDetach()

    */

    private final String TAG = ActivityAndFragmentLifecycleActivity.class.getSimpleName();

    /**
     * step1
     * status_bar color is set
     *
     * In the onCreate() method, you perform basic application startup logic that should happen only
     * once for the entire life of the activity.
     * For example, your implementation of onCreate() might
     *** bind data to lists,
     *** initialize background threads, and
     *** instantiate some class-scope variables.
     *
     * This is where most initialization should go:
     *** calling setContentView(int) to inflate the activity's UI,
     *** using findViewById(int) to programmatically interact with widgets in the UI,
     *** calling managedQuery(android.net.Uri, String[], String, String[], String) to retrieve cursors for data being displayed, etc.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate(Bundle savedInstanceState)");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_and_fragment_lifecycle);
        getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container, new FragmentLifecycleFragment()).commit();
    }

    /**
     * step 2
     * activity and fragment are still not visible yet
     */
    @Override
    public void onContentChanged() {
        Log.i(TAG, "onContentChanged()");
        super.onContentChanged();
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        Log.i(TAG, "onAttachFragment(Fragment fragment)");
        super.onAttachFragment(fragment);
    }

    /**
     * step 3
     * activity and fragment are still not visible yet
     *
     * this method is where the app initializes the code that maintains the UI.
     * It might also register a BroadcastReceiver that monitors changes that are reflected in the UI.
     */
    @Override
    protected void onStart() {
        Log.i(TAG, "onStart()");
        super.onStart();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.i(TAG, "onRestoreInstanceState(Bundle savedInstanceState)");
        super.onRestoreInstanceState(savedInstanceState);
    }

    /**
     * step 11
     * @param savedInstanceState
     */
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onPostCreate(@Nullable Bundle savedInstanceState)");
        super.onPostCreate(savedInstanceState);
    }

    /**
     * step 12
     */
    @Override
    protected void onResume() {
        Log.i(TAG, "onResume()");
        super.onResume();
    }

    /**
     * step 14
     *
     * This is the state in which the app interacts with the user.
     * The app stays in this state until something happens to take focus away from the app.
     * Such an event might be, for instance, receiving a phone call, the user’s navigating
     * to another activity, or the device screen’s turning off.
     *
     * If the activity returns to the Resumed state from the Paused state, the system once
     * again calls onResume() method. For this reason, you should implement onResume()
     * to initialize components that you release during onPause().
     * For example, you may initialize the camera
     */
    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.i(TAG, "onPostResume()");
    }

    /**
     * step 15
     */
    @Override
    public void onAttachedToWindow() {
        Log.i(TAG, "onAttachedToWindow()");
        super.onAttachedToWindow();
    }

    /**
     * step 16
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i(TAG, "onCreateOptionsMenu(Menu menu)");
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * step 17
     * @param menu
     * @return
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Log.i(TAG, "onPrepareOptionsMenu(Menu menu)");
        return super.onPrepareOptionsMenu(menu);
    }

    /**
     * step 18
     */
    @Override
    protected void onPause() {
        Log.i(TAG, "onPause()");
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        Log.i(TAG, "onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState)");
        super.onSaveInstanceState(outState, outPersistentState);
    }

    /**
     * step 20
     */
    @Override
    protected void onStop() {
        Log.i(TAG, "onStop()");
        super.onStop();
    }

    /**
     * step 22
     */
    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy()");
        super.onDestroy();
    }

//    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void logStartEvent(){}

}
