package com.itbehrend.colorpicker;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.ColorInt;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
        implements ColorPicker.OnColorSelectedListener {

    private static final String PICKER_TAG = "color_picker";
    private static final String KEY_THEME = "theme_style_res";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Apply the previously chosen palette theme to the whole activity (action
        // bar, status bar, widgets) before any view is inflated. The library styles
        // are ThemeOverlays, so they layer on top of the app's base theme.
        int themeStyleRes = prefs().getInt(KEY_THEME, 0);
        if (themeStyleRes != 0) {
            getTheme().applyStyle(themeStyleRes, true);
        }

        setContentView(R.layout.activity_main);

        findViewById(R.id.choose_theme).setOnClickListener(v -> {
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
        // Persist the choice and rebuild the activity so the new theme applies globally.
        prefs().edit().putInt(KEY_THEME, themeStyleRes).apply();

        // Dismiss the picker first, otherwise recreate() would restore and reopen it.
        ColorPicker picker =
                (ColorPicker) getSupportFragmentManager().findFragmentByTag(PICKER_TAG);
        if (picker != null) {
            picker.dismiss();
        }
        recreate();
    }

    private SharedPreferences prefs() {
        return getPreferences(MODE_PRIVATE);
    }
}
