package com.example.labfour;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class NoteActivity extends AppCompatActivity {

    EditText noteText; //txt_content;
    EditText  noteToShare; //contenttoDisplay;
    Button save, showNote;
    String retrieveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        noteText = (EditText) findViewById(R.id.note_text);
        noteToShare = (EditText) findViewById(R.id.note_show);
        save = (Button) findViewById(R.id.button_save);
        showNote = (Button) findViewById(R.id.button_show);
    }

    public void saveTofile(View v) throws IOException {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=noteText.getText().toString();
                FileOutputStream fileOutput=null;
                try{
                    fileOutput=openFileOutput("note", getApplicationContext().MODE_APPEND);
                    fileOutput.write( text.getBytes());
                    fileOutput.close();
                }catch(Exception e)
                {
                    Log.d("error","ERROR: File not saved");

                }
            }
        });

    }

    public void retrieveFromFile(View v) throws IOException {

        showNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileInputStream fileInput = null;
                try {
                    fileInput = openFileInput("note");
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInput);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String receiveString = "";
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((receiveString = bufferedReader.readLine())!= null){
                        stringBuilder.append(receiveString);
                    }
                    fileInput.close();
                    retrieveData = stringBuilder.toString();
                    noteToShare.setText(retrieveData);
                    noteToShare.setVisibility(View.VISIBLE);


                    noteToShare.setText(noteText.getText());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
