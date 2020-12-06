package com.nilson.apptres;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Workmanagernot extends Worker {





    public Workmanagernot(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }


    public static void guardarnoti(long duracion, Data data, String tag){

        OneTimeWorkRequest noti = new OneTimeWorkRequest.Builder(Workmanagernot.class).setInitialDelay(duracion, TimeUnit.MILLISECONDS).addTag(tag).setInputData(data).build();
        WorkManager intence = WorkManager.getInstance();
        intence.enqueue(noti);

    }


    @NonNull
    @Override
    public Result doWork() {

        String titulo = getInputData().getString("Titulo");
        String detalle = getInputData().getString("Detalle");

        int id = (int) getInputData().getLong("id",0);

        oreo(titulo,detalle);

        return  Result.success();
    }

    private void oreo(String t, String d){

        String id = "message";
        NotificationManager nm = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),id);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            NotificationChannel nc = new NotificationChannel(id,"nuevo",NotificationManager.IMPORTANCE_HIGH);
            nc.setDescription("Notificacion FCM");
            nc.setShowBadge(true);
            assert nm != null;
            nm.createNotificationChannel(nc);

        }

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);


        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0,intent,PendingIntent.FLAG_ONE_SHOT);

        builder.setAutoCancel(true).setWhen(System.currentTimeMillis()).setContentTitle(t).setTicker("Nueva notificacion").setSmallIcon(R.mipmap.ic_launcher).setContentText(d).setContentIntent(pendingIntent).setContentInfo("nuevo");

        Random random = new Random();
        int idnote = random.nextInt(8000);
        assert  nm != null;
        nm.notify(idnote,builder.build());

    }




}
