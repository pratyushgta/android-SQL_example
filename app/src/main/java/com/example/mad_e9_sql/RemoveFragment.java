/**
 * This class contains methods for deleting records in DB
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

public class RemoveFragment extends Fragment {

    TextInputEditText id;
    Button removeBtn;
    DBManager dbManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_remove, container, false);
        id = view.findViewById(R.id.remove_ID);
        removeBtn = view.findViewById(R.id.remove_button);

        dbManager = new DBManager(getContext());
        try {
            dbManager.open();
        } catch (Exception e) {
            e.printStackTrace();
        }

        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (String.valueOf(id.getText()).equals("")) {
                    Toast.makeText(getActivity(), "Delete what again?", Toast.LENGTH_SHORT).show();
                } else {
                    dbManager.delete(Long.parseLong(String.valueOf(id.getText())));
                    Toast.makeText(getActivity(), "Record removed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}