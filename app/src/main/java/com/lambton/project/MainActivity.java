package com.lambton.project;
import com.lambton.project.AllData;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button start_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_button = (Button) findViewById(R.id.start_button);
        start_button.setOnClickListener(this);

        TextView text=(TextView)findViewById(R.id.testing);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.start_button:
//                setContentView(R.layout.fragment_container);
                Intent intent = new Intent(MainActivity.this, fragment_container.class);
                startActivity(intent);
                break;
        }

    }


}
