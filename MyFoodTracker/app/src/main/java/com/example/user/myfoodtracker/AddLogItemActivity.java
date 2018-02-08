package com.example.user.myfoodtracker;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.myfoodtracker.AppDatabase;
import com.example.user.myfoodtracker.LogItem;

public class AddLogItemActivity extends AppCompatActivity {

    private EditText mLogTitleEditText;
    private EditText mLogDateEditText;
    private EditText mLogTimeEditText;
    private EditText mLogBreakfastEditText;
    private EditText mLogLunchEditText;
    private EditText mLogDinnerEditText;
    private EditText mLogExtrasEditText;
    private Button mAddBtn;
    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_log);

        //init
        mLogTitleEditText = (EditText)findViewById(R.id.logTitle);
        mLogDateEditText = (EditText)findViewById(R.id.logDate);
        mLogTimeEditText = (EditText)findViewById(R.id.logTime);
        mLogBreakfastEditText = (EditText)findViewById(R.id.logBreakfast);
        mLogLunchEditText = (EditText)findViewById(R.id.logLunch);
        mLogDinnerEditText = (EditText)findViewById(R.id.logDinner);
        mLogExtrasEditText = (EditText)findViewById(R.id.logExtras)
        mAddBtn = (Button)findViewById(R.id.addNewLogButton);

        //listen to add button click
        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call the save person method
                saveLogItem();
            }
        });

    }

    private void saveLogItem(){
        String title = mLogTitleEditText.getText().toString().trim();
        String date= mLogDateEditText.getText().toString().trim();
        String time = mLogTimeEditText.getText().toString().trim();
        String breakfast = mLogBreakfastEditText.getText().toString().trim();
        String lunch = mLogLunchEditText.getText().toString().trim();
        String dinner = mLogDinnerEditText.getText().toString().trim();
        String extras = mLogExtrasEditText.getText().toString().trim();

        if(title.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter a title", Toast.LENGTH_SHORT).show();
        }

        if(date.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter a date", Toast.LENGTH_SHORT).show();
        }

        if(time.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter a time", Toast.LENGTH_SHORT).show();
        }

        LogItem newLog = new LogItem(title, date, time, breakfast, lunch, dinner, extras);
        appDatabase.getLogItemDao().insertLogItem(newLog);

        goBackHome();

    }

    private void goBackHome(){
        startActivity(new Intent(AddLogItemActivity.this, LogsActivity.class));
    }
}