package com.example.examenpmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//Cronometro


public class MainActivity extends AppCompatActivity {

    TextView contador;
    Button play;
    BigInteger cont = BigInteger.ZERO;

    int incremento = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play= (Button) findViewById(R.id.play);
        contador = (TextView) findViewById(R.id.textcontador);
        contador.setText("" + cont);

    }

    public String añadeTexto() {
        String text = " ";
        if (cont.compareTo(BigInteger.valueOf(1000)) >= 0) {
            BigInteger mil = BigInteger.valueOf(1000);
            BigInteger cantidad = cont.divide(mil);
            text = cantidad + " K";
        }
        if (cont.compareTo(new BigInteger("1000000")) >= 0 && cont.compareTo(new BigInteger("99999999999")) <= 0) {     // Si no
            BigInteger Mill = new BigInteger("1000000");
            BigInteger cantidad_2 = cont.divide(Mill);
            text = cantidad_2 + " Mill";
        }
        if (cont.compareTo(new BigInteger("1000000000000")) >= 0) {
            BigInteger Bill = new BigInteger("1000000000000");
            BigInteger cantidad_3 = cont.divide(Bill);
            text = cantidad_3 + " Bill";

        } else {
            text = cont.toString();
        }
        contador.setText(text);
        return text;
    }

    public void segundero(View view) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                cont = cont.add(BigInteger.valueOf(incremento));

                handler.post(() -> {
                    contador.setText(añadeTexto());
                });
            }
        });
    }

}