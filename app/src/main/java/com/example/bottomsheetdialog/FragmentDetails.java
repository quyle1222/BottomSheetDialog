package com.example.bottomsheetdialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class FragmentDetails extends Fragment {
    ImageView imageDetails;
    ImageView btnBack;
    RelativeLayout layoutFragmentDetails;
    RelativeLayout imageContainer;
    private FragmentDetailsAdapter adapter;
    boolean imageDisplaying = false;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private LinearLayout layout;

    public FragmentDetails() {
    }

    public static FragmentDetails newInstance(String param1, String param2) {
        FragmentDetails fragment = new FragmentDetails();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_details, container, false);
        setupOnboadrdingItems();

        btnBack = view.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentDetails, new FragmentFirst());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                layoutFragmentDetails = view.findViewById(R.id.layoutFragmentDetails);
                layoutFragmentDetails.setVisibility(view.GONE);

            }
        });

        ViewPager2 viewPagerDetails = view.findViewById(R.id.viewPagerDetails);
        viewPagerDetails.setAdapter(adapter);

        return view;
    }

    private void setupOnboadrdingItems() {
        List<FragmentDetailsItem> FragmentDetailsItems = new ArrayList<>();

        FragmentDetailsItem item1 = new FragmentDetailsItem();
        item1.setNumber("1/3");
        item1.setImage(R.drawable.food);

        FragmentDetailsItem item2 = new FragmentDetailsItem();
        item2.setNumber("2/3");
        item2.setImage(R.drawable.food2);

        FragmentDetailsItem item3 = new FragmentDetailsItem();
        item3.setNumber("3/3");
        item3.setImage(R.drawable.food3);

        FragmentDetailsItems.add(item1);
        FragmentDetailsItems.add(item2);
        FragmentDetailsItems.add(item3);

        adapter = new FragmentDetailsAdapter(FragmentDetailsItems);
    }
}