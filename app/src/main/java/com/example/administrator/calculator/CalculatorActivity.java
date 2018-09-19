package com.example.administrator.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class CalculatorActivity extends AppCompatActivity{

    String temp="",cal="";
    float a,b,result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
    }
    public void numBtnClicked(View view) {
        TextView input = (TextView) findViewById(R.id.input);
        String inputText = input.getText().toString();
        Button c = (Button)view;
        String buttonText = c.getText().toString();
        if(inputText.equals("0")){
            input.setText(buttonText);
        }
        else{
            input.setText(inputText+buttonText);
        }
        temp+=buttonText;
    }
    public void algBtnClicked(View view) {
        TextView input = (TextView) findViewById(R.id.input);
        String inputText = input.getText().toString();
        Button d = (Button)view;
        if(temp.equals("")) {
            showToast();
            acBtnClicked(view);
            return;
        }
        a=Float.valueOf(temp);
        if(!cal.equals("")){
            showToast();
            acBtnClicked(view);
            return;
        }
        temp="";
        cal =d.getText().toString();
        input.setText(inputText+cal);
    }
    public void sumBtnClicked(View view) {
        TextView output = (TextView) findViewById(R.id.output);
        if(temp.equals("")||cal.equals("")) {
            showToast();
            acBtnClicked(view);
            return;
        }
        b=Float.valueOf(temp);
        switch (cal){
            case "+":
                result=a+b;
                break;
            case "-":
                result=a-b;
                break;
            case "*":
                result=a*b;
                break;
            case "/":
                if (b==0){
                    showToast();
                    acBtnClicked(view);
                    return;
                }
                result=a/b;
                break;
        }
        output.setText(""+result);
        acBtnClicked(view);
    }
    public void acBtnClicked(View view) {
        TextView input = (TextView) findViewById(R.id.input);
        temp="";
        cal="";
        input.setText("0");
    }
    public void showToast(){
        Toast.makeText(getApplicationContext(), "please enter correctly！",
                Toast.LENGTH_SHORT).show();
    }
}




