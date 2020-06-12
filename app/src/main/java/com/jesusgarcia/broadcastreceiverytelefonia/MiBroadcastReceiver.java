package com.jesusgarcia.broadcastreceiverytelefonia;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MiBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        final String tel = MainActivity.i.getStringExtra("tel");
        final String msg = MainActivity.i.getStringExtra("msg");

        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Service.TELEPHONY_SERVICE);

        telephonyManager.listen(new PhoneStateListener() {
            @Override
            public void onCallStateChanged(int state, String phoneNumber) {
                super.onCallStateChanged(state, phoneNumber);
                if (state == TelephonyManager.CALL_STATE_RINGING) {
                    if (phoneNumber.equals("+52" + tel)) {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(tel, null, msg, null, null);
                        Toast.makeText(context, "Mensaje enviado.", Toast.LENGTH_LONG).show();
                    } else if (phoneNumber.equals(tel)) {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(tel, null, msg, null, null);
                        Toast.makeText(context, "Mensaje enviado.", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(context, "El numero ingresado: " +
                                tel + "\nes diferente del numero entrante: " +
                                phoneNumber, Toast.LENGTH_LONG).show();
                    }
                }
            }
        }, PhoneStateListener.LISTEN_CALL_STATE);
    }
}
