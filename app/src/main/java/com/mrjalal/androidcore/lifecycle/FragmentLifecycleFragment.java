package com.mrjalal.androidcore.lifecycle;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrjalal.androidcore.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLifecycleFragment extends Fragment {
    private final String TAG = FragmentLifecycleFragment.class.getSimpleName();


    public FragmentLifecycleFragment() {
        // Required empty public constructor
    }


    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        Log.i(TAG, "onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState)");
        super.onInflate(context, attrs, savedInstanceState);
    }

    /**
     * step 4
     * fragment is not visible yet
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        Log.i(TAG, "onAttach(Context context)");
        super.onAttach(context);
    }

    /**
     * step 5
     * fragment is not visible yet
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreate(@Nullable Bundle savedInstanceState)");
        super.onCreate(savedInstanceState);
    }

    /**
     * step 6
     * fragment is not visible yet
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i(TAG, "onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)");
        return inflater.inflate(R.layout.fragment_fragment_lifecycle, container, false);
    }

    /**
     * step 7
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onViewCreated(View view, @Nullable Bundle savedInstanceState)");
        super.onViewCreated(view, savedInstanceState);
    }

    /**
     * step 8
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onActivityCreated(@Nullable Bundle savedInstanceState)");
        super.onActivityCreated(savedInstanceState);
    }

    /**
     * step 9
     * @param savedInstanceState
     */
    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onViewStateRestored(@Nullable Bundle savedInstanceState)");
        super.onViewStateRestored(savedInstanceState);
    }

    /**
     * step 10
     */
    @Override
    public void onStart() {
        Log.i(TAG, "onStart()");
        super.onStart();
    }

    /**
     * step 13
     */
    @Override
    public void onResume() {
        Log.i(TAG, "onResume()");
        super.onResume();
    }

    /**
     * step 19
     */
    @Override
    public void onPause() {
        Log.i(TAG, "onPause()");
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.i(TAG, "onSaveInstanceState(Bundle outState)");
        super.onSaveInstanceState(outState);
    }

    /**
     * step 21
     */
    @Override
    public void onStop() {
        Log.i(TAG, "onStop()");
        super.onStop();
    }

    /**
     * step 23
     */
    @Override
    public void onDestroyView() {
        Log.i(TAG, "onDestroyView()");
        super.onDestroyView();
    }

    /**
     * step 24
     */
    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy()");
        super.onDestroy();
    }

    /**
     * step 25
     */
    @Override
    public void onDetach() {
        Log.i(TAG, "onDetach()");
        super.onDetach();
    }

}
