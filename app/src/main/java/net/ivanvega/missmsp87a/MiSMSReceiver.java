package net.ivanvega.missmsp87a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MiSMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");

        Bundle bundle = intent.getExtras();
        SmsMessage[] smss;
        String str;

        if(bundle != null){
            Object[] opdus = (Object[])bundle.get("pdus");
            smss = new SmsMessage[opdus.length];
            for (int i = 0; i < smss.length; i++) {
                smss [i] = SmsMessage.createFromPdu((byte[])opdus[i]);
                str = "Mensaje de: " + smss [i].getOriginatingAddress() +
                        "\n" +
                        smss [i].getMessageBody().toString();
                Toast.makeText(context, str, Toast.LENGTH_LONG).show();
            }
        }


    }
}
