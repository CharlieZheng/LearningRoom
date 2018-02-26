package com.cgf.learningroom;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.cgf.learningroom.db.AppDatabase;
import com.cgf.learningroom.pojo.User;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    private static class MyHandler extends Handler {
        private WeakReference<MainActivity> ref;

        private MyHandler(MainActivity activity) {
            ref = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {

            if (msg.obj instanceof StringBuffer) {
                StringBuffer stringBuffer = (StringBuffer) msg.obj;
                ((TextView) ref.get().findViewById(R.id.text)).setText(stringBuffer);
            }
        }
    }

    private MyHandler handle = new MyHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final User user = new User();
                user.firstName = "Charlie";
                user.lastName = "Zheng";
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        db.userDao().insertUsers(user);

                    }
                }).start();
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        User[] userArray = db.userDao().loadAllUsers();
                        StringBuffer stringBuffer = new StringBuffer();
                        for (User user : userArray) {
                            stringBuffer.append(user.firstName);
                            stringBuffer.append(" ");
                            stringBuffer.append(user.lastName);
                        }
                        Message message = new Message();
                        message.obj = stringBuffer;
                        handle.sendMessage(message);
                    }
                }).start();


            }
        });
    }
}
