package ru.company.gdmg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import static androidx.navigation.Navigation.findNavController;

public class MusicList extends AppCompatActivity {


        void checks(final CheckBox checkBox){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = preferences.edit();
        if(preferences.contains("checked") && preferences.getBoolean("checked", false)) {
            checkBox.setChecked(false);
        }else {
            checkBox.setChecked(false);
        }

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox.isChecked()) {
                    editor.putBoolean("checked", true);
                    editor.apply();
                } else {
                    editor.putBoolean("checked", false);
                    editor.apply();
                }
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);


        final CheckBox hip = findViewById(R.id.hip);
        final CheckBox dzhaz = findViewById(R.id.dzhaz);
        final CheckBox techno = findViewById(R.id.techno);
        final CheckBox rock = findViewById(R.id.rock);
        final CheckBox dubstep = findViewById(R.id.dubstep);
        final CheckBox rhyme = findViewById(R.id.rhyme);
        final CheckBox country = findViewById(R.id.country);
        final CheckBox indy = findViewById(R.id.indy);
        final CheckBox pop = findViewById(R.id.pop);
        final CheckBox latin = findViewById(R.id.latin);
        final CheckBox russian = findViewById(R.id.russian);

        final CheckBox[] checkBoxes = {hip,dzhaz,techno,rock,dubstep,rhyme,country,indy,pop,latin,russian};

        for(CheckBox checkBox:checkBoxes){
           // MusicList.checks(checkBox);
        }



        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        Boolean runFirst = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("runFirst", true);
        Button nextBtn = findViewById(R.id.next);
        if (runFirst) {
            final Intent intent = new Intent(this, MainActivity.class);
            nextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                            .putBoolean("runFirst", false).apply();
                    startActivity(intent);
                    finish();
                }
            });
        } else {
            nextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });

        }

    }
}