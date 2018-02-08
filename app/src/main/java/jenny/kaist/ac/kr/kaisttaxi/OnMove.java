package jenny.kaist.ac.kr.kaisttaxi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class OnMove extends AppCompatActivity {
    private Button btnStart;
    private Button btnBack;
    private Button btnNext;

    private Button btnForce;
    private Button btnChange;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //start service and play music
        startService(new Intent(OnMove.this, SoundServiceOnMove.class));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.on_move);

        btnStart = (Button) findViewById(R.id.start);
        btnForce = (Button) findViewById(R.id.force);
        btnBack = (Button) findViewById(R.id.back);
        btnNext = (Button) findViewById(R.id.next);
        //btnChange = (Button) findViewById(R.id.change);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(OnMove.this, MainActivity.class);
                next.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(next);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnMove.this.finish();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(OnMove.this, ChangeDestination2.class);
                startActivity(next);
            }
        });
        btnForce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(OnMove.this, ForceChange.class);
                startActivity(next);
            }
        });
/*        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent change = new Intent(OnMove.this, ChangeDestination.class);
                startActivity(change);
            }
        });*/
    }
    protected void onPause() {
        stopService(new Intent(OnMove.this, SoundServiceOnMove.class));
        super.onPause();
    }
    protected void onDestroy() {
        //stop service and stop music
        stopService(new Intent(OnMove.this, SoundServiceOnMove.class));
        super.onDestroy();
    }
}
