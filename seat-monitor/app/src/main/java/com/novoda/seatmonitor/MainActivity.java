package com.novoda.seatmonitor;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class MainActivity extends Activity {

    private Handler handler;
    private Ads1015 ads1015;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ads1015 = new Ads1015.Factory().newInstance("I2C1", 0x48);
        Log.d("TUT", "oncreate");
        HandlerThread thread = new HandlerThread("backgroundMeasure");
        thread.start();
        handler = new Handler(thread.getLooper());
        handler.post(loop);
    }

    private final Runnable loop = new Runnable() {
        @Override
        public void run() {

            Log.d("TUT", "Differential " + ads1015.readADC_SingleEnded(0));

            handler.postDelayed(this, TimeUnit.SECONDS.toMillis(1));
        }
    };

}
