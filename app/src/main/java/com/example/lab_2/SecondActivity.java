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
    public class Pack{
        List<String>getDetails(String pack){
            List<String>bundle= new ArrayList<>();
            if(pack.equals("Front-End Package")) {
                bundle.add("\n . React");
                bundle.add("\n . JavaScript");
                bundle.add("\n . Vite on Node.js platform");
            }
            else if(pack.equals("Back-End Package")) {
                bundle.add("\n . Django");
                bundle.add("\n . Python");
                bundle.add("\n . Heroku on Python platform");
            }

            else if(pack.equals("Full Stack Package")){
                bundle.add("\n . Angular");
                bundle.add("\n . Express.js");
                bundle.add("\n . AWS with TypeScript/JavaScript");

            }


            return bundle;
        }
    }
    private Pack expert= new Pack();
    public static final String EXTRA_MESSAGE="message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        TextView displayedText =(TextView)  findViewById(R.id.infoss);
        Intent intent = getIntent();
        String messageText = intent.getStringExtra(EXTRA_MESSAGE);
        TextView messageView = (TextView)findViewById(R.id.text);
        List<String> infoList =expert.getDetails(messageText);
        StringBuilder infoFormatted = new StringBuilder();
        for(String inf : infoList)
        {
            infoFormatted.append(inf).append('\n');
        }
        displayedText.setText("Your PACKAGE includes - ");
        messageView .setText(infoFormatted);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}