package com.example.lab_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    public class Disease{
        List<String>getInfo(String dis){
            List<String>info= new ArrayList<>();
            if(dis.equals("Front-End Package")) {
                info.add("\n . React");
                info.add("\n . JavaScript");
                info.add("\n . Vite on Node.js platform");
            }
            else if(dis.equals("Back-End Package")) {
                info.add("\n . Django");
                info.add("\n . Python");
                info.add("\n . Heroku on Python platform");
            }

            else if(dis.equals("Full Stack Package")){
                info.add("\n . Angular");
                info.add("\n . Express.js");
                info.add("\n . AWS with TypeScript/JavaScript");

            }


            return info;
        }
    }
    private Disease expert= new Disease();
    public static final String EXTRA_MESSAGE="message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        TextView info2 =(TextView)  findViewById(R.id.infoss);
        Intent intent = getIntent();
        String messageText = intent.getStringExtra(EXTRA_MESSAGE);
        TextView messageView = (TextView)findViewById(R.id.text);
        List<String> infoList =expert.getInfo(messageText);
        StringBuilder infoFormatted = new StringBuilder();
        for(String inf : infoList)
        {
            infoFormatted.append(inf).append('\n');
        }
        info2.setText("Your PACKAGE includes - ");
        messageView .setText(infoFormatted);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}