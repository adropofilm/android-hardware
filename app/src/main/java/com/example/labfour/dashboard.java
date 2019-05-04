package com.example.labfour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class dashboard extends AppCompatActivity {

    Button note_button, record_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        note_button=(Button)findViewById(R.id.create_note_button);
        record_button=(Button)findViewById(R.id.create_recording_button);
    }

    public void recordAudioIntent(View v){
        Intent redirect = new Intent(dashboard.this, AudioRecord.class);
        startActivity(redirect);
    }
    public void createNoteIntent(View v){
        Intent redirect = new Intent(dashboard.this, NoteActivity.class);
        startActivity(redirect);
    }

}
