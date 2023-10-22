/**
 * This class contains methods for viewing DB records
 * MAD-E10
 *
 * @author Pratyush Kumar (github.com/pratyushgta)
 */
package com.example.mad_e9_sql;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ViewFragment extends Fragment {
    DBManager dbManager;
    TableLayout tableLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view, container, false);

        dbManager = new DBManager(getContext());

        dbManager = new DBManager(getContext());
        try {
            dbManager.open();
        } catch (Exception e) {
            e.printStackTrace();
        }

        tableLayout = view.findViewById(R.id.tableLayout);

        Cursor cursor = dbManager.fetch();

        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_NAME));
                String hp = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_ATTACK_HP));

                // Create a new row for each record
                TableRow tableRow = new TableRow(getContext());

                TextView idTextView = new TextView(getContext());
                idTextView.setText(id);
                idTextView.setTextColor(getResources().getColor(android.R.color.black)); // Set text color to black
                idTextView.setGravity(android.view.Gravity.CENTER); // Center-align text

                TextView nameTextView = new TextView(getContext());
                nameTextView.setText(name);
                nameTextView.setTextColor(getResources().getColor(android.R.color.black)); // Set text color to black
                nameTextView.setGravity(android.view.Gravity.CENTER); // Center-align text

                TextView hpTextView = new TextView(getContext());
                hpTextView.setText(hp);
                hpTextView.setTextColor(getResources().getColor(android.R.color.black)); // Set text color to black
                hpTextView.setGravity(android.view.Gravity.CENTER); // Center-align text

                tableRow.addView(idTextView);
                tableRow.addView(nameTextView);
                tableRow.addView(hpTextView);

                tableLayout.addView(tableRow);
            } while (cursor.moveToNext());
        }

        return view;
    }
}
