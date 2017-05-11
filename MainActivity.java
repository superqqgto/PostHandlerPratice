package com.example.yanchen.posthandlerpratice;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private int i = 0;

    private TextView tv;

    private Handler handler = new Handler(){

        public void handleMessage(android.os.Message msg) {

            switch (msg.what) {

                case 1:

                    update();

                    break;

                default:

                    break;

            }

        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new MyTask(), 1, 1000*2);
    }

    private class MyTask extends TimerTask {

        @Override

        public void run() {

// TODO Auto-generated method stub

            Message message = new Message();

            message.what = 1;

            handler.sendMessage(message);

        }

    }

    private void update() {

// TODO Auto-generated method stub

        tv.setText(i+"");

        i++;

    }

}
