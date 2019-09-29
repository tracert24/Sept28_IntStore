package com.espinoza.sept28_intstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.editText);
    }

    public void writeData (View v) {
       String data = input.getText().toString();
       FileOutputStream writer = null;
       try {
            writer = openFileOutput("data1.txt", MODE_PRIVATE );
            writer.write(data.getBytes());
        } catch (FileNotFoundException e) {
            Log.d("Error!", "File not found! GG ka!");
            e.printStackTrace();
        } catch (IOException e) {
            Log.d("error", "IO Error! Yari ka!");
            e.printStackTrace();
        } finally {
           try {
               writer.close();
           } catch (IOException e) {
               Log.d("error", "Error! Yari ka!");           }
       }
        Toast.makeText(this, "Data is SAVED.", Toast.LENGTH_LONG).show();
    }

    public void showData (View v) {
        StringBuffer msg = null;
        try {
            int token;
            msg = new StringBuffer();
            FileInputStream reader = openFileInput("data1.txt");


            while ((token = reader.read()) != -1) {
                msg.append((char) token);
            }

        } catch (FileNotFoundException e) {
            Log.d("error", "Error! Yari ka!");
            e.printStackTrace();
        } catch (IOException e) {
            Log.d("error", "IO Error! Paktay ka!");
        }

        Toast.makeText(this, msg.toString(), Toast.LENGTH_LONG).show();
        }

        }

