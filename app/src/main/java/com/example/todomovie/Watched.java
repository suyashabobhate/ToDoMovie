package com.example.todomovie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;

public class Watched extends Fragment {

    public List<Movie> watched=new ArrayList<>();
    ListView listview;
    public DatabaseHandler db;
    View view;


    public Watched() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            view=inflater.inflate(R.layout.fragment_watched, container, false);
            db=new DatabaseHandler(getActivity());
            SetAdapter();
        return view;
    }

    public void SetAdapter() {
        watched = db.getAllMovie("Watched");
        List<String> watchedList = new ArrayList<>();
        for (Movie Movie : watched) {
            watchedList.add(Movie.getName());
        }
        listview = view.findViewById(R.id.sampleListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                watchedList);

        listview.setAdapter(arrayAdapter);


    }
}


