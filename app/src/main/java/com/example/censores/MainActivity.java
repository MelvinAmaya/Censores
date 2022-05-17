package com.example.censores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public TextView text;
    public Button boton,vibrrar,vibrar2,vibrar3,compartir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.txtre);
        boton = (Button) findViewById(R.id.btnCen);
        vibrrar = (Button) findViewById(R.id.btnvir);
        vibrar2 = (Button) findViewById(R.id.btnvir2);
        vibrar3 = (Button) findViewById(R.id.brnvir3);
        compartir = (Button) findViewById(R.id.btncom);

        compartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT,"http://codepath.com");
                startActivity(Intent.createChooser(share,"Share link using"));
            }
        });


        Vibrator vibrar = (Vibrator)getSystemService(VIBRATOR_SERVICE);

        vibrrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               vibrar.vibrate(500);
            }
        });

        vibrar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long[] pattern = {0,100,1000};
                vibrar.vibrate(pattern,0);
            }
        });

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              SensorManager sensorrj = (SensorManager) getSystemService(SENSOR_SERVICE);
                List<Sensor>lisa = sensorrj.getSensorList(Sensor.TYPE_ALL);
                boton.setVisibility(View.INVISIBLE);
                text.setText("");
                for(Sensor sensor: lisa){
                    text.append("\n"+sensor.getName()+"\n");
                }
            }
        });
    }
}