package com.b3sk.jokelibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE_KEY = "com.b3sk.jokelibrary.JOKE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        Intent intent = getIntent();
        String joke = intent.getExtras().getString(JOKE_KEY);
        TextView textView = (TextView) findViewById(R.id.joke_text);
        textView.setText(joke);
    }
}
