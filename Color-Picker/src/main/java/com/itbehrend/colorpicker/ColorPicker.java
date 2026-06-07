package com.itbehrend.colorpicker;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * A Material Design color-palette picker shown as a dialog.
 *
 * <p>Usage:
 * <pre>{@code
 * ColorPicker picker = ColorPicker.newInstance();
 * picker.setOnColorSelectedListener((themeStyleRes, primaryColor) -> { ... });
 * picker.show(getSupportFragmentManager(), "color_picker");
 * }</pre>
 */
public class ColorPicker extends AppCompatDialogFragment {

    /** Number of swatch columns in the grid. */
    private static final int SPAN_COUNT = 10;

    /** Callback delivered when the user confirms a swatch with the Apply button. */
    public interface OnColorSelectedListener {
        /**
         * @param themeStyleRes theme style resource (e.g. {@code R.style.Blue500}) to apply
         * @param primaryColor  resolved ARGB primary color of the selected swatch
         */
        void onColorSelected(@StyleRes int themeStyleRes, @ColorInt int primaryColor);
    }

    private final List<Integer[]> colors = colors();
    private ColorPickerAdapter adapter;
    private OnColorSelectedListener listener;

    public static ColorPicker newInstance() {
        return new ColorPicker();
    }

    public void setOnColorSelectedListener(@Nullable OnColorSelectedListener listener) {
        this.listener = listener;
    }

    /** The palette as {@code {colorResId, styleResId}} pairs, in display order. */
    public List<Integer[]> getColors() {
        return colors;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(requireContext())
                .inflate(R.layout.layout_color_picker, null);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), SPAN_COUNT));
        adapter = new ColorPickerAdapter(colors);
        recyclerView.setAdapter(adapter);

        AlertDialog dialog = new MaterialAlertDialogBuilder(requireContext())
                .setTitle(R.string.color_picker_title)
                .setView(view)
                .setNegativeButton(R.string.color_picker_cancel, (d, which) -> d.dismiss())
                // Positive listener is wired in setOnShowListener so an empty selection
                // does not auto-dismiss the dialog.
                .setPositiveButton(R.string.color_picker_apply, null)
                .create();

        dialog.setOnShowListener(d -> {
            Button negative = dialog.getButton(DialogInterface.BUTTON_NEGATIVE);
            Button positive = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
            negative.setTextColor(Color.BLACK);
            positive.setTextColor(Color.BLACK);
            positive.setOnClickListener(v -> applySelection(dialog));
        });
        return dialog;
    }

    private void applySelection(@NonNull Dialog dialog) {
        int position = adapter.getSelectedPosition();
        if (position == RecyclerView.NO_POSITION) {
            Toast.makeText(requireContext(), R.string.color_picker_none_selected,
                    Toast.LENGTH_SHORT).show();
            return;
        }
        if (listener != null) {
            @StyleRes int themeStyleRes = colors.get(position)[1];
            @ColorInt int primaryColor =
                    ContextCompat.getColor(requireContext(), colors.get(position)[0]);
            listener.onColorSelected(themeStyleRes, primaryColor);
        }
        dialog.dismiss();
    }

    private ArrayList<Integer[]> colors() {
        ArrayList<Integer[]> colors = new ArrayList<>();
        colors.add(new Integer[] {R.color.Red50primaryColor, R.style.Red50});
        colors.add(new Integer[] {R.color.Red100primaryColor, R.style.Red100});
        colors.add(new Integer[] {R.color.Red200primaryColor, R.style.Red200});
        colors.add(new Integer[] {R.color.Red300primaryColor, R.style.Red300});
        colors.add(new Integer[] {R.color.Red400primaryColor, R.style.Red400});
        colors.add(new Integer[] {R.color.Red500primaryColor, R.style.Red500});
        colors.add(new Integer[] {R.color.Red600primaryColor, R.style.Red600});
        colors.add(new Integer[] {R.color.Red700primaryColor, R.style.Red700});
        colors.add(new Integer[] {R.color.Red800primaryColor, R.style.Red800});
        colors.add(new Integer[] {R.color.Red900primaryColor, R.style.Red900});
        colors.add(new Integer[] {R.color.Pink50primaryColor, R.style.Pink50});
        colors.add(new Integer[] {R.color.Pink100primaryColor, R.style.Pink100});
        colors.add(new Integer[] {R.color.Pink200primaryColor, R.style.Pink200});
        colors.add(new Integer[] {R.color.Pink300primaryColor, R.style.Pink300});
        colors.add(new Integer[] {R.color.Pink400primaryColor, R.style.Pink400});
        colors.add(new Integer[] {R.color.Pink500primaryColor, R.style.Pink500});
        colors.add(new Integer[] {R.color.Pink600primaryColor, R.style.Pink600});
        colors.add(new Integer[] {R.color.Pink700primaryColor, R.style.Pink700});
        colors.add(new Integer[] {R.color.Pink800primaryColor, R.style.Pink800});
        colors.add(new Integer[] {R.color.Pink900primaryColor, R.style.Pink900});
        colors.add(new Integer[] {R.color.Purple50primaryColor, R.style.Purple50});
        colors.add(new Integer[] {R.color.Purple100primaryColor, R.style.Purple100});
        colors.add(new Integer[] {R.color.Purple200primaryColor, R.style.Purple200});
        colors.add(new Integer[] {R.color.Purple300primaryColor, R.style.Purple300});
        colors.add(new Integer[] {R.color.Purple400primaryColor, R.style.Purple400});
        colors.add(new Integer[] {R.color.Purple500primaryColor, R.style.Purple500});
        colors.add(new Integer[] {R.color.Purple600primaryColor, R.style.Purple600});
        colors.add(new Integer[] {R.color.Purple700primaryColor, R.style.Purple700});
        colors.add(new Integer[] {R.color.Purple800primaryColor, R.style.Purple800});
        colors.add(new Integer[] {R.color.Purple900primaryColor, R.style.Purple900});
        colors.add(new Integer[] {R.color.Indigo50primaryColor, R.style.Indigo50});
        colors.add(new Integer[] {R.color.Indigo100primaryColor, R.style.Indigo100});
        colors.add(new Integer[] {R.color.Indigo200primaryColor, R.style.Indigo200});
        colors.add(new Integer[] {R.color.Indigo300primaryColor, R.style.Indigo300});
        colors.add(new Integer[] {R.color.Indigo400primaryColor, R.style.Indigo400});
        colors.add(new Integer[] {R.color.Indigo500primaryColor, R.style.Indigo500});
        colors.add(new Integer[] {R.color.Indigo600primaryColor, R.style.Indigo600});
        colors.add(new Integer[] {R.color.Indigo700primaryColor, R.style.Indigo700});
        colors.add(new Integer[] {R.color.Indigo800primaryColor, R.style.Indigo800});
        colors.add(new Integer[] {R.color.Indigo900primaryColor, R.style.Indigo900});
        colors.add(new Integer[] {R.color.Blue50primaryColor, R.style.Blue50});
        colors.add(new Integer[] {R.color.Blue100primaryColor, R.style.Blue100});
        colors.add(new Integer[] {R.color.Blue200primaryColor, R.style.Blue200});
        colors.add(new Integer[] {R.color.Blue300primaryColor, R.style.Blue300});
        colors.add(new Integer[] {R.color.Blue400primaryColor, R.style.Blue400});
        colors.add(new Integer[] {R.color.Blue500primaryColor, R.style.Blue500});
        colors.add(new Integer[] {R.color.Blue600primaryColor, R.style.Blue600});
        colors.add(new Integer[] {R.color.Blue700primaryColor, R.style.Blue700});
        colors.add(new Integer[] {R.color.Blue800primaryColor, R.style.Blue800});
        colors.add(new Integer[] {R.color.Blue900primaryColor, R.style.Blue900});
        colors.add(new Integer[] {R.color.Cyan50primaryColor, R.style.Cyan50});
        colors.add(new Integer[] {R.color.Cyan100primaryColor, R.style.Cyan100});
        colors.add(new Integer[] {R.color.Cyan200primaryColor, R.style.Cyan200});
        colors.add(new Integer[] {R.color.Cyan300primaryColor, R.style.Cyan300});
        colors.add(new Integer[] {R.color.Cyan400primaryColor, R.style.Cyan400});
        colors.add(new Integer[] {R.color.Cyan500primaryColor, R.style.Cyan500});
        colors.add(new Integer[] {R.color.Cyan600primaryColor, R.style.Cyan600});
        colors.add(new Integer[] {R.color.Cyan700primaryColor, R.style.Cyan700});
        colors.add(new Integer[] {R.color.Cyan800primaryColor, R.style.Cyan800});
        colors.add(new Integer[] {R.color.Cyan900primaryColor, R.style.Cyan900});
        colors.add(new Integer[] {R.color.Teal50primaryColor, R.style.Teal50});
        colors.add(new Integer[] {R.color.Teal100primaryColor, R.style.Teal100});
        colors.add(new Integer[] {R.color.Teal200primaryColor, R.style.Teal200});
        colors.add(new Integer[] {R.color.Teal300primaryColor, R.style.Teal300});
        colors.add(new Integer[] {R.color.Teal400primaryColor, R.style.Teal400});
        colors.add(new Integer[] {R.color.Teal500primaryColor, R.style.Teal500});
        colors.add(new Integer[] {R.color.Teal600primaryColor, R.style.Teal600});
        colors.add(new Integer[] {R.color.Teal700primaryColor, R.style.Teal700});
        colors.add(new Integer[] {R.color.Teal800primaryColor, R.style.Teal800});
        colors.add(new Integer[] {R.color.Teal900primaryColor, R.style.Teal900});
        colors.add(new Integer[] {R.color.Green50primaryColor, R.style.Green50});
        colors.add(new Integer[] {R.color.Green100primaryColor, R.style.Green100});
        colors.add(new Integer[] {R.color.Green200primaryColor, R.style.Green200});
        colors.add(new Integer[] {R.color.Green300primaryColor, R.style.Green300});
        colors.add(new Integer[] {R.color.Green400primaryColor, R.style.Green400});
        colors.add(new Integer[] {R.color.Green500primaryColor, R.style.Green500});
        colors.add(new Integer[] {R.color.Green600primaryColor, R.style.Green600});
        colors.add(new Integer[] {R.color.Green700primaryColor, R.style.Green700});
        colors.add(new Integer[] {R.color.Green800primaryColor, R.style.Green800});
        colors.add(new Integer[] {R.color.Green900primaryColor, R.style.Green900});
        colors.add(new Integer[] {R.color.Lime50primaryColor, R.style.Lime50});
        colors.add(new Integer[] {R.color.Lime100primaryColor, R.style.Lime100});
        colors.add(new Integer[] {R.color.Lime200primaryColor, R.style.Lime200});
        colors.add(new Integer[] {R.color.Lime300primaryColor, R.style.Lime300});
        colors.add(new Integer[] {R.color.Lime400primaryColor, R.style.Lime400});
        colors.add(new Integer[] {R.color.Lime500primaryColor, R.style.Lime500});
        colors.add(new Integer[] {R.color.Lime600primaryColor, R.style.Lime600});
        colors.add(new Integer[] {R.color.Lime700primaryColor, R.style.Lime700});
        colors.add(new Integer[] {R.color.Lime800primaryColor, R.style.Lime800});
        colors.add(new Integer[] {R.color.Lime900primaryColor, R.style.Lime900});
        colors.add(new Integer[] {R.color.Yellow50primaryColor, R.style.Yellow50});
        colors.add(new Integer[] {R.color.Yellow100primaryColor, R.style.Yellow100});
        colors.add(new Integer[] {R.color.Yellow200primaryColor, R.style.Yellow200});
        colors.add(new Integer[] {R.color.Yellow300primaryColor, R.style.Yellow300});
        colors.add(new Integer[] {R.color.Yellow400primaryColor, R.style.Yellow400});
        colors.add(new Integer[] {R.color.Yellow500primaryColor, R.style.Yellow500});
        colors.add(new Integer[] {R.color.Yellow600primaryColor, R.style.Yellow600});
        colors.add(new Integer[] {R.color.Yellow700primaryColor, R.style.Yellow700});
        colors.add(new Integer[] {R.color.Yellow800primaryColor, R.style.Yellow800});
        colors.add(new Integer[] {R.color.Yellow900primaryColor, R.style.Yellow900});
        colors.add(new Integer[] {R.color.Amber50primaryColor, R.style.Amber50});
        colors.add(new Integer[] {R.color.Amber100primaryColor, R.style.Amber100});
        colors.add(new Integer[] {R.color.Amber200primaryColor, R.style.Amber200});
        colors.add(new Integer[] {R.color.Amber300primaryColor, R.style.Amber300});
        colors.add(new Integer[] {R.color.Amber400primaryColor, R.style.Amber400});
        colors.add(new Integer[] {R.color.Amber500primaryColor, R.style.Amber500});
        colors.add(new Integer[] {R.color.Amber600primaryColor, R.style.Amber600});
        colors.add(new Integer[] {R.color.Amber700primaryColor, R.style.Amber700});
        colors.add(new Integer[] {R.color.Amber800primaryColor, R.style.Amber800});
        colors.add(new Integer[] {R.color.Amber900primaryColor, R.style.Amber900});
        colors.add(new Integer[] {R.color.Orange50primaryColor, R.style.Orange50});
        colors.add(new Integer[] {R.color.Orange100primaryColor, R.style.Orange100});
        colors.add(new Integer[] {R.color.Orange200primaryColor, R.style.Orange200});
        colors.add(new Integer[] {R.color.Orange300primaryColor, R.style.Orange300});
        colors.add(new Integer[] {R.color.Orange400primaryColor, R.style.Orange400});
        colors.add(new Integer[] {R.color.Orange500primaryColor, R.style.Orange500});
        colors.add(new Integer[] {R.color.Orange600primaryColor, R.style.Orange600});
        colors.add(new Integer[] {R.color.Orange700primaryColor, R.style.Orange700});
        colors.add(new Integer[] {R.color.Orange800primaryColor, R.style.Orange800});
        colors.add(new Integer[] {R.color.Orange900primaryColor, R.style.Orange900});
        colors.add(new Integer[] {R.color.Brown50primaryColor, R.style.Brown50});
        colors.add(new Integer[] {R.color.Brown100primaryColor, R.style.Brown100});
        colors.add(new Integer[] {R.color.Brown200primaryColor, R.style.Brown200});
        colors.add(new Integer[] {R.color.Brown300primaryColor, R.style.Brown300});
        colors.add(new Integer[] {R.color.Brown400primaryColor, R.style.Brown400});
        colors.add(new Integer[] {R.color.Brown500primaryColor, R.style.Brown500});
        colors.add(new Integer[] {R.color.Brown600primaryColor, R.style.Brown600});
        colors.add(new Integer[] {R.color.Brown700primaryColor, R.style.Brown700});
        colors.add(new Integer[] {R.color.Brown800primaryColor, R.style.Brown800});
        colors.add(new Integer[] {R.color.Brown900primaryColor, R.style.Brown900});
        colors.add(new Integer[] {R.color.Grey50primaryColor, R.style.Grey50});
        colors.add(new Integer[] {R.color.Grey100primaryColor, R.style.Grey100});
        colors.add(new Integer[] {R.color.Grey200primaryColor, R.style.Grey200});
        colors.add(new Integer[] {R.color.Grey300primaryColor, R.style.Grey300});
        colors.add(new Integer[] {R.color.Grey400primaryColor, R.style.Grey400});
        colors.add(new Integer[] {R.color.Grey500primaryColor, R.style.Grey500});
        colors.add(new Integer[] {R.color.Grey600primaryColor, R.style.Grey600});
        colors.add(new Integer[] {R.color.Grey700primaryColor, R.style.Grey700});
        colors.add(new Integer[] {R.color.Grey800primaryColor, R.style.Grey800});
        colors.add(new Integer[] {R.color.Grey900primaryColor, R.style.Grey900});
        colors.add(new Integer[] {R.color.BlueGrey50primaryColor, R.style.BlueGrey50});
        colors.add(new Integer[] {R.color.BlueGrey100primaryColor, R.style.BlueGrey100});
        colors.add(new Integer[] {R.color.BlueGrey200primaryColor, R.style.BlueGrey200});
        colors.add(new Integer[] {R.color.BlueGrey300primaryColor, R.style.BlueGrey300});
        colors.add(new Integer[] {R.color.BlueGrey400primaryColor, R.style.BlueGrey400});
        colors.add(new Integer[] {R.color.BlueGrey500primaryColor, R.style.BlueGrey500});
        colors.add(new Integer[] {R.color.BlueGrey600primaryColor, R.style.BlueGrey600});
        colors.add(new Integer[] {R.color.BlueGrey700primaryColor, R.style.BlueGrey700});
        colors.add(new Integer[] {R.color.BlueGrey800primaryColor, R.style.BlueGrey800});
        colors.add(new Integer[] {R.color.BlueGrey900primaryColor, R.style.BlueGrey900});
        return colors;
    }
}
