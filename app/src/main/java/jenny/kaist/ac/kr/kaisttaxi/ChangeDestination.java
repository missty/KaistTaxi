package jenny.kaist.ac.kr.kaisttaxi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ChangeDestination extends AppCompatActivity {
    private Button btnStart;
    private Button btnBack;
    private Button btnNext;
    private Button btnCancel;
    private Button btnChange;
    private EditText destination;
    private String changeto = "카이스트후문";
    private ImageView changeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_destination);

        btnStart = (Button) findViewById(R.id.start);
        btnBack = (Button) findViewById(R.id.back);
        btnNext = (Button) findViewById(R.id.next);
        btnCancel = (Button) findViewById(R.id.cancel);
        btnChange = (Button) findViewById(R.id.change);
        destination = (EditText) findViewById(R.id.enter_destination);
        changeImage = (ImageView) findViewById(R.id.map);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(ChangeDestination.this, MainActivity.class);
                next.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(next);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeDestination.this.finish();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeDestination.this.finish();
            }
        });
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(destination.getText().toString().contains(changeto)) {
                Intent next = new Intent(ChangeDestination.this, DestinationChanged.class);
                startActivity(next);
            } else {
                Toast.makeText(ChangeDestination.this, R.string.limit_change, Toast.LENGTH_LONG).show();
            }
            }
        });
/*        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(ChangeDestination.this, DestinationChanged.class);
                startActivity(next);
            }
        });*/

        destination.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().contains(changeto)) {
                    changeImage.setImageResource(R.drawable.destination_2);
                }else{
                    //Toast.makeText(ChangeDestination.this, "Nope", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().contains(changeto)) {
                    changeImage.setBackgroundResource(R.drawable.destination_2);
                }else{

                }
            }
        });
    }
}
