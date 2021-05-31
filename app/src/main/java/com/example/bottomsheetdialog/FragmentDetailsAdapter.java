package com.example.bottomsheetdialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FragmentDetailsAdapter extends RecyclerView.Adapter<FragmentDetailsAdapter.onBoardingViewHolder> {
    private TextView textView;
    private ImageView imageView;
    private List<FragmentDetailsItem> onBoardingItems;

    public FragmentDetailsAdapter(List<FragmentDetailsItem> FragmentDetailsItems) {
        this.onBoardingItems = FragmentDetailsItems;
    }

    @NonNull
    @Override
    public onBoardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new onBoardingViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_details_image, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull onBoardingViewHolder holder, int position) {
        holder.setOnBoardingData(onBoardingItems.get(position));
    }

    @Override
    public int getItemCount() {
        return onBoardingItems.size();
    }

    class onBoardingViewHolder extends RecyclerView.ViewHolder {

        public onBoardingViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txtNumberImage);
            imageView = itemView.findViewById(R.id.imageViewPage);
        }

        void setOnBoardingData(FragmentDetailsItem onBoarDingItem) {
            textView.setText(onBoarDingItem.getNumber());
            imageView.setImageResource(onBoarDingItem.getImage());
        }
    }
}
