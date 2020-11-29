package com.lambton.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class fragment_2 extends Fragment  {



    private String que, op1, op2, op3, op4, ans;
    private int score;
    private int[] arr;

    Button b;

    private RadioGroup rg;
    private RadioButton r1;
    private RadioButton r2;
    private RadioButton r3;
    private RadioButton r4;

    public fragment_2() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_2, container, false);
        AllData a = new AllData();

//        String que = getArguments().getString("que");

        arr = getArguments().getIntArray("arr");
        score = getArguments().getInt("score");
        que = a.getQuestion(arr[1]);
        op1 = a.getAnswers(arr[1],0);
        op2 = a.getAnswers(arr[1],1);
        op3 = a.getAnswers(arr[1],2);
        op4 = a.getAnswers(arr[1],3);
        ans = a.getAnswers(arr[1],4);


        TextView text= layout.findViewById(R.id.question2);


        text.setText(que);

        rg = layout.findViewById(R.id.radiogroup);
        int radioId = rg.getCheckedRadioButtonId();



        r1 = layout.findViewById(R.id.radio1);
        r2 = layout.findViewById(R.id.radio2);
        r3 = layout.findViewById(R.id.radio3);
        r4 = layout.findViewById(R.id.radio4);

        r1.setText(op1);
        r2.setText(op2);
        r3.setText(op3);
        r4.setText(op4);

        b = layout.findViewById(R.id.next);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = rg.getCheckedRadioButtonId();




                RadioButton rb = rg.findViewById(i);

                if(ans.equals(rb.getText())) {
                    score++;

                    Toast.makeText(getActivity(), "Correct answer", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getActivity(), "Incorrect answer", Toast.LENGTH_SHORT).show();


                Fragment fragment = new fragment_3();

                Bundle bundle = new Bundle();
                bundle.putIntArray("arr",arr);
                bundle.putInt("score",score);
                fragment.setArguments(bundle);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container, fragment, "f3").commit();


            }
        });


        return layout;
    }
}