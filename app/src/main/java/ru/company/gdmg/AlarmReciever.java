package ru.company.gdmg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;


import static ru.company.gdmg.R.raw.alarm;

public class AlarmReciever extends BroadcastReceiver {

    MediaPlayer sound;
    @Override
    public void onReceive(Context context, Intent intent) {
        sound = MediaPlayer.create(context, alarm);
        sound.start();
        Toast toast = Toast.makeText(context.getApplicationContext(),
                "Пора вставать!", Toast.LENGTH_SHORT);
        toast.show();
    }
}
