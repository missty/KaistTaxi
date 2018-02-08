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

public class ForceChange extends AppCompatActivity {
    private Button btnStart;
    private Button btnBack;
    private Button btnNext;
    private Button btnCancel;
    private Button btnChange;
    private EditText destination;
    private TextView txtInstruction1;
    private ImageView changeImage;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.force_change);

        btnStart = (Button) findViewById(R.id.start);
        btnBack = (Button) findViewById(R.id.back);
        btnNext = (Button) findViewById(R.id.next);
        txtInstruction1 = (TextView) findViewById(R.id.instruction);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(ForceChange.this, MainActivity.class);
                next.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(next);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    ForceChange.this.finish();
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
                    Intent next = new Intent(ForceChange.this, DestinationChanged.class);
                    startActivity(next);
                    //Toast.makeText(ChangeDestination.this, "Nope", Toast.LENGTH_LONG).show();

            }
        });
    }

}
