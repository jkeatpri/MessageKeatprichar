package com.example.messagekeatprichar;

import static com.example.messagekeatprichar.MainActivity.PREF_NIGHT;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MessageActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.messagekeatprichar.MESSAGE";
    public static final String EXTRA_RESULT = "com.example.messagekeatprichar.RESULT";

    @Override
    protected  void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        SharedPreferences preferences = getSharedPreferences("Keatprichar", Activity.MODE_PRIVATE);
        boolean night = preferences.getBoolean(PREF_NIGHT, false);
        initializeNightMode(night);
        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);
        TextView tvMessage = findViewById(R.id.tvMessage);
        tvMessage.setText(message);

        btnSaveListenerMethod();
    }

    private void initializeNightMode(boolean night) {
        ConstraintLayout clMessage = findViewById(R.id.clMessage);
        int textviews[] = {R.id.tvLabel, R.id.tvMessage, R.id.rbGood, R.id.rbBad};
        if (night) {
            clMessage.setBackgroundColor(Color.BLACK);
            for (int tv : textviews) {
                TextView view = findViewById(tv);
                view.setTextColor(Color.WHITE);
            }
        } else {
            clMessage.setBackgroundColor(Color.WHITE);
            for (int tv : textviews) {
                TextView view = findViewById(tv);
                view.setTextColor(Color.BLACK);
            }
        }
    }

    private void btnSaveListenerMethod() {
        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean good;
                RadioButton rbGood = findViewById(R.id.rbGood);
                if(rbGood.isChecked()){
                    good = true;
                } else{
                    good = false;
                }
                Intent outIntent = new Intent();
                outIntent.putExtra(EXTRA_RESULT, good);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}
