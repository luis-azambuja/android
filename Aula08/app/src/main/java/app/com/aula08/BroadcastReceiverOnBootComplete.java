package app.com.aula08;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by sala01 on 17/05/2017.
 */

public class BroadcastReceiverOnBootComplete extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equalsIgnoreCase(Intent.ACTION_BOOT_COMPLETED))
            context.startService(new Intent(context, AndroidServiceStartOnBoot.class));
    }
}
