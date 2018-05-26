package com.example.zeeshan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private List<String> words = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView wordListView = findViewById(R.id.wordList);
        readWords();
        final ArrayAdapter adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,words);
        wordListView.setAdapter(adapter);
        wordListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String word = parent.getItemAtPosition(position).toString();
                Log.e("test",word);
                Intent intent = new Intent(MainActivity.this,Details_Activity.class);
                intent.putExtra("word",word);
                intent.putExtra("pos",position);
                startActivity(intent);

            }
        });

    }

    public void readWords(){
        InputStream is = getResources().openRawResource(R.raw.words);
        Scanner scanner = new Scanner(is);
        while(scanner.hasNext()){
            words.add(scanner.nextLine().split(";")[0]);
        }
        scanner.close();
    }
}
