package com.gkmonk.finalgeekmonkeyapp.ui.amazon;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gkmonk.finalgeekmonkeyapp.R;
import com.gkmonk.finalgeekmonkeyapp.databinding.FragmentAmazonBinding;
import com.gkmonk.finalgeekmonkeyapp.databinding.FragmentGalleryBinding;
import com.gkmonk.finalgeekmonkeyapp.ui.gallery.GalleryViewModel;
import com.google.android.material.navigation.NavigationView;

public class AmazonFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener{

    private FragmentAmazonBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AmazonViewModel amazonViewModel =
                new ViewModelProvider(this).get(AmazonViewModel.class);

        binding = FragmentAmazonBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGallery;
        amazonViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}