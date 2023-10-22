/**
 * This class contains methods for handling the fragments
 * MAD-E10
 *
 * @author Pratyush Kumar (github.com/pratyushgta)
 */
package com.example.mad_e9_sql;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.mad_e9_sql.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    @NonNull
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            if (item.getItemId() == R.id.nav_view) {
                selectedFragment = new ViewFragment();
            } else if (item.getItemId() == R.id.nav_add) {
                selectedFragment = new AddFragment();
            } else if (item.getItemId() == R.id.nav_update) {
                selectedFragment = new UpdateFragment();
            } else if (item.getItemId() == R.id.nav_remove) {
                selectedFragment = new RemoveFragment();
            }
            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.home_framelayout, selectedFragment).commit();
            }
            return true;
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.home_framelayout, new ViewFragment()).commit();
    }
}