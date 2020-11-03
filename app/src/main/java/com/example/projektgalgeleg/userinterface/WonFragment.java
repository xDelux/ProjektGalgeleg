package com.example.projektgalgeleg.userinterface;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projektgalgeleg.R;
import com.example.projektgalgeleg.logik.Hangman;


public class WonFragment extends Fragment{

    Button endBtn, goBtn;
    TextView score;
    MainActivity main;
    SharedPreferences sp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_won, container, false);

        sp = getActivity().getSharedPreferences("args", Context.MODE_PRIVATE);
        score = view.findViewById(R.id.scoreTxt);
        goBtn = view.findViewById(R.id.goBtn);
        endBtn = view.findViewById(R.id.wonEndBtn);

        score.setText("" + Hangman.getInstance().getScore());

        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new GameFragment();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        endBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sp.edit();
                editor.putString("nameAndScore", Hangman.getInstance().getPlayerName() + ": " + Hangman.getInstance().getScore());
                editor.commit();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
                    fm.popBackStack();
                }
                main = (MainActivity) getActivity();
                main.homelayout.setVisibility(View.VISIBLE);
            }
        });


        return view;
    }
}