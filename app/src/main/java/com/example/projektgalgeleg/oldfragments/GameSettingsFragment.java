package com.example.projektgalgeleg.oldfragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.projektgalgeleg.R;
import com.example.projektgalgeleg.logik.Hangman;


public class GameSettingsFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    Button confirmBtn;
    String input;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_settings, container, false);

        Spinner settingsSpinner = view.findViewById(R.id.difficultySpin);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.difficulty, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        settingsSpinner.setAdapter(adapter);
        settingsSpinner.setOnItemSelectedListener(this);


        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        input = parent.getItemAtPosition(position).toString();
        Log.d("GameSettingsFramgmen", "position is: " + position);
        Hangman Game = Hangman.getInstance();
        Game.setDifficulty(position + 1);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}