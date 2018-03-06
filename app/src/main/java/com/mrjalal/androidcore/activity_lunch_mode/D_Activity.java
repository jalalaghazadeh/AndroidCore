package com.mrjalal.androidcore.activity_lunch_mode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mrjalal.androidcore.R;

public class D_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_);

        findViewById(R.id.textView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // checking single-top demo
//                Intent intent = new Intent(getApplicationContext(), D_Activity.class);
                // checking single-task demo
//                Intent intent = new Intent(getApplicationContext(), C_Activity.class);
                // checking single-instance demo
//                Intent intent = new Intent(getApplicationContext(), E_Activity.class);
                // checking standard demo
                Intent intent = new Intent(getApplicationContext(), B_Activity.class);


                startActivity(intent);
            }
        });
    }
}
