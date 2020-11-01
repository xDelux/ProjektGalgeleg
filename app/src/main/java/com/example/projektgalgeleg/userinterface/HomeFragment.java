package com.example.projektgalgeleg.userinterface;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.projektgalgeleg.R;


public class HomeFragment extends Fragment implements View.OnClickListener {

    Button playBtn;
    Button settingBtn;
    Button highscoresBtn;
    FragmentManager fragmentManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container,false);
        playBtn = (Button) container.findViewById(R.id.playBtn);
        settingBtn = (Button) container.findViewById(R.id.settingBtn);
        highscoresBtn = (Button) container.findViewById(R.id.highscoreBtn);

        playBtn.setOnClickListener(this);
        settingBtn.setOnClickListener(this);
        highscoresBtn.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()) {
            case R.id.playBtn:
                fragment = new HomeFragment();
                break;
            case R.id.settingBtn:
                fragment = new GameFragment();
                break;
            case R.id.highscoreBtn:
                fragment = new HighscoreFragment();
                break;

        }
        ((MainActivity) getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, fragment).addToBackStack(null).commit();
    }
}