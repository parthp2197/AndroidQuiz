package com.lambton.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_4 extends Fragment implements View.OnClickListener {
    private int[] arr;

    private int score;

    public fragment_4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_4, container, false);

        ImageButton b2 = layout.findViewById(R.id.imageView2);
        ImageButton b3 = layout.findViewById(R.id.imageView3);
        ImageButton b4 = layout.findViewById(R.id.imageView4);
        ImageButton b5 = layout.findViewById(R.id.imageView5);



        arr = getArguments().getIntArray("arr");

        score = getArguments().getInt("score");
        Button next = (Button) layout.findViewById(R.id.next);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);


        return layout;
    }

    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.imageView4:
                Toast.makeText(getActivity(), "Correct answer", Toast.LENGTH_SHORT).show();
                score++;

                Fragment fragment = new fragment_5();

                Bundle bundle = new Bundle();
                bundle.putIntArray("arr",arr);
                bundle.putInt("score",score);
                fragment.setArguments(bundle);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container, fragment, "f5").commit();
                break;

            default:
                Toast.makeText(getActivity(), "Incorrect answer", Toast.LENGTH_SHORT).show();
                Fragment fragment2 = new fragment_5();

                Bundle bundle2 = new Bundle();
                bundle2.putIntArray("arr",arr);
                bundle2.putInt("score",score);
                fragment2.setArguments(bundle2);

                FragmentTransaction ft2 = getFragmentManager().beginTransaction();
                ft2.replace(R.id.container, fragment2, "f5").commit();


        }
    }
}
