package com.example.bottomsheetdialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {
    ImageView filter;
    RelativeLayout layoutFood;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title.
        getSupportActionBar().hide(); //hide the title bar.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filter = findViewById(R.id.filterIcon);
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this, R.style.BottomSheetDialogTheme);
                View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.layout_bottom_sheet, findViewById(R.id.bottomSheetContainer));
                bottomSheetDialog.setContentView(view);
                bottomSheetDialog.show();
            }
        });
        layoutFood = findViewById(R.id.layoutFood);
        layoutFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().add(R.id.mainActivityContainer, new FragmentDetails()).commit();
                linearLayout = findViewById(R.id.layoutActivity);
                linearLayout.setVisibility(View.GONE);
            }
        });
    }
}