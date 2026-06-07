package com.itbehrend.colorpicker;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.ColorInt;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
        implements ColorPicker.OnColorSelectedListener {

    private static final String PICKER_TAG = "color_picker";

    private Button chooseTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chooseTheme = findViewById(R.id.choose_theme);
        chooseTheme.setOnClickListener(v -> {
            ColorPicker picker = ColorPicker.newInstance();
            picker.setOnColorSelectedListener(this);
            picker.show(getSupportFragmentManager(), PICKER_TAG);
        });

        // Re-attach the listener to a dialog that survived a configuration change.
        ColorPicker existing =
                (ColorPicker) getSupportFragmentManager().findFragmentByTag(PICKER_TAG);
        if (existing != null) {
            existing.setOnColorSelectedListener(this);
        }
    }

    @Override
    public void onColorSelected(@StyleRes int themeStyleRes, @ColorInt int primaryColor) {
        chooseTheme.setBackgroundColor(primaryColor);
    }
}
