package com.example.hw8;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private Button exitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String text = getIntent().getStringExtra("key1");
        if (findViewById(R.id.TextCurrent) instanceof TextView){
            ((TextView) findViewById(R.id.TextCurrent)).setText(text);
        }
    }

    public void OnClickButton(View view) {
        switch (exitButton.getId()) {
            case R.id.ExitButton:
                onDestroy();
                finish();
                break;
        }
    }
}