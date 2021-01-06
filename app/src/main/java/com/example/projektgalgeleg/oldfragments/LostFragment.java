package com.example.projektgalgeleg.oldfragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.projektgalgeleg.R;
import com.example.projektgalgeleg.logik.Hangman;
import com.example.projektgalgeleg.userinterface.MainActivity;

public class LostFragment extends Fragment {
    Button lostendBtn, tryAgainBtn;
    TextView title;
    MainActivity main;
    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lost, container, false);

        tryAgainBtn = (Button) view.findViewById(R.id.tryagainBtn);
        lostendBtn = (Button) view.findViewById(R.id.lostEndBtn);
        title = view.findViewById(R.id.lostTitleTxt);

        title.setText("Du table. Ordet var: " + Hangman.getInstance().getWord());

        tryAgainBtn.setOnClickListener(new View.OnClickListener() {
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

        lostendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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