package com.example.zeeshan.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Details_Activity extends AppCompatActivity {
    private List<String> meaningList = new ArrayList<>();
    private List<String> sentenceList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        TextView meaning = findViewById(R.id.meaning);
        TextView tv_word = findViewById(R.id.word);
        Button audio = findViewById(R.id.audio);
        String word;




        Intent intent = getIntent();
        word = intent.getStringExtra("word");
        final int position = intent.getIntExtra("pos", 0);

        tv_word.setText(word);




        readMeaning(position);
        readSentence(position);

        audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0){
                    MediaPlayer mp = MediaPlayer.create(Details_Activity.this, R.raw.laconic);
                    mp.start();

                }
                if (position == 1){
                    MediaPlayer mp = MediaPlayer.create(Details_Activity.this, R.raw.insipid);
                    mp.start();

                }
                if (position == 2){
                    MediaPlayer mp = MediaPlayer.create(Details_Activity.this, R.raw.pragmatic);
                    mp.start();

                }
                if (position == 3){
                    MediaPlayer mp = MediaPlayer.create(Details_Activity.this, R.raw.iconoclast);
                    mp.start();

                }
                if (position == 4){
                    MediaPlayer mp = MediaPlayer.create(Details_Activity.this, R.raw.arduous);
                    mp.start();

                } if (position == 5){
                    MediaPlayer mp = MediaPlayer.create(Details_Activity.this, R.raw.profligate);
                    mp.start();

                }
                if (position == 6){
                    MediaPlayer mp = MediaPlayer.create(Details_Activity.this, R.raw.prosaic);
                    mp.start();

                } if (position == 7){
                    MediaPlayer mp = MediaPlayer.create(Details_Activity.this, R.raw.ameliorate);
                    mp.start();

                } if (position == 8){
                    MediaPlayer mp = MediaPlayer.create(Details_Activity.this, R.raw.obsequious);
                    mp.start();

                }
                if (position == 9){
                    MediaPlayer mp = MediaPlayer.create(Details_Activity.this, R.raw.capricious);
                    mp.start();

                }
                if (position == 10){
                    MediaPlayer mp = MediaPlayer.create(Details_Activity.this, R.raw.fortuitous);
                    mp.start();

                }if (position == 11){
                    MediaPlayer mp = MediaPlayer.create(Details_Activity.this, R.raw.orthodox);
                    mp.start();

                }
                if (position == 12){
                    MediaPlayer mp = MediaPlayer.create(Details_Activity.this, R.raw.alacrity);
                    mp.start();

                }
                if (position == 13){
                    MediaPlayer mp = MediaPlayer.create(Details_Activity.this, R.raw.pellucid);
                    mp.start();

                }  if (position == 14){
                    MediaPlayer mp = MediaPlayer.create(Details_Activity.this, R.raw.corroborate);
                    mp.start();

                }





            }
        });



    }

    public void readMeaning(int position){
        TextView meaning = findViewById(R.id.meaning);

        InputStream is = getResources().openRawResource(R.raw.words);
        Scanner scanner = new Scanner(is);
        while(scanner.hasNext()){

            meaningList.add(scanner.nextLine().split(";")[1]);


        }
        scanner.close();



        meaning.setText(meaningList.get(position));

    }

    public void readSentence(int position){
        TextView sentence = findViewById(R.id.sentence);

        InputStream is = getResources().openRawResource(R.raw.words);
        Scanner scanner = new Scanner(is);
        while(scanner.hasNext()){

            sentenceList.add(scanner.nextLine().split(";")[2]);


        }
        scanner.close();

        sentence.setText(sentenceList.get(position));

    }
}
