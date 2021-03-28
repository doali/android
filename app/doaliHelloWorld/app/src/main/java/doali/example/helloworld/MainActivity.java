package doali.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.LabeledIntent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.time.Duration;
import java.time.Instant;

public class MainActivity extends AppCompatActivity {

    Instant t1, t2;
    Button startButton;
    Button stopButton;
    long duration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Start button
        startButton = (Button) findViewById(R.id.buttonStart);
        this.startButton.setBackgroundColor(Color.GRAY);
        this.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startButton.setBackgroundColor(Color.GREEN);
                stopButton.setBackgroundColor(Color.GRAY);
                duration = 0;
                t1 = Instant.now();
                ((EditText) findViewById(R.id.labelStart)).setText(t1.toString());
                ((EditText) findViewById(R.id.labelStop)).setText("");
                ((EditText) findViewById(R.id.labelDuration)).setText("" + duration);
            }
        });

        // Stop button
        stopButton = (Button) findViewById(R.id.buttonStop);
        this.stopButton.setBackgroundColor(Color.GRAY);
        this.stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopButton.setBackgroundColor(Color.RED);
                startButton.setBackgroundColor(Color.GRAY);
                t2 = Instant.now();
                ((EditText) findViewById(R.id.labelStop)).setText(t2.toString());
                duration = Duration.between(t1, t2).toMinutes();
                ((EditText) findViewById(R.id.labelDuration)).setText("" + duration + " min");
            }
        });
    }
}