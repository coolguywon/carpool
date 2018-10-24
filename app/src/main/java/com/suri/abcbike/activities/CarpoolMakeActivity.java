package com.suri.abcbike.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.suri.abcbike.R;

import java.util.Calendar;
import java.util.Date;

public class CarpoolMakeActivity extends AppCompatActivity {
    Activity thisActivity;
    //ui 참조
    TextView mHourText;
    TextView mMinuteText;
    TextView mStartText;
    TextView mEndText;
    TextView mMaxPersonText;
    Button   mEnrollButton;

    //데이터 연결
    int hour;
    int minute;
    String start;
    String end;
    int max;
    Date startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carpool_make);

        thisActivity=this;

        //ui 연결
        mHourText=(TextView)findViewById(R.id.make_carpool_hour);
        mMinuteText=(TextView)findViewById(R.id.make_carpool_minute);
        mStartText=(TextView)findViewById(R.id.make_carpool_start);
        mEndText=(TextView)findViewById(R.id.make_carpool_end);
        mMaxPersonText=(TextView)findViewById(R.id.make_carpool_max);
        mEnrollButton=(Button)findViewById(R.id.addcarpool_button);

        mEnrollButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                //데이터 추출
                hour=   Integer.parseInt(mHourText.getText().toString());
                minute= Integer.parseInt(mMinuteText.getText().toString());

                start=  mStartText.getText().toString();
                end=    mEndText.getText().toString();
                max=   Integer.parseInt(mMaxPersonText.getText().toString());
                Calendar c= Calendar.getInstance();
                c.set(Calendar.YEAR,Calendar.MONTH,Calendar.DATE,hour,minute,0);
                startTime=c.getTime();
                //리스트뷰 추가
                MainActivity.addItem(new ListviewItem( startTime,start,end,MainActivity.myName,1,max));
                thisActivity.finish();
            }
        });
    }
}
