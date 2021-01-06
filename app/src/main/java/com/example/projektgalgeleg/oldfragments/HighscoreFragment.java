package com.example.projektgalgeleg.oldfragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.projektgalgeleg.R;
import com.example.projektgalgeleg.userinterface.MainActivity;

import java.util.ArrayList;

public class HighscoreFragment extends Fragment {

    ListView lstV;
    MainActivity main;
    SharedPreferences sp;

    @Override
    // Elendig highscore kan kun holde 1 highscore.
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_highscore, container, false);
        main = (MainActivity) getActivity();

        lstV = view.findViewById(R.id.highscoresList);

        sp = getActivity().getSharedPreferences("args", Context.MODE_PRIVATE);

        String highscore = sp.getString("nameAndScore", "");

        ArrayList<String> listScores = new ArrayList<>();
        listScores.add(highscore);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, listScores);

        lstV.setAdapter(arrayAdapter);


        return view;
    }
}