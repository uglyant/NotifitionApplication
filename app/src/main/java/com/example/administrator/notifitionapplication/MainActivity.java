package com.example.administrator.notifitionapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button tv_notify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_notify = findViewById(R.id.btn_all_noti);
        tv_notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                setNotifyTion();
            }
        });
    }


    private void setNotifyTion(){
        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        Uri mUri = Settings.System.DEFAULT_NOTIFICATION_URI;
        String id= "my_changel_01";
        String name="我是渠道的名字";
        Notification notification = null;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel mChannel = new NotificationChannel(id,name,NotificationManager.IMPORTANCE_HIGH);
            mChannel.setSound(mUri,Notification.AUDIO_ATTRIBUTES_DEFAULT);
            manager.createNotificationChannel(mChannel);
            notification = new Notification.Builder(this)
                    .setChannelId(id)
                    .setContentTitle("title is this")
                    .setContentText("this is context")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    /*.setPriority(Notification.PRIORITY_HIGH)*/
                    .setOngoing(true)
                    .setAutoCancel(true)
                    .build();

        }else{
           NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                   .setContentText("ffff")
                   .setContentTitle("ffff")
                   .setSmallIcon(R.drawable.ic_launcher_background)
                   .setDefaults(Notification.DEFAULT_SOUND)
                   .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                   .setAutoCancel(true)
                   .setOngoing(true);
            notification =  notificationBuilder.build();

        }

        manager.notify(111111,notification);
    }


}
