package com.lambton.project;

import com.lambton.project.AllData;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_1 extends Fragment implements View.OnClickListener {


    public TextView text;
    private String op1, op2, op3, op4, ans, que;
    private int score;
    private int[] arr;



    public fragment_1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View layout = inflater.inflate(R.layout.fragment_1, container, false);



        AllData a = new AllData();


        String st = a.getQuestion(0);

        arr = a.getRadnom();



        que = a.getQuestion(arr[0]);
        op1 = a.getAnswers(arr[0],0);
        op2 = a.getAnswers(arr[0],1);
        op3 = a.getAnswers(arr[0],2);
        op4 = a.getAnswers(arr[0],3);
        ans = a.getAnswers(arr[0],4);
        score = a.getScore();

//        int[] arr = getArguments().getIntArray("arr");
//        String[] questions = getArguments().getStringArray("questions");

        TextView text= layout.findViewById(R.id.question1);
        Button b1 = (Button) layout.findViewById(R.id.button1);
        Button b2 = (Button) layout.findViewById(R.id.button2);
        Button b3 = (Button) layout.findViewById(R.id.button3);
        Button b4 = (Button) layout.findViewById(R.id.button4);


        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);

        text.setText(que);
        b1.setText(op1);
        b2.setText(op2);
        b3.setText(op3);
        b4.setText(op4);

        return layout;
    }

    public void onClick  (View view) {




        switch (view.getId())
        {



            case R.id.button1:
                if(ans.equals(op1))
                {
                    score++;
                    Toast.makeText(getActivity(), "Correct answer", Toast.LENGTH_SHORT).show();

                }

                else
                    Toast.makeText(getActivity(), "Incorrect answer", Toast.LENGTH_SHORT).show();
                Fragment fragment = new fragment_2();

                Bundle bundle = new Bundle();
                bundle.putIntArray("arr",arr);
                bundle.putInt("score",score);

                fragment.setArguments(bundle);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container, fragment,"f2").commit();
                break;

            case R.id.button2:
                if(ans.equals(op2))
                {
                    score++;
                    Toast.makeText(getActivity(), "Correct answer", Toast.LENGTH_SHORT).show();
                }


                else
                    Toast.makeText(getActivity(), "Incorrect ", Toast.LENGTH_SHORT).show();
                Fragment fragment2 = new fragment_2();

                Bundle bundle2 = new Bundle();
                bundle2.putIntArray("arr",arr);
                bundle2.putInt("score",score);


                fragment2.setArguments(bundle2);
                FragmentTransaction ft2 = getFragmentManager().beginTransaction();

                ft2.replace(R.id.container, fragment2,"f2").commit();



                break;

            case R.id.button3:
                if(ans.equals(op3))
                {
                    score++;

                    Toast.makeText(getActivity(), "Correct answer", Toast.LENGTH_SHORT).show();

                }
                else
                    Toast.makeText(getActivity(), "Incorrect answer", Toast.LENGTH_SHORT).show();
                Fragment fragment3 = new fragment_2();

                Bundle bundle3 = new Bundle();
                bundle3.putIntArray("arr",arr);
                bundle3.putInt("score",score);

                fragment3.setArguments(bundle3);
                FragmentTransaction ft3 = getFragmentManager().beginTransaction();

                ft3.replace(R.id.container, fragment3,"f2").commit();
                break;

            case R.id.button4:
                if(ans.equals(op4))
                {
                    score++;

                    Toast.makeText(getActivity(), "Correct answer", Toast.LENGTH_SHORT).show();

                }
                else
                    Toast.makeText(getActivity(), "Incorrect answer", Toast.LENGTH_SHORT).show();
                Fragment fragment4 = new fragment_2();

                Bundle bundle4 = new Bundle();
                bundle4.putIntArray("arr",arr);
                bundle4.putInt("score",score);

                fragment4.setArguments(bundle4);
                FragmentTransaction ft4 = getFragmentManager().beginTransaction();

                ft4.replace(R.id.container, fragment4,"f2").commit();
                break;

        }


    }

}
