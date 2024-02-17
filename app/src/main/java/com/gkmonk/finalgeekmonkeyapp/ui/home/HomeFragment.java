package com.gkmonk.finalgeekmonkeyapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.gkmonk.finalgeekmonkeyapp.R;
import com.gkmonk.finalgeekmonkeyapp.adapter.TaskGVAdapter;
import com.gkmonk.finalgeekmonkeyapp.databinding.FragmentHomeBinding;
import com.gkmonk.finalgeekmonkeyapp.model.Modules;
import com.gkmonk.finalgeekmonkeyapp.model.TaskModel;
import com.gkmonk.finalgeekmonkeyapp.ui.inventory.InventoryFragment;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeFragment fragment;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        this.fragment = this;
        final GridView gridView = binding.idGVcourses;
        ArrayList<TaskModel> taskModelArrayList = new ArrayList<TaskModel>();
        taskModelArrayList.add(new TaskModel("Amazon Store", R.drawable.amazon_icons, Modules.AMAZON));
        taskModelArrayList.add(new TaskModel("Shopify Store", R.drawable.shopify_icons,Modules.SHOPIFY));
        taskModelArrayList.add(new TaskModel("Inventory Mgt", R.drawable.inventory,Modules.INVENTORY));
        taskModelArrayList.add(new TaskModel("Upload Images", R.drawable.upload_images,Modules.UPLOAD_IMAGES));
        taskModelArrayList.add(new TaskModel("Attendance Mgt", R.drawable.attendance,Modules.ATTENDANCE));
        taskModelArrayList.add(new TaskModel("Daily Tasks Mgt", R.drawable.tasks, Modules.TASKS));

        TaskGVAdapter adapter = new TaskGVAdapter(this.getContext(), taskModelArrayList);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TaskModel model = (TaskModel) parent.getAdapter().getItem(position);
                Snackbar.make(view, "Item Clicked:"+model.getTaskName(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Navigation.findNavController(view).popBackStack();
                Navigation.findNavController(view).enableOnBackPressed(true);
                if(position == 0) {
                    Navigation.findNavController(view).navigate(R.id.nav_amazon);
                }else if(position == 1){
                    Navigation.findNavController(view).navigate(R.id.nav_shopify);

                }else if(position == 2){
                    Navigation.findNavController(view).navigate(R.id.nav_inventory);
                }
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}