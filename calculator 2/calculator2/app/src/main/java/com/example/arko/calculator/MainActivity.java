package com.example.arko.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnaddclick(View v){
        TextView lblans = (TextView) findViewById(R.id.lblans);
        EditText txtnum1 = (EditText) findViewById(R.id.txtnum1);
        EditText txtnum2 = (EditText) findViewById(R.id.txtnum2);
        double num1 = 0.0;
        double num2 = 0.0;
        double ans = 0.0;
        num1 = Double.valueOf(txtnum1.getText().toString());
        num2 = Double.valueOf(txtnum2.getText().toString());
        ans = num1 + num2;
        lblans.setText(String.valueOf(ans));
    }

    public void btnsubtractclick(View v){
        TextView lblans = (TextView) findViewById(R.id.lblans);
        EditText txtnum1 = (EditText) findViewById(R.id.txtnum1);
        EditText txtnum2 = (EditText) findViewById(R.id.txtnum2);
        double num1 = 0.0;
        double num2 = 0.0;
        double ans = 0.0;
        num1 = Double.valueOf(txtnum1.getText().toString());
        num2 = Double.valueOf(txtnum2.getText().toString());
        ans = num1 - num2;
        lblans.setText(String.valueOf(ans));
    }

    public void btnmultiplyclick(View v){
        TextView lblans = (TextView) findViewById(R.id.lblans);
        EditText txtnum1 = (EditText) findViewById(R.id.txtnum1);
        EditText txtnum2 = (EditText) findViewById(R.id.txtnum2);
        double num1 = 0.0;
        double num2 = 0.0;
        double ans = 0.0;
        num1 = Double.valueOf(txtnum1.getText().toString());
        num2 = Double.valueOf(txtnum2.getText().toString());
        ans = num1 * num2;
        lblans.setText(String.valueOf(ans));
    }

    public void btndivideclick(View v){
        TextView lblans = (TextView) findViewById(R.id.lblans);
        EditText txtnum1 = (EditText) findViewById(R.id.txtnum1);
        EditText txtnum2 = (EditText) findViewById(R.id.txtnum2);
        double num1 = 0.0;
        double num2 = 0.0;
        double ans = 0.0;
        num1 = Double.valueOf(txtnum1.getText().toString());
        num2 = Double.valueOf(txtnum2.getText().toString());
        ans = num1 / num2;
        lblans.setText(String.valueOf(ans));
    }

    public void btnclearclock(View v){
        TextView lblans = (TextView) findViewById(R.id.lblans);
        EditText txtnum1 = (EditText) findViewById(R.id.txtnum1);
        EditText txtnum2 = (EditText) findViewById(R.id.txtnum2);
        txtnum1.setText("");
        txtnum2.setText("");
        lblans.setText("Answer");
    }

    public void btnpowerclick(View v){
        TextView lblans = (TextView) findViewById(R.id.lblans);
        EditText txtnum1 = (EditText) findViewById(R.id.txtnum1);
        EditText txtnum2 = (EditText) findViewById(R.id.txtnum2);
        double num1 = 0.0;
        double num2 = 0.0;
        double ans = 0.0;
        num1 = Double.valueOf(txtnum1.getText().toString());
        num2 = Double.valueOf(txtnum2.getText().toString());
        ans = Math.pow(num1,num2);
        lblans.setText(String.valueOf(ans));
    }

    public void topfact(View v){
        TextView lblans = (TextView) findViewById(R.id.lblans);
        EditText txtnum1 = (EditText) findViewById(R.id.txtnum1);
        double num1 = 0.0;
        double ans = 1.0;
        num1 = Double.valueOf(txtnum1.getText().toString());
        for(int i = 1;i<=num1;i++){
            ans *= i;
        }
        lblans.setText(String.valueOf(ans));
    }

    public void botfact(View v){
        TextView lblans = (TextView) findViewById(R.id.lblans);
        EditText txtnum2 = (EditText) findViewById(R.id.txtnum2);
        double num2 = 0.0;
        double ans = 1.0;
        num2 = Double.valueOf(txtnum2.getText().toString());
        for(int i = 1;i<=num2;i++){
            ans *= i;
        }
        lblans.setText(String.valueOf(ans));
    }
}
