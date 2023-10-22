/**
 * This class contains methods for inserting records in DB
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

public class AddFragment extends Fragment {
    TextInputEditText name, hp;
    Button addBtn;
    DBManager dbManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        name = view.findViewById(R.id.add_name);
        hp = view.findViewById(R.id.add_points);
        addBtn = view.findViewById(R.id.add_button);

        dbManager = new DBManager(getContext());
        try {
            dbManager.open();
        } catch (Exception e) {
            e.printStackTrace();
        }

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (String.valueOf(name.getText()).equals("") || String.valueOf(hp.getText()).equals("")) {
                    Toast.makeText(getActivity(), "Hah. Are you missing something?", Toast.LENGTH_SHORT).show();
                } else {
                    dbManager.insert(String.valueOf(name.getText()), String.valueOf(hp.getText()));
                    Toast.makeText(getActivity(), "Record inserted!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}