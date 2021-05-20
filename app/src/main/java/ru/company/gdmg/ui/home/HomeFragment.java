package ru.company.gdmg.ui.home;

import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import ru.company.gdmg.MainActivity;
import ru.company.gdmg.R;

public class HomeFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        return root;
    }

    private boolean pressed = false;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int hour;
        int minute;
        int date;
        final TextView tv = view.findViewById(R.id.textView9);
        final TimePicker timePicker = view.findViewById(R.id.tp);
        timePicker.setIs24HourView(true);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int minute) {

                tv.setText("Ваш будильник будет установлен на "+hour+" : "+minute);
            }
        });

        final Button button = view.findViewById(R.id.startbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {


                if(!pressed){
                    tv.setText("Ваш будильник установлен на " +timePicker.getHour()+" : "+timePicker.getMinute());
                    timePicker.setVisibility(View.INVISIBLE);
                    button.setBackgroundResource(R.drawable.buttonstylepressed);
                    button.setText("ОТКЛЮЧИТЬ");
                    pressed = true;
                } else {
                    timePicker.setVisibility(View.VISIBLE);
                    button.setBackgroundResource(R.drawable.button_style);
                    button.setText("СТАРТ");
                    pressed = false;
                }
            }
        });
    }
}