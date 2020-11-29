package com.lambton.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_5 extends Fragment {
    private int score;

    private int[] arr;
    ListView lv;
    private String que, op1, op2, op3, op4, ans;
    private String message;
    int retake=0;

    public fragment_5() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_5, container, false);

        lv = (ListView)layout.findViewById(R.id.listview1);

        AllData a = new AllData();

        arr = getArguments().getIntArray("arr");
        score = getArguments().getInt("score");

        que = a.getQuestion(arr[3]);
        op1 = a.getAnswers(arr[3],0);
        op2 = a.getAnswers(arr[3],1);
        op3 = a.getAnswers(arr[3],2);
        op4 = a.getAnswers(arr[3],3);
        ans = a.getAnswers(arr[3],4);

        final String values[] = {op1, op2, op3, op4};

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,values);
        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(ans.equals(values[position]))
                {
                    score++;
                    Toast.makeText(getActivity(), "Correct answer", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getActivity(), "Incorrect answer", Toast.LENGTH_SHORT).show();
                }

                if(score<=2)
                {
                    message="Please try again!";
                }
                else if(score==3)
                {
                    message="Good job!";
                }
                else if(score==4)
                {
                    message="Excellent work!";
                }
                else
                {
                    message="You are a genius!";
                }


                Intent intent = new Intent(getContext(), Scoreboard.class);
                intent.putExtra("message",message);
                intent.putExtra("score",score);
                startActivity(intent);


            }
        });



        TextView text= layout.findViewById(R.id.question5);
        text.setText(que);


        return layout;
    }
}
