package com.example.schoolapp.ui.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.schoolapp.R;

import java.util.ArrayList;
import java.util.List;


public class AboutFragment extends Fragment {
    private ViewPager viewPager;
    private BranchAdapter branchAdapter;
    private List<BranchModel> list;
    private ImageView map;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new BranchModel(R.drawable.ic_preprimary, "Pre-Primary", "Preprimary Section was started in year 2015. To join pre-primary dept. student's age must be above 3.5 years. In this Dept we have 15 Teachers and dept. capacity is 60 Studnets per batch."));
        list.add(new BranchModel(R.drawable.ic_primary, "Primary", "Primary Section was started in year 2015. To join primary dept. student's age must be above 5 years. In this Dept we have 25 Faculty members and dept. capacity is 160 Studnets per batch."));
        list.add(new BranchModel(R.drawable.ic_secondary, "Secondary", "Secondary Section was started in year 2016. To join Secondary dept. student's age must be above 13 years. In this Dept we have 25 Faculty members and dept. capacity is 150 Studnets per batch."));
        list.add(new BranchModel(R.drawable.ic_highersecondary, "Higher Secondary", "Higher Secondary Section was started in year 2018. To join Higher-Secondary dept. student's age must be above 15 years. In this Dept we have 15 Faculty members and dept. capacity is 90 Studnets per batch."));

        branchAdapter = new BranchAdapter(getContext(),list);

        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(branchAdapter);

//        ImageView imageView = view.findViewById(R.id.schoolimage);
//        Glide.with(getContext())
//                .load("url") //here add URL of school image from Firebase
//                .into(imageView);
        map=view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });

        return view;
    }

    private void openMap() {
        Uri uri= Uri.parse("geo:0, 0?q=D Y Patil International School Nerul");
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}