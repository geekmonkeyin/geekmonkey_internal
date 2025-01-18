package com.gkmonk.finalgeekmonkeyapp.ui.inventory;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gkmonk.finalgeekmonkeyapp.R;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScanBarcodeFragment} factory method to
 * create an instance of this fragment.
 */
public class ScanBarcodeFragment extends Fragment {

    private DecoratedBarcodeView barcodeView;
    private TextView barcodeResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_scan_barcode, container, false);
        barcodeView = root.findViewById(R.id.camera_preview);
        barcodeResult = root.findViewById(R.id.barcode_result);

        barcodeView.decodeContinuous(new BarcodeCallback() {
            @Override
            public void barcodeResult(BarcodeResult result) {
                fetchBarcodeData(result.getText());
            }
        });

        return root;
    }

    private void fetchBarcodeData(String barcode) {
        OkHttpClient client = new OkHttpClient();
        String url = "https://api.example.com/barcode/" + barcode;

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                getActivity().runOnUiThread(() -> barcodeResult.setText("Failed to fetch data"));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String responseData = response.body().string();
                    getActivity().runOnUiThread(() -> barcodeResult.setText(responseData));
                } else {
                    getActivity().runOnUiThread(() -> barcodeResult.setText("Error: " + response.message()));
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        barcodeView.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        barcodeView.pause();
    }
}