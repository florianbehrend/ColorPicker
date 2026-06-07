package com.itbehrend.colorpicker;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Renders the color swatches and tracks a single, instance-scoped selection.
 *
 * <p>Selection is stored as a position (not a {@link View} reference), so it survives
 * view recycling and never leaks across adapter instances.
 */
class ColorPickerAdapter extends RecyclerView.Adapter<ColorPickerAdapter.ColorViewHolder> {

    private final List<Integer[]> colors;
    private int selectedPosition = RecyclerView.NO_POSITION;

    ColorPickerAdapter(List<Integer[]> colors) {
        this.colors = colors;
    }

    int getSelectedPosition() {
        return selectedPosition;
    }

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.color_item, parent, false);
        return new ColorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder holder, int position) {
        int color = ContextCompat.getColor(holder.color.getContext(), colors.get(position)[0]);
        // Tint the rounded swatch_shape background with the swatch color.
        holder.color.setBackgroundTintList(ColorStateList.valueOf(color));
        holder.color.setSelected(position == selectedPosition);
    }

    @Override
    public int getItemCount() {
        return colors.size();
    }

    /** Selects {@code position}, or clears the selection when the selected swatch is tapped again. */
    private void select(int position) {
        if (position == RecyclerView.NO_POSITION) {
            return;
        }
        int previous = selectedPosition;
        selectedPosition = (position == selectedPosition) ? RecyclerView.NO_POSITION : position;

        if (previous != RecyclerView.NO_POSITION) {
            notifyItemChanged(previous);
        }
        if (selectedPosition != RecyclerView.NO_POSITION) {
            notifyItemChanged(selectedPosition);
        }
    }

    class ColorViewHolder extends RecyclerView.ViewHolder {

        final ImageView color;

        ColorViewHolder(@NonNull View itemView) {
            super(itemView);
            color = itemView.findViewById(R.id.colorItem);
            color.setOnClickListener(v -> select(getBindingAdapterPosition()));
        }
    }
}
