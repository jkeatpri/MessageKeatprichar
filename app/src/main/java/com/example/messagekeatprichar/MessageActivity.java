package com.example.messagekeatprichar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MessageActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.messagekeatprichar.MESSAGE";

    @Override
    protected  void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);
        TextView tvMessage = findViewById(R.id.tvMessage);
        tvMessage.setText(message);
    }
}
