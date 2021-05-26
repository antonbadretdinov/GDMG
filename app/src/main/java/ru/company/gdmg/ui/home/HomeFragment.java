package ru.company.gdmg.ui.home;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.Calendar;

import ru.company.gdmg.AlarmReciever;
import ru.company.gdmg.R;

public class HomeFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        return root;
    }

    private boolean pressed = false;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        final int hour;
        final int minute;



        final TextView backText = view.findViewById(R.id.backfortxt);
        final TextView hideText = view.findViewById(R.id.hideTime);
        hideText.setVisibility(View.INVISIBLE);
        final TextView tv = view.findViewById(R.id.textView9);
        final TimePicker timePicker = view.findViewById(R.id.tp);


        timePicker.setIs24HourView(true);
        hideText.setText(timePicker.getHour()+":"+timePicker.getMinute());
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int minute) {

                tv.setText("Ваш будильник будет установлен на ");
                if(hour<10){
                    hideText.setText("0"+hour+":"+minute);
                    if(minute<10){
                        hideText.setText("0"+hour+":"+"0"+minute);
                    }
                }else if(minute<10){
                    hideText.setText(hour+":"+"0"+minute);
                }else hideText.setText(hour+":"+minute);
            }
        });


        final Button button = view.findViewById(R.id.startbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if(!pressed){

                    backText.setBackgroundColor(getResources().getColor(R.color.buttonPressed));
                    timePicker.setVisibility(View.INVISIBLE);
                    hideText.setVisibility(View.VISIBLE);
                    tv.setText("Ваш будильник установлен на ");
                    button.setBackgroundResource(R.drawable.buttonstylepressed);
                    button.setText("ОТКЛЮЧИТЬ");
                    Intent intent = new Intent(getContext(), AlarmReciever.class);
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.SECOND, 0);
                    calendar.setTimeInMillis(System.currentTimeMillis());
                    calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
                    calendar.set(Calendar.MINUTE, timePicker.getMinute());
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                    alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);

                    pressed = true;
                } else {
                    backText.setBackgroundColor(getResources().getColor(R.color.main));
                    hideText.setVisibility(View.INVISIBLE);
                    tv.setText("Ваш будильник будет установлен на ");
                    timePicker.setVisibility(View.VISIBLE);
                    button.setBackgroundResource(R.drawable.button_style);
                    button.setText("СТАРТ");
                    pressed = false;
                }
            }
        });
    }
}