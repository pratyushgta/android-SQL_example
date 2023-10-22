/**
 * This class contains methods for updating records in DB
 * MAD-E10
 *
 * @author Pratyush Kumar (github.com/pratyushgta)
 */
package com.example.mad_e9_sql;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class UpdateFragment extends Fragment {
    TextInputEditText id, name, hp;
    Button updateBtn;
    DBManager dbManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update, container, false);
        id = view.findViewById(R.id.update_ID);
        name = view.findViewById(R.id.update_name);
        hp = view.findViewById(R.id.update_points);
        updateBtn = view.findViewById(R.id.update_button);

        dbManager = new DBManager(getContext());
        try {
            dbManager.open();
        } catch (Exception e) {
            e.printStackTrace();
        }

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (String.valueOf(name.getText()).equals("") || String.valueOf(hp.getText()).equals("") || String.valueOf(id.getText()).equals("")) {
                    Toast.makeText(getActivity(), "Heh. You thought this hasn't been accounted for?", Toast.LENGTH_SHORT).show();
                } else {
                    dbManager.update(Long.parseLong(String.valueOf(id.getText())), String.valueOf(name.getText()), String.valueOf(hp.getText()));
                    Toast.makeText(getActivity(), "Record updated!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}