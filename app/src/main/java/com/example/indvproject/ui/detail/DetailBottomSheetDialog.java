package com.example.indvproject.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.example.indvproject.R;
import com.example.indvproject.data.Constant;
import com.example.indvproject.data.model.Movie;
import com.example.indvproject.ui.home.HomeActivity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class DetailBottomSheetDialog extends BottomSheetDialogFragment {

    TextInputLayout tv;
    TextView tvYear;
    TextView tvDescription;
    TextView tvType;
    TextView tvCast;
    TextView tvDirector;
    ImageView ivBackground;
    TextInputLayout textInputLayoutDate;
    EditText etDate;
    ImageView closeButton;
    Button btnPayNow;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, R.style.BottomSheetDialogStyle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.bottom_sheet_detail_dialog,
                                  container, false);

        closeButton = v.findViewById(R.id.closeButton);
        btnPayNow = v.findViewById(R.id.btnPay);
        textInputLayoutDate = v.findViewById(R.id.etCardDateLayout);
        etDate = v.findViewById(R.id.etCardDate);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        etDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    textInputLayoutDate.setHint("Expiry Date");
                } else {
                    textInputLayoutDate.setHint("dd/mm");
                }
            }
        });

        btnPayNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismissAllowingStateLoss();
                Constant.PURCHASED = "PURCHASED";
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        return v;
    }
}