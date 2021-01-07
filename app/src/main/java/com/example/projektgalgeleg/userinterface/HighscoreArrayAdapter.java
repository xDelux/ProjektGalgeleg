package com.example.projektgalgeleg.userinterface;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.projektgalgeleg.R;

import java.util.ArrayList;

public class HighscoreArrayAdapter extends ArrayAdapter<HighscoreItem> {

    private Context mContext;
    private int mResource;

    public HighscoreArrayAdapter(Context context, int resource, ArrayList<HighscoreItem> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String navn = getItem(position).getNavn();
        String score = getItem(position).getScore();
        String sværhedsgrad = getItem(position).getSværhedsgrad();

        HighscoreItem highscore = new HighscoreItem(navn, score, sværhedsgrad);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvName = (TextView) convertView.findViewById(R.id.txtV1);
        TextView tvSvær = (TextView) convertView.findViewById(R.id.txtV2);
        TextView tvScore = (TextView) convertView.findViewById(R.id.txtV3);

        tvName.setText(navn);
        tvSvær.setText(score);
        tvScore.setText(sværhedsgrad);

        return convertView;

    }
}
