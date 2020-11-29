package com.example.schoolapp.videolecs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolapp.R;
import com.example.schoolapp.ebook.EbookAdapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//public class VideoLecAdapter extends RecyclerView.Adapter<VideoLecAdapter.VideoLecViewHolder> {
//
//    private Context context;
//    private List<VideoLecData> list;
//    RecyclerView rvVideolecs;
//    final View.OnClickListener onClickListener = new MyOnClickListener();
//
//
//    public class VideoLecViewHolder extends RecyclerView.ViewHolder {
//
//
//        TextView videoTitle;
//
//        public VideoLecViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            videoTitle=itemView.findViewById(R.id.videoTitle);
//        }
//    }
//
//    public VideoLecAdapter(Context context,List<VideoLecData>,RecyclerView rvVideolecs){
//        this.context=context;
//        this.list=list;
//        this.rvVideolecs=rvVideolecs;
//    }
//
//    public VideoLecAdapter(Context context, List<VideoLecData> list) {
//        this.context = context;
//        this.list = list;
//    }
//
//    @NonNull
//    @Override
//    public VideoLecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        View view = LayoutInflater.from(context).inflate(R.layout.videolec_item_layout,parent,false);
//
////        LayoutInflater inflater=LayoutInflater.from(context);
////        View view =inflater.inflate(R.layout.videolec_item_layout, parent,false);
////        view.setOnClickListener(onClickListener);
////        VideoLecViewHolder videoLecViewHolder = new VideoLecViewHolder(view);
//
//        return new VideoLecViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull VideoLecViewHolder holder, final int position) {
//
//        holder.videoTitle.setText(list.get(position).getTitle());
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context,list.get(position).getTitle(),Toast.LENGTH_SHORT).show();
//            }
//        });
//
////    VideoLecData data=list.get(position);
////    VideoLecViewHolder.title.setText(""+VideoLecData.getTitle());
////    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//
//
////
//}
//
//    private class MyOnClickListener implements View.OnClickListener {
//        @Override
//        public void onClick(View view) {
//
//        }
//    }

public class VideoLecAdapter extends RecyclerView.Adapter<VideoLecAdapter.ViewHolder>{

    Context context;
    List<VideoLecData> list;
    RecyclerView rvVideos;
    final View.OnClickListener onClickListener = new MyOnClickListener();

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            title=itemView.findViewById(R.id.videoTitle);
        }
    }

    public VideoLecAdapter(Context context,List<VideoLecData> list,RecyclerView rvVideos){
        this.context=context;
        this.list=list;
        this.rvVideos=rvVideos;
    }

    @NonNull
    @Override
    public VideoLecAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.videolec_item_layout,parent,false);
        view.setOnClickListener(onClickListener);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VideoLecData data = list.get(position);

//        holder.title.setText(list.getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            int itemPosition = rvVideos.getChildLayoutPosition(view);
            String item = list.get(itemPosition).getTitle();
            Toast.makeText(context,item,Toast.LENGTH_SHORT).show();
        }
    }
}