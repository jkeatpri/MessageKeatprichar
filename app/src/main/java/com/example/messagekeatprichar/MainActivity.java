package com.example.messagekeatprichar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSendListenerMethod();
    }

    private void btnSendListenerMethod() {
        Intent intent = new Intent(this, MessageActivity.class);
        Button btnSend = findViewById((R.id.btnSend));
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etMessage = findViewById(R.id.etMessage);
                String message = etMessage.getText().toString();
                intent.putExtra(MessageActivity.EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });
    }
}