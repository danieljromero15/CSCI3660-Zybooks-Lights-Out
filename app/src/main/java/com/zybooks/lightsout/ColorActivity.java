package com.zybooks.lightsout;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class ColorActivity extends AppCompatActivity {

    public static final String EXTRA_COLOR = "com.zybooks.lightsout.color";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        // Get the color ID from MainActivity
        Intent intent = getIntent();
        int colorID = intent.getIntExtra(EXTRA_COLOR, R.color.yellow);

        // select the radio button matching the color ID
        int radioID = R.id.radio_yellow;
        if (colorID == R.color.red) {
            radioID = R.id.radio_red;
        } else if (colorID == R.color.orange) {
            radioID = R.id.radio_orange;
        } else if (colorID == R.color.green) {
            radioID = R.id.radio_green;
        }

        RadioButton radio = findViewById(radioID);
        radio.setChecked(true);

    }

    public void onColorSelected(View view) {
        int colorId = R.color.yellow;
        if (view.getId() == R.id.radio_red) {
            colorId = R.color.red;
        } else if (view.getId() == R.id.radio_orange) {
            colorId = R.color.orange;
        } else if (view.getId() == R.id.radio_green) {
            colorId = R.color.green;
        }

        Intent intent = new Intent();
        intent.putExtra(EXTRA_COLOR, colorId);
        setResult(RESULT_OK, intent);
        finish();
    }
}