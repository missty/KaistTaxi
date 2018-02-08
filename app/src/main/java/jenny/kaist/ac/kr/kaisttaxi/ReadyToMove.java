package jenny.kaist.ac.kr.kaisttaxi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReadyToMove extends AppCompatActivity {
    private Button btnStart;
    private Button btnBack;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //start service and play music
        startService(new Intent(ReadyToMove.this, SoundServiceReady.class));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ready_to_move);

        btnStart = (Button) findViewById(R.id.start);
        btnBack = (Button) findViewById(R.id.back);
        btnNext = (Button) findViewById(R.id.next);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(ReadyToMove.this, MainActivity.class);
                next.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(next);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadyToMove.this.finish();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(ReadyToMove.this, OnMove.class);
                startActivity(next);
            }
        });
    }

    protected void onPause() {
        stopService(new Intent(ReadyToMove.this, SoundServiceReady.class));
        super.onPause();
    }
    protected void onDestroy() {
        //stop service and stop music
        stopService(new Intent(ReadyToMove.this, SoundServiceReady.class));
        super.onDestroy();
    }
}


/*
        mCheatButton.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        Intent cheat = new Intent(MainActivity.this, CheatActivity.class);
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
        cheat.putExtra(CheatActivity.EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        // startActivity(cheat);
        startActivityForResult(cheat, 0);
        }
        });*/
