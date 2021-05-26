package ru.company.gdmg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean firstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("firstRun", true);
        if(firstRun) {
            final Intent intent = new Intent(this, MusicList.class);
            Button button = findViewById(R.id.next_button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(intent);
                    finish();
                }
            });
        }else{
            final Intent intent = new Intent(this, MainActivity.class);
            Button button = findViewById(R.id.next_button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(intent);
                    finish();
                }
            }  );
    }
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("firstRun", false).apply();
    }
}