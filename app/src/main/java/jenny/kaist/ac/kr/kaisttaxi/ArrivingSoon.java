package jenny.kaist.ac.kr.kaisttaxi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ArrivingSoon extends AppCompatActivity {
    private Button btnStart;
    private Button btnBack;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //start service and play music
        startService(new Intent(ArrivingSoon.this, SoundServiceSoon.class));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arriving_soon);

        btnStart = (Button) findViewById(R.id.start);
        btnBack = (Button) findViewById(R.id.back);
        btnNext = (Button) findViewById(R.id.next);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(ArrivingSoon.this, MainActivity.class);
                next.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(next);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrivingSoon.this.finish();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(ArrivingSoon.this, GoodBye.class);
                startActivity(next);
            }
        });
    }

    protected void onPause() {
        stopService(new Intent(ArrivingSoon.this, SoundServiceSoon.class));
        super.onPause();
    }
    protected void onDestroy() {
        //stop service and stop music
        stopService(new Intent(ArrivingSoon.this, SoundServiceSoon.class));
        super.onDestroy();
    }
}
