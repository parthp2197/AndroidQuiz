package com.lambton.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Scoreboard extends AppCompatActivity  implements View.OnClickListener {

    private Button retake;
    private Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        Intent intent = getIntent();


//        String message =intent.getStringExtra("message");

int score = intent.getIntExtra("score",0);

        String m = "Your score is "+score+"/5. "+intent.getStringExtra("message");



        TextView text= (TextView) findViewById(R.id.ScoreText);
        text.setText(m);
//        text.append(s);

        getIntent();

        retake = (Button)findViewById(R.id.retake);
        retake.setOnClickListener(this);
        exit = (Button)findViewById(R.id.exit);
        exit.setOnClickListener(this);
        if(score>2)
        {
            retake.setVisibility(View.GONE);
        }

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.retake:
//                setContentView(R.layout.fragment_container);
                Intent intent = new Intent(Scoreboard.this, fragment_container.class);
                startActivity(intent);
                break;

            case R.id.exit:
                Intent intent1 = new Intent(Intent.ACTION_MAIN);
                intent1.addCategory(Intent.CATEGORY_HOME);
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent1);
        }

    }
}
