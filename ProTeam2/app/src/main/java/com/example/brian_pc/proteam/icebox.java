package com.example.brian_pc.proteam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by bkabuye on 3/2/2016.
 */
public class icebox extends AppCompatActivity {

    TextView viewPanel;
    String view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.icebox);
        viewPanel = (TextView) findViewById(R.id.mTextView);
        viewPanel.setText(getIntent().getStringExtra("mytext"));
    }
}