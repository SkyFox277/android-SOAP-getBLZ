package com.example.i.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class hw extends Activity {

    private TextView txt;
    private String celsius;
    private Details details = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw);

        final EditText edt = (EditText)findViewById(R.id.value_to_convert);
        Button btn = (Button)findViewById(R.id.convert);
        txt = (TextView)findViewById(R.id.answer);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt.length() == 8) {
                    getCelsius(edt.getText().toString());
                } else {
                    txt.setText("Bitte eine BLZ mit 8 Zeichen eingeben (z.B. 37070024).");
                }
            }
        });

    }


    public Handler handler = new Handler(new Handler.Callback() {

        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {

                case 0:
                    if (details != null) {
                        //txt.setText(celsius);
                        String tmp = details.getProperty(0).toString() + "; " + details.getProperty(1).toString() + "; " + details.getProperty(2).toString() + "; " + details.getProperty(3).toString();
                        txt.setText(tmp);
                    }
                    break;
            }
            return false;
        }
    });

    private final void getCelsius(final String toConvert) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                SoapRequests ex = new SoapRequests();

                details = (Details)ex.getCelsiusConversion(toConvert);

                handler.sendEmptyMessage(0);
            }
        }).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hw, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void testButtonOnClick(View V){

    }
}
