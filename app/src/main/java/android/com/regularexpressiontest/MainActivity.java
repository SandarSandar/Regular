package android.com.regularexpressiontest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText)findViewById(R.id.txtInput);
        Button btnSave = (Button)findViewById(R.id.btnSave);

        text.setMaxLines(Integer.MAX_VALUE);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()) {
                    Toast.makeText(MainActivity.this,"save",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private boolean isValid(){

        String patt="((?!00)[0-9]{2})";
        if(text.getText().toString().trim().equals("")){
            Toast.makeText(this,"Enter age",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!text.getText().toString().trim().matches(patt)){
            Toast.makeText(this,"Invalid age",Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
