package com.example.hostelmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class TitleModelAdapter extends ArrayAdapter<TitleModel> {
    public TitleModelAdapter(@NonNull Context context, ArrayList<TitleModel> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
        }

        TitleModel TitleModel = getItem(position);
        TextView Title = listitemView.findViewById(R.id.imvTitle);
        ImageView titleIMG = listitemView.findViewById(R.id.tvTitle);

        Title.setText(TitleModel.getTitle_name());
        titleIMG.setImageResource(TitleModel.getImgid());
        return listitemView;
    }
}

