package jenny.kaist.ac.kr.kaisttaxi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ChangeDestination2 extends AppCompatActivity {
    private Button btnStart;
    private Button btnBack;
    private Button btnNext;
    private Button btnCancel;
    private Button btnChange;
    private EditText destination;
    private TextView txtInstruction1;
    private TextView txtInstruction2;
    private String changeto = "카이스트후문";
    private ImageView changeImage;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        startService(new Intent(ChangeDestination2.this, SoundServiceWhereTo.class));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_destination2);

        btnStart = (Button) findViewById(R.id.start);
        btnBack = (Button) findViewById(R.id.back);
        btnNext = (Button) findViewById(R.id.next);
        changeImage = (ImageView) findViewById(R.id.recognition);
        txtInstruction1 = (TextView) findViewById(R.id.instruction);
        txtInstruction2 = (TextView) findViewById(R.id.instruction2);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(ChangeDestination2.this, MainActivity.class);
                next.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(next);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i == 0) {
                    stopService(new Intent(ChangeDestination2.this, SoundServiceWhereTo.class));
                    ChangeDestination2.this.finish();
                }else if(i == 1){
                    changeImage.setImageResource(R.drawable.again);
                    txtInstruction1.setText(R.string.sorryagain);
                    txtInstruction2.setText(R.string.sorryagain2);

                    stopService(new Intent(ChangeDestination2.this, SoundServiceWhereTo.class));
                    startService(new Intent(ChangeDestination2.this, SoundServiceSorry.class));
                    i = 0;
                    //Toast.makeText(ChangeDestination.this, "Nope", Toast.LENGTH_LONG).show();
                }
            }
        });
/*        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(destination.getText().toString().contains(changeto)) {
                Intent next = new Intent(ChangeDestination2.this, DestinationChanged.class);
                startActivity(next);
            } else {
                Toast.makeText(ChangeDestination2.this, R.string.limit_change, Toast.LENGTH_LONG).show();
            }
            }
        });*/
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i == 0) {
                    changeImage.setImageResource(R.drawable.scanning);
                    stopService(new Intent(ChangeDestination2.this, SoundServiceWhereTo.class));
                    stopService(new Intent(ChangeDestination2.this, SoundServiceSorry.class));
                    txtInstruction1.setText(R.string.scanning);
                    txtInstruction2.setText("");
                    i++;
                }else if(i == 1){
                    changeImage.setImageResource(R.drawable.done);
                    stopService(new Intent(ChangeDestination2.this, SoundServiceWhereTo.class));
                    stopService(new Intent(ChangeDestination2.this, SoundServiceSorry.class));
                    txtInstruction1.setText(R.string.scanned);
                    txtInstruction2.setText("");
                    i = 0;
                    Intent next = new Intent(ChangeDestination2.this, DestinationChanged.class);
                    startActivity(next);
                    //Toast.makeText(ChangeDestination.this, "Nope", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    protected void onPause() {
        stopService(new Intent(ChangeDestination2.this, SoundServiceWhereTo.class));
        stopService(new Intent(ChangeDestination2.this, SoundServiceSorry.class));
        super.onPause();
    }
    protected void onDestroy() {
        //stop service and stop music
        stopService(new Intent(ChangeDestination2.this, SoundServiceWhereTo.class));
        stopService(new Intent(ChangeDestination2.this, SoundServiceSorry.class));
        super.onDestroy();
    }
}
