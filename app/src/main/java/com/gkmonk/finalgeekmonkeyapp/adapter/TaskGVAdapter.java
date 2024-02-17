package com.gkmonk.finalgeekmonkeyapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.gkmonk.finalgeekmonkeyapp.R;
import com.gkmonk.finalgeekmonkeyapp.model.TaskModel;

import java.util.ArrayList;


public class TaskGVAdapter extends ArrayAdapter<TaskModel> {

    public TaskGVAdapter(@NonNull Context context, ArrayList<TaskModel> taskModelArrayList) {
        super(context, 0, taskModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
        }

        TaskModel taskModel = getItem(position);
        TextView courseTV = listitemView.findViewById(R.id.idTVCourse);
        ImageView courseIV = listitemView.findViewById(R.id.idIVcourse);

        courseTV.setText(taskModel.getTaskName());
        courseIV.setImageResource(taskModel.getImgid());
        return listitemView;
    }
}
