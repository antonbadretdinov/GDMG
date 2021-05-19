package ru.company.gdmg.ui.home;

import android.app.TimePickerDialog;
import android.graphics.Color;
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

    int hourNow;
    int minuteNow;
    int dateNow;
    private boolean pressed = false;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        TextView tvHourNow = view.findViewById(R.id.hour);
//        TextView tvMinuteNow = view.findViewById(R.id.minute);
//
//
//        Date currentDate = new Date();
//        DateFormat timeFormatH = new SimpleDateFormat("HH", Locale.getDefault());
//        DateFormat timeFormatM = new SimpleDateFormat("mm", Locale.getDefault());
//
//
//        String timeH = timeFormatH.format(currentDate);
//        String timeM = timeFormatM.format(currentDate);
//        tvHourNow.setText(timeH);
//        tvMinuteNow.setText(timeM);

        final Button button = view.findViewById(R.id.startbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                TimePickerDialog timePickerDialog = new TimePickerDialog(
//                        MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
//                    @Override
//                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
//                        hour = hourOfDay;
//                        minute = minute;
//                        Calendar calendar = Calendar.getInstance();
//                        calendar.set(0,0,0,hour,minute);
//
//                    }
//                },12,0,false
//                );




                if(!pressed){

                    button.setBackgroundResource(R.drawable.buttonstylepressed);
                    button.setText("ОТКЛЮЧИТЬ");
                    pressed = true;
                } else {
                    button.setBackgroundResource(R.drawable.button_style);
                    button.setText("СТАРТ");
                    pressed = false;
                }
            }
        });
    }
}