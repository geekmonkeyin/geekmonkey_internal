package com.gkmonk.finalgeekmonkeyapp.ui.inventory;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gkmonk.finalgeekmonkeyapp.R;
import com.gkmonk.finalgeekmonkeyapp.databinding.FragmentAmazonBinding;
import com.gkmonk.finalgeekmonkeyapp.databinding.FragmentInventoryBinding;
import com.gkmonk.finalgeekmonkeyapp.ui.amazon.AmazonViewModel;

public class InventoryFragment extends Fragment {

    private FragmentInventoryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        InventoryViewModel inventoryViewModel =
                new ViewModelProvider(this).get(InventoryViewModel.class);

        binding = FragmentInventoryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}