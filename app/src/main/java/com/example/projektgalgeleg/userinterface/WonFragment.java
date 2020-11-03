package com.example.projektgalgeleg.userinterface;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.projektgalgeleg.R;


public class WonFragment extends Fragment{

    Button endBtn, goBtn;
    MainActivity main;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_won, container, false);

        goBtn = view.findViewById(R.id.goBtn);
        endBtn = view.findViewById(R.id.wonEndBtn);


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