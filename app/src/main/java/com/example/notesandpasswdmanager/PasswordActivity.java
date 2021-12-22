package com.example.notesandpasswdmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class PasswordActivity extends AppCompatActivity {

    TextView textView;
    Button btnGenerate;
    SeekBar seekbar;

    int pos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        getSupportActionBar().hide();
        textView=findViewById(R.id.position);
        btnGenerate=findViewById(R.id.btnGenerate);
        seekbar=findViewById(R.id.seekbar);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                pos=i;
                textView.setText(""+pos);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pos > 0){
                    Intent intent = new Intent(PasswordActivity.this,GeneratePasswordActivity.class);
                    intent.putExtra("val",pos);
                    startActivity(intent);
                }
                else{
                    textView.setText("Error");
                }
            }
        });
    }
}