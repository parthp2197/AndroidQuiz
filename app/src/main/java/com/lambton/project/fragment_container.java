package com.lambton.project;
import com.lambton.project.AllData;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class fragment_container extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        int score=0;

//        bundle.putInt("score",score);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

        Fragment fragment = new fragment_1();
//        fragment.setArguments(bundle);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.add(R.id.container, fragment,"").commit();

    }
}
