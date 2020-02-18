package net.ivanvega.missmsp87a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txtTek, txtMes;
    MiSMSReceiver miSMSReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTek = findViewById(R.id.txtTel);
        txtMes = findViewById(R.id.txtText);

        IntentFilter intentFilter = new IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION);

        miSMSReceiver = new MiSMSReceiver();


        registerReceiver(miSMSReceiver, intentFilter);


    }

    public void btnSend_click(View view) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(txtTek.getText().toString(),
                null, txtMes.getText().toString(),
                null, null );



    }
}
