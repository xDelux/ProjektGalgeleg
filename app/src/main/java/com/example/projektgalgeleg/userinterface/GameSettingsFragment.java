package com.example.projektgalgeleg.userinterface;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.projektgalgeleg.R;


public class GameSettingsFragment extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    Intent i;
    Button confirmBtn;
    String input;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_settings, container, false);

        Spinner settingsSpinner = view.findViewById(R.id.difficultySpin);
        confirmBtn = view.findViewById(R.id.confirmBtn);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.difficulty, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        settingsSpinner.setAdapter(adapter);
        settingsSpinner.setOnItemSelectedListener(this);

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        input = parent.getItemAtPosition(position).toString();
        Log.d("GameSettingsFramgmen", "input is: " + input);
        confirmBtn.setText(input);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        i = new Intent(getActivity().getBaseContext(), MainActivity.class);
        i.putExtra("difficulty", input);
        startActivity(i);
    }
}