package com.mrjalal.androidcore.activity_lunch_mode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mrjalal.androidcore.R;

public class LunchModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_mode);

        activityLaunchModeDemo_singleTop();
    }

    private void activityLaunchModeDemo_singleTop(){
        setLunchModeTitle("LaunchMode: singleTop");
        // previous stack
        startActivityInStandardMode(A_Activity.class);
        startActivityInStandardMode(B_Activity.class);
        startActivityInStandardMode(C_Activity.class);
        startActivityInStandardMode(D_Activity.class);
        // start in single-top mode
//        startActivityInStandardMode(D_Activity.class);
    }

    private void startActivityInStandardMode(Class activityClass){
        Intent intent = new Intent(getApplicationContext(), activityClass);
        startActivity(intent);
    }

    private void startActivityInSingleTopMode(Class activityClass){
        Intent intent = new Intent(getApplicationContext(), activityClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    private void setLunchModeTitle(String lunchModeName){
        ((TextView)findViewById(R.id.textView)).setText(lunchModeName);
    }
}
