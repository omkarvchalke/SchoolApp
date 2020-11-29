package com.example.schoolapp.videolecs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.schoolapp.DatabaseHelper;
import com.example.schoolapp.R;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.firebase.database.DatabaseReference;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;

import java.util.ArrayList;
import java.util.List;

public class videoLecActivity extends AppCompatActivity {

    private RecyclerView videoLecRecycler;
    private List<String> list;
//    private List<String>list;
    private VideoLecAdapter adapter;
    private DatabaseReference reference;
    DatabaseHelper db;
    RecyclerView.LayoutManager layoutManager;


    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_lec);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Video Lecs");

//        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
//        getLifecycle().addObserver(youTubePlayerView);
//
//        youTubePlayerView.getVideo(new AbstractYouTubePlayerListener() {
//            @Override
//            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
//                String videoId = list.getKeyword();
//
//                youTubePlayer.loadVideo(videoId, 0);
//            }
//        });


//        PreCreateDB.copyDB(this);

//        videoLecRecycler=findViewById(R.id.lvVideo);
//        reference= FirebaseDatabase.getInstance().getReference().child("pdf");
        db= new DatabaseHelper(videoLecActivity.this);
        list= new ArrayList<String>();

//        getData();

    }


    void getData(){
        Cursor cursor = db.readData();
        if(cursor.getCount()==0){
            Toast.makeText(this,"No Data", Toast.LENGTH_SHORT).show();
        }
        else
        {
            while(cursor.moveToNext()){
                list.add(cursor.getString(0));
            }
        }
    }

//    private void getData() {
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }
}