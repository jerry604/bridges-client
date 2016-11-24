package com.jtsai.burningbridges;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

import com.jtsai.burningbridges.local.LocalPlayActivity;

public class MainActivity extends AppCompatActivity {

    Button localPlayBtn;
    Button onlinePlayBtn;
    Button onlineHCPlayBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
        setupClickListeners();
    }

    private void setupViews() {
        localPlayBtn = (Button) findViewById(R.id.main_play_local_btn);
        onlinePlayBtn = (Button) findViewById(R.id.main_play_online_btn);
        onlineHCPlayBtn = (Button) findViewById(R.id.main_play_online_hc_btn);
    }

    private void setupClickListeners() {
        localPlayBtn.setOnClickListener(localPlayOnClickListener);
    }

    /**
     * CLICK LISTENERS
     */

    OnClickListener localPlayOnClickListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), LocalPlayActivity.class);
            startActivity(intent);
        }
    };
}
