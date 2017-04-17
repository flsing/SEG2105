package com.example.eyobt.cook;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


/**
 * This class deals with the loading page.
 */
public class Progress extends AppCompatActivity {

    /**
     * On creating the page
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        //sets the time of the loading screen to appear
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent mainIntent = new Intent(Progress.this, SearchedResult.class);
                Progress.this.startActivity(mainIntent);
                Progress.this.finish();
            }
        },2500) ;


    }

}
