package com.google.temperature;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;
//hello
public class MainActivity extends AppCompatActivity {

    Button ansbtn,againbtn;
    TextView showans;
    EditText getval;
    RadioButton c2f,f2c;
    Double x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ansbtn=(Button) findViewById(R.id.btnans);
        showans=(TextView) findViewById(R.id.showans);
        getval=(EditText) findViewById(R.id.getval);
        c2f=(RadioButton) findViewById(R.id.C2F);
        f2c=(RadioButton) findViewById(R.id.F2C);
        againbtn=(Button) findViewById(R.id.btnagain);
        ansbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getval.getText().toString().isEmpty()){
                    showans.setText("Please give temperature");
                }
                else{
                    x=Double.parseDouble(String.valueOf(getval.getText()));
                    if(c2f.isChecked()){
                        x=(x*9)/5+32;
                        x=Double.parseDouble(new DecimalFormat("##.###").format(x));
                        showans.setText(String.valueOf(x)+  "Degree F");
                    }
                    else if (f2c.isChecked()){
                        x=(x-32)*5/9;
                        x=Double.parseDouble(new DecimalFormat("##.###").format(x));

                        showans.setText(String.valueOf(x)+  "Degree C");
                    }
                    else {
                        showans.setText("Please select an option !");
                    }

                }
            }
        });
        againbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showans.setText("0.0");
                getval.setText("");
                c2f.setChecked(false);
                f2c.setChecked(false);
            }
        });


    }
}