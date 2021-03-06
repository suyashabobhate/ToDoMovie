package com.example.todomovie;


import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public class Watched extends Fragment{

    public DatabaseHandler db;
    public List<Movie> watched=new ArrayList<>();
    public ListView listview;
    View view;

    public Watched() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.watchedfragment, container, false);
        db=new DatabaseHandler(getActivity());
        SetAdapter();
        return view;
    }

    public void SetAdapter() {
        watched.addAll(db.getAllMovie("Watched"));
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
        listview.setSelection(arrayAdapter.getCount() - 1);
        listview.invalidateViews();
        /*listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                AlertDialog dialbox = AskOption(pos);
                dialbox.show();
                return true;
            }
        });*/

    }


    /*private AlertDialog AskOption(final int pos)
    {
        final String delete= (String) listview.getItemAtPosition(pos);;
        AlertDialog myQuittingDialogBox = new AlertDialog.Builder(getActivity())
                .setTitle(delete)
                .setMessage("Have you watched this Movie?")


                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {

                        delete(delete);
                        dialog.dismiss();
                    }

                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }
                })
                .create();

        return myQuittingDialogBox;
    }

    public void delete(String delete){
        int id=db.getId(delete,"Watching");
        db.deleteMovie(id,"Watching");
        listview.invalidateViews();
        addToWatched(delete);
    }

    public void addToWatched(String delete){
        ArrayAdapter<String> adapter= (ArrayAdapter<String>) listview.getAdapter();
        listview.setAdapter(adapter);
        adapter.remove(delete);
        adapter.notifyDataSetChanged();
        db.addMovie(delete,"Watched");
    }*/
}

