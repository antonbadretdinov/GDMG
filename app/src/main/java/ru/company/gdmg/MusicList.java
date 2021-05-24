package ru.company.gdmg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import ru.company.gdmg.ui.notifications.NotificationsFragment;

import static androidx.navigation.Navigation.findNavController;

public class MusicList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        Boolean runFirst = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("runFirst", true);
        Button nextBtn = findViewById(R.id.next);
        if(runFirst) {
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
        }else{
            nextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
    }
}