package app.com.aula08;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by sala01 on 17/05/2017.
 */

public class AndroidServiceStartOnBoot extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        repeat();

        PendingIntent pintent = PendingIntent.getService(
                this,
                0,
                new Intent(this, AndroidServiceStartOnBoot.class),
                0);

        AlarmManager alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        alarm.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 60*1000, pintent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        repeat();
        return START_STICKY;
    }

    public void repeat(){
        Toast.makeText(
                getApplicationContext(),
                "fui chamado",
                Toast.LENGTH_LONG)
             .show();

        Log.d("mLog", "bla");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}