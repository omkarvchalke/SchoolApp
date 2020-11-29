package com.example.schoolapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.schoolapp.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;

public class HomeFragment extends Fragment {

    private SliderLayout sliderLayout;
    private ImageView map;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        sliderLayout = view.findViewById(R.id.slider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.SLIDE);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(2); //time for changing img in slider
        setSliderViews();
        //on clicking map location will be shown
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

    private void setSliderViews() {
        for(int i=0;i<5;i++)
        {
            DefaultSliderView sliderView = new DefaultSliderView(getContext());
            switch(i){
                case 0:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/college-app-97128.appspot.com/o/gallery%2F%5BB%4083435e7jpg?alt=media&token=c1e2eea6-9934-4589-bde7-3526476d105c"); //-> firebase URL join karnay Video#4
                    break;
                case 1:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/college-app-97128.appspot.com/o/gallery%2F%5BB%40d470e14jpg?alt=media&token=92d0e141-b072-404b-a2bc-369fa3d2dcb2");

                    break;
                case 2:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/college-app-97128.appspot.com/o/gallery%2F%5BB%40f629a41jpg?alt=media&token=689c5c9c-209c-49b2-927b-0892dd1332f3");

                    break;
                case 3:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/college-app-97128.appspot.com/o/gallery%2F%5BB%40ebc9aaejpg?alt=media&token=859d27fa-2a44-4cdb-885f-fbeaa62f9be6");

                    break;
                case 4:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/college-app-97128.appspot.com/o/gallery%2F%5BB%4083435e7jpg?alt=media&token=c1e2eea6-9934-4589-bde7-3526476d105c");

                    break;
            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);

            sliderLayout.addSliderView(sliderView);
        }
    }
}