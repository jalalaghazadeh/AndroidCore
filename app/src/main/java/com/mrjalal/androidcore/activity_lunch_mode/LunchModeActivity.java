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

//        activityLaunchModeDemo_singleTop();
//        activityLaunchMOdeDemo_singleTask();
//        activityLaunchModeDemo_singleInstance();
        activityLaunchModeDemo_standard();

    }

    private void activityLaunchModeDemo_singleTop(){
        setLunchModeTitle("LaunchMode: singleTop");
        // previous stack
        startActivityInStandardMode(A_Activity.class);
        startActivityInStandardMode(B_Activity.class);
        startActivityInStandardMode(C_Activity.class);
        startActivityInStandardMode(D_Activity.class);

        /*
        step 1
        **** Previous State of Activity Stack ****
        D -D is on top of Activity Stack

        C

        B

        A

        step 2
        --> Start D from any service or other application or from somewhere. (D_Activity will be lunched by touching activity-name in D_Activity & C_Activity)

        step 3
        **** Final State of Activity Stack ****
        D -old instance gets extras data through onNewIntent(Intent intent);

        C

        B

        A
        */
    }

    private void activityLaunchMOdeDemo_singleTask(){
        setLunchModeTitle("LaunchMode: singleTask");
        // previous stack
        startActivityInStandardMode(A_Activity.class);
        startActivityInStandardMode(B_Activity.class);
        startActivityInStandardMode(C_Activity.class);
        startActivityInStandardMode(D_Activity.class);

        /*
        step 1
        **** Previous State of Activity Stack ****
        D

        C

        B

        A

        step 2
        --> Start C (C_Activity will be lunched by touching activity-name in D_Activity)

        step 3
        **** Final State of Activity Stack ****
        C -old instance gets extras data through onNewIntent(Intent intent);

        B

        A
        */
    }

    private void activityLaunchModeDemo_singleInstance(){
        setLunchModeTitle("LaunchMode: singleInstance");
        // previous stack
        startActivityInStandardMode(A_Activity.class);
        startActivityInStandardMode(B_Activity.class);
        startActivityInStandardMode(C_Activity.class);
        startActivityInStandardMode(D_Activity.class);

        /*
        step 1
        **** Previous State of Activity Stack ****
        D

        C

        B

        A

        step 2
        --> Start E (E_Activity will be lunched by touching activity-name in D_Activity)

        step 3
        **** Final State of Activity Stack ****
        E

        — — — — — — — — — — — — — — — — — — — — — — — — — — — — — —

        D

        C

        B

        A
        info — A , B , C , D will be in one task and E will be in another task.

        step 4
        --> Start F (F_Activity will be lunched by touching activity-name in E_Activity)

        step 5
        Final State of Activity Stack

        F

        D

        C

        B

        A

        — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — –

        E
        info — A , B , C , D , F will be in one task and E will be in another task.
        */
    }

    private void activityLaunchModeDemo_standard(){
        setLunchModeTitle("LaunchMode: Standard");
        // previous stack
        startActivityInStandardMode(A_Activity.class);
        startActivityInStandardMode(B_Activity.class);
        startActivityInStandardMode(C_Activity.class);
        startActivityInStandardMode(D_Activity.class);

        /*
        step 1
        **** Previous State of Activity Stack ****
        D

        C

        B

        A

        step 2
        --> Start B (B_Activity will be lunched by touching activity-name in D_Activity)

        step 3
        **** Final State of Activity Stack ****
        B -new instance of B

        D

        C

        B

        A
        */
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
