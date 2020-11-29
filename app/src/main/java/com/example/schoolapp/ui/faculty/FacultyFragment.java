package com.example.schoolapp.ui.faculty;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.schoolapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class FacultyFragment extends Fragment {
    private RecyclerView scienceDepartment, mathsDepartment, ssDepartment, langDepartment;
    private LinearLayout scienceNoData, mathsNoData, ssNoData, langNoData;
    private List<TeacherData> list1, list2, list3, list4;
    private TeacherAdapter adapter;
    private DatabaseReference reference, dbRef;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);


        scienceDepartment = view.findViewById(R.id.scienceDepartment);
        mathsDepartment = view.findViewById(R.id.mathsDepartment);
        ssDepartment = view.findViewById(R.id.ssDepartment);
        langDepartment = view.findViewById(R.id.langDepartment);

        scienceNoData = view.findViewById(R.id.scienceNoData);
        mathsNoData = view.findViewById(R.id.mathsNoData);
        ssNoData = view.findViewById(R.id.ssNoData);
        langNoData = view.findViewById(R.id.langNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        scienceDepartment();
        mathsDepartment();
        ssDepartment();
        langDepartment();



        return view;


    }

    private void scienceDepartment() {
        dbRef = reference.child("Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1 = new ArrayList<>();
                if(!snapshot.exists()){
                    scienceNoData.setVisibility(View.VISIBLE);
                    scienceDepartment.setVisibility(View.GONE);
                }else {
                    scienceNoData.setVisibility(View.GONE);
                    scienceDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    scienceDepartment.setHasFixedSize(true);
                    scienceDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1, getContext());
                    scienceDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mathsDepartment() {
        dbRef = reference.child("Mathematics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2 = new ArrayList<>();
                if(!snapshot.exists()){
                    mathsNoData.setVisibility(View.VISIBLE);
                    mathsDepartment.setVisibility(View.GONE);
                }else {
                    mathsNoData.setVisibility(View.GONE);
                    mathsDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    mathsDepartment.setHasFixedSize(true);
                    mathsDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2, getContext());
                    mathsDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ssDepartment() {
        dbRef = reference.child("Social Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3 = new ArrayList<>();
                if(!snapshot.exists()){
                    ssNoData.setVisibility(View.VISIBLE);
                    ssDepartment.setVisibility(View.GONE);
                }else {
                    ssNoData.setVisibility(View.GONE);
                    ssDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    ssDepartment.setHasFixedSize(true);
                    ssDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list3, getContext());
                    ssDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void langDepartment() {
        dbRef = reference.child("Language");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<>();
                if(!snapshot.exists()){
                    langNoData.setVisibility(View.VISIBLE);
                    langDepartment.setVisibility(View.GONE);
                }else {
                    langNoData.setVisibility(View.GONE);
                    langDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    langDepartment.setHasFixedSize(true);
                    langDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list4, getContext());
                    langDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}