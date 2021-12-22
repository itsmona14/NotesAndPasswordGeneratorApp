package com.example.notesandpasswdmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.security.SecureRandom;

public class GeneratePasswordActivity extends AppCompatActivity {

    int len;
    TextView textView;
    Button btnCopy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_password);
        getSupportActionBar().hide();
        Bundle bundle=getIntent().getExtras();
        len=bundle.getInt("val");
        String pass=Generate(len);
        textView=findViewById(R.id.textPassword);
        textView.setText(pass);

        btnCopy=findViewById(R.id.btnCopy);
        btnCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData=ClipData.newPlainText("Edittext",textView.getText().toString());
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(GeneratePasswordActivity.this,"Copied to Clipboard",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String Generate(int len) {
        String allchar="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@$%!#";
        StringBuilder sb=new StringBuilder();
        SecureRandom random=new SecureRandom();
        for(int i = 0 ; i < len; i++){
            int index=random.nextInt(allchar.length());
            sb.append(allchar.charAt(index));
        }
        return sb.toString();
    }
}