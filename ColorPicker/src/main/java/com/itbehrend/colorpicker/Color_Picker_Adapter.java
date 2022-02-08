package com.itbehrend.colorpicker;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itbehrend.colorpicker.R;

import java.util.ArrayList;

public class Color_Picker_Adapter extends RecyclerView.Adapter<Color_Picker_Adapter.ColorViewHolder>{

    private final ArrayList<Integer[]> colors;
    private OnItemClickListener mListener;
    private static ImageView lastSelected;

    public Color_Picker_Adapter(ArrayList<Integer[]> colors) {
        this.colors = colors;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener = listener;
    }

    @NonNull
    @Override
    public Color_Picker_Adapter.ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.color_item, parent, false);
        return new ColorViewHolder(view, mListener);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull Color_Picker_Adapter.ColorViewHolder holder, int position) {
        int current_color = colors.get(position)[0];
        holder.color.setBackgroundResource(current_color);
    }

    @Override
    public int getItemCount() {
        return colors.size();
    }

    public static class ColorViewHolder extends RecyclerView.ViewHolder{

        public final ImageView color;

        public ColorViewHolder(@NonNull View itemView, final OnItemClickListener clickListener) {
            super(itemView);
            color = itemView.findViewById(R.id.colorItem);
            color.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (clickListener != null){
                        if (color.isSelected()){
                            color.setSelected(false);
                        }else {
                            if (lastSelected != null){
                                lastSelected.setSelected(false);
                            }
                            color.setSelected(true);
                            lastSelected = color;
                        }

                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            clickListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
