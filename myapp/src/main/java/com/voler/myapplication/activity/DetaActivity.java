package com.voler.myapplication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.voler.myapplication.R;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 妈妈生活圈
 * 三尺春光驱我寒，一生戎马为长安 -- 韩经录
 * Created by voler on 2016/8/26.
 */
public class DetaActivity extends AppCompatActivity {
    @Bind(R.id.datePicker)
    DatePicker datePicker;
    @Bind(R.id.dateEt)
    EditText dateEt;
    @Bind(R.id.timePicker)
    TimePicker timePicker;
    @Bind(R.id.timeEt)
    EditText timeEt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        ButterKnife.bind(this);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int monthOfYear = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        datePicker.init(year, monthOfYear, dayOfMonth, new DatePicker.OnDateChangedListener() {

            public void onDateChanged(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                dateEt.setText("您选择的日期是：" + year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日。");
            }

        });

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                timeEt.setText("您选择的时间是：" + hourOfDay + "时" + minute + "分。");
            }

        });

    }

}
