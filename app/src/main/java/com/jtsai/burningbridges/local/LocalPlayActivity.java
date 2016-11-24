package com.jtsai.burningbridges.local;

import android.animation.ObjectAnimator;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.jtsai.burningbridges.R;

public class LocalPlayActivity extends AppCompatActivity {

    LocalGameLogic mLogic;
    Button pullTriggerBtn;
    Button playAgainBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_play);

        mLogic = LocalGameLogic.getInstance();
        mLogic.startLocalGame();

        setupViews();
        setupClickListeners();
    }

    private void setupViews() {
        playAgainBtn = (Button) findViewById(R.id.local_play_play_again_btn);
        pullTriggerBtn = (Button) findViewById(R.id.local_play_pull_btn);
    }

    private void setupClickListeners() {
        playAgainBtn.setOnClickListener(playAgainOnClickListener);
        pullTriggerBtn.setOnClickListener(pullTriggerOnClickListener);
    }

    OnClickListener pullTriggerOnClickListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mLogic.pullTrigger()) {
                setDeathState();
            }
        }
    };

    OnClickListener playAgainOnClickListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            setInitState();
            mLogic.startLocalGame();
        }
    };

    private void setInitState() {
        pullTriggerBtn.setEnabled(true);
        pullTriggerBtn.setText(getString(R.string.local_play_pull_btn));
        pullTriggerBtn.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color
                .colorPullBackground));
    }

    private void setDeathState() {
        pullTriggerBtn.setEnabled(false);
        pullTriggerBtn.setText("YOU DIED.");
        pullTriggerBtn.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color
                .colorDeathBackground));
    }
}
