package com.mrjalal.androidcore.service_intentservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mrjalal.androidcore.R;

public class ServiceVsIntentServiceActivity extends AppCompatActivity {

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    private Intent serviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_vs_intent_service);
        setTitle("Service vs. IntentService");
        serviceIntent = new Intent(getApplicationContext(), MyService.class);
        startService();
    }

    @Override
    protected void onDestroy() {
        stopService();
        super.onDestroy();
    }

    private void setTitle(String title){
        ((TextView)findViewById(R.id.textView)).setText(title);
    }

    private void startService(){
        bindService(serviceIntent, serviceConnection, Context.BIND_AUTO_CREATE);
        startService(serviceIntent);
    }

    private void stopService(){
        stopService(serviceIntent);
        unbindService(serviceConnection);
    }
}
