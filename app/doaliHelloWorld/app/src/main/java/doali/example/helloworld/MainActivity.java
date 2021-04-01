llllllllllpackage doali.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;

import java.time.Duration;
import java.time.Instant;

import doali.example.helloworld.dataprovider.DataProvider;

public class MainActivity extends AppCompatActivity {

    Instant t1, t2;
    Button startButton;
    Button stopButton;
    long duration;

    static final String TAG = "BIBI";
    static final DataProvider dp = new DataProvider();

    static public Info save(final String start, final String stop, final long duration) {
        Info info;
        info = new Info();
        info.setStart(start);
        info.setStop(stop);
        info.setDuration(duration);

        return info;
    }

    static public ContentValues createValuesforDB(Info info) {
        ContentValues values = new ContentValues();
        values.put("DATE", Instant.now().toString());
        values.put("APP", MainActivity.TAG);
        values.put("INFO", info.toString());

        return values;
    }

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
                ((EditText) findViewById(R.id.labelDuration)).setText("" + duration + " min");
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
                Info info = save(t1.toString(), t2.toString(), duration);
//                ContentValues values = createValuesforDB(info);
//                if (dp.onCreate()) {
//                    Context myContext = this.getApplicationContext();
//                    myContext.insert(DataProvider.CONTENT_URI, values);
//                }
            }
        });
    }
}