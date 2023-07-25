package com.example.myapplication;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class calendar extends AppCompatActivity {
    TextView dateText;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //텍스트뷰 변수에 담기
        dateText = findViewById(R.id.date_text_view);

        //버튼 변수에 담기
        Button datePickerBtn = findViewById(R.id.date_picker_btn);

        //버튼 클릭 이벤트 설정
        datePickerBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //오늘 날짜 (년,월,일) 변수에 담기
                Calendar calendar = Calendar.getInstance();
                int pYear = calendar.get(Calendar.YEAR);
                int pMonth = calendar.get(Calendar.MONTH);
                int pDay = calendar.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener(){
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day)


                            {
                                //1월은 0부터 시작하기 때문에 +1을 해준다
                                month = month + 1;
                                String date = year + "/" + month + "/" + day;
                                dateText.setText(date);
                            }
                        }, pYear, pMonth, pDay);
        datePickerDialog.show();
            }//onClick
        });
    }//onCreate
}//Main


