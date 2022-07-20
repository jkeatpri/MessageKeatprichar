package com.example.messagekeatprichar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MessageActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.messagekeatprichar.MESSAGE";
    public static final String EXTRA_RESULT = "com.example.messagekeatprichar.RESULT";

    @Override
    protected  void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);
        TextView tvMessage = findViewById(R.id.tvMessage);
        tvMessage.setText(message);

        btnSaveListenerMethod();
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
