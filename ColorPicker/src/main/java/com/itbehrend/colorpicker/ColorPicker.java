package com.itbehrend.colorpicker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.itbehrend.colorpicker.R;

import java.util.ArrayList;

public class ColorPicker extends AppCompatDialogFragment{
    private int position;
    private final ArrayList<Integer[]> colors;
    private Choose_Color_Listener choose_color_listener;

    public ColorPicker(){
        colors = colors();
    }



    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_color_picker, null);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 10);
        Color_Picker_Adapter adapter = new Color_Picker_Adapter(colors);
        adapter.setOnItemClickListener(new Color_Picker_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position_temp){
                position = position_temp;
//                System.out.println(position_temp);
            }
        });

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        builder.setView(view).setTitle("Confirm").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).setPositiveButton("Apply", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                choose_color_listener.apply(colors.get(position)[1]);
            }
        });

        AlertDialog colorPicker = builder.create();
        colorPicker.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                Button negativeButton = ((AlertDialog)dialog).getButton(DialogInterface.BUTTON_NEGATIVE);
                Button positiveButton = ((AlertDialog)dialog).getButton(DialogInterface.BUTTON_POSITIVE);

                negativeButton.setTextColor(Color.BLACK);
                positiveButton.setTextColor(Color.BLACK);
            }
        });
        return colorPicker;
    }

    public interface Choose_Color_Listener{
        void apply(int color);
    }

    public ArrayList<Integer[]> getColors() {
        return colors;
    }

    public void setChoose_color_listener(Choose_Color_Listener choose_color_listener) {
        this.choose_color_listener = choose_color_listener;
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
        colors.add(new Integer[] {R.color.DeepPurple50primaryColor, R.style.DeepPurple50});
        colors.add(new Integer[] {R.color.DeepPurple100primaryColor, R.style.DeepPurple100});
        colors.add(new Integer[] {R.color.DeepPurple200primaryColor, R.style.DeepPurple200});
        colors.add(new Integer[] {R.color.DeepPurple300primaryColor, R.style.DeepPurple300});
        colors.add(new Integer[] {R.color.DeepPurple400primaryColor, R.style.DeepPurple400});
        colors.add(new Integer[] {R.color.DeepPurple500primaryColor, R.style.DeepPurple500});
        colors.add(new Integer[] {R.color.DeepPurple600primaryColor, R.style.DeepPurple600});
        colors.add(new Integer[] {R.color.DeepPurple700primaryColor, R.style.DeepPurple700});
        colors.add(new Integer[] {R.color.DeepPurple800primaryColor, R.style.DeepPurple800});
        colors.add(new Integer[] {R.color.DeepPurple900primaryColor, R.style.DeepPurple900});
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
        colors.add(new Integer[] {R.color.LightBlue50primaryColor, R.style.LightBlue50});
        colors.add(new Integer[] {R.color.LightBlue100primaryColor, R.style.LightBlue100});
        colors.add(new Integer[] {R.color.LightBlue200primaryColor, R.style.LightBlue200});
        colors.add(new Integer[] {R.color.LightBlue300primaryColor, R.style.LightBlue300});
        colors.add(new Integer[] {R.color.LightBlue400primaryColor, R.style.LightBlue400});
        colors.add(new Integer[] {R.color.LightBlue500primaryColor, R.style.LightBlue500});
        colors.add(new Integer[] {R.color.LightBlue600primaryColor, R.style.LightBlue600});
        colors.add(new Integer[] {R.color.LightBlue700primaryColor, R.style.LightBlue700});
        colors.add(new Integer[] {R.color.LightBlue800primaryColor, R.style.LightBlue800});
        colors.add(new Integer[] {R.color.LightBlue900primaryColor, R.style.LightBlue900});
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
        colors.add(new Integer[] {R.color.LightGreen50primaryColor, R.style.LightGreen50});
        colors.add(new Integer[] {R.color.LightGreen100primaryColor, R.style.LightGreen100});
        colors.add(new Integer[] {R.color.LightGreen200primaryColor, R.style.LightGreen200});
        colors.add(new Integer[] {R.color.LightGreen300primaryColor, R.style.LightGreen300});
        colors.add(new Integer[] {R.color.LightGreen400primaryColor, R.style.LightGreen400});
        colors.add(new Integer[] {R.color.LightGreen500primaryColor, R.style.LightGreen500});
        colors.add(new Integer[] {R.color.LightGreen600primaryColor, R.style.LightGreen600});
        colors.add(new Integer[] {R.color.LightGreen700primaryColor, R.style.LightGreen700});
        colors.add(new Integer[] {R.color.LightGreen800primaryColor, R.style.LightGreen800});
        colors.add(new Integer[] {R.color.LightGreen900primaryColor, R.style.LightGreen900});
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
        colors.add(new Integer[] {R.color.DeepOrange50primaryColor, R.style.DeepOrange50});
        colors.add(new Integer[] {R.color.DeepOrange100primaryColor, R.style.DeepOrange100});
        colors.add(new Integer[] {R.color.DeepOrange200primaryColor, R.style.DeepOrange200});
        colors.add(new Integer[] {R.color.DeepOrange300primaryColor, R.style.DeepOrange300});
        colors.add(new Integer[] {R.color.DeepOrange400primaryColor, R.style.DeepOrange400});
        colors.add(new Integer[] {R.color.DeepOrange500primaryColor, R.style.DeepOrange500});
        colors.add(new Integer[] {R.color.DeepOrange600primaryColor, R.style.DeepOrange600});
        colors.add(new Integer[] {R.color.DeepOrange700primaryColor, R.style.DeepOrange700});
        colors.add(new Integer[] {R.color.DeepOrange800primaryColor, R.style.DeepOrange800});
        colors.add(new Integer[] {R.color.DeepOrange900primaryColor, R.style.DeepOrange900});
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
