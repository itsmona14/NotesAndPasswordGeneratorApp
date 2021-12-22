package com.example.notesandpasswdmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NoteDetailsActivity extends AppCompatActivity {

    private TextView TitleDetail, ContentDetail;
    FloatingActionButton btnEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);

        TitleDetail=findViewById(R.id.TitleDetail);
        ContentDetail=findViewById(R.id.ContentDetail);
        btnEdit=findViewById(R.id.EditNote);
        Toolbar toolbar=findViewById(R.id.ToolBarOfNoteDetails);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent data=getIntent();
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),EditNoteActivity.class);
                intent.putExtra("title",data.getStringArrayExtra("title"));
                intent.putExtra("content",data.getStringArrayExtra("content"));
                intent.putExtra("noteId",data.getStringArrayExtra("noteId"));
                view.getContext().startActivity(intent);
            }
        });

        ContentDetail.setText(data.getStringExtra("content"));
        TitleDetail.setText(data.getStringExtra("title"));
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}