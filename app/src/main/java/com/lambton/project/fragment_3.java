package com.lambton.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_3 extends Fragment {
    private int[] arr;


    private String que, op1, op2, op3, op4, ans;
    private int score;
    private CheckBox c1, c2, c3, c4;

    Button b;

    public fragment_3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View layout = inflater.inflate(R.layout.fragment_3, container, false);



        AllData a = new AllData();

        arr = getArguments().getIntArray("arr");



        que = a.getQuestion(arr[2]);
        op1 = a.getAnswers(arr[2],0);
        op2 = a.getAnswers(arr[2],1);
        op3 = a.getAnswers(arr[2],2);
        op4 = a.getAnswers(arr[2],3);
        ans = a.getAnswers(arr[2],4);
        score = getArguments().getInt("score");

//        int[] arr = getArguments().getIntArray("arr");
//        String[] questions = getArguments().getStringArray("questions");

        TextView text= layout.findViewById(R.id.question3);

        Button next = (Button) layout.findViewById(R.id.next);
//        next.setOnClickListener(this);

        c1 = (CheckBox) layout.findViewById(R.id.checkbox1);
        c2 = (CheckBox) layout.findViewById(R.id.checkbox2);
        c3 = (CheckBox) layout.findViewById(R.id.checkbox3);
        c4 = (CheckBox) layout.findViewById(R.id.checkbox4);



        text.setText(que);
        c1.setText(op1);
        c2.setText(op2);
        c3.setText(op3);
        c4.setText(op4);

//        new code

        b = layout.findViewById(R.id.next);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(c1.isChecked() && ans.equals(op1) && !c2.isChecked() && !c3.isChecked() && !c4.isChecked())
                {
                    score++;
                    Toast.makeText(getActivity(), "Correct answer", Toast.LENGTH_SHORT).show();
                }
                else if (c2.isChecked() && ans.equals(op2) && !c1.isChecked() && !c3.isChecked() && !c4.isChecked())
                {
                    score++;
                    Toast.makeText(getActivity(), "Correct answer", Toast.LENGTH_SHORT).show();
                }
                else if(c3.isChecked() && ans.equals(op3) && !c1.isChecked() && !c2.isChecked() && !c4.isChecked())
                {
                    score++;
                    Toast.makeText(getActivity(), "Correct answer", Toast.LENGTH_SHORT).show();
                }
                else if(c4.isChecked() && ans.equals(op4) && !c1.isChecked() && !c2.isChecked() && !c3.isChecked())
                {
                    score++;
                    Toast.makeText(getActivity(), "Correct answer", Toast.LENGTH_SHORT).show();
                }


                Fragment fragment = new fragment_4();


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
