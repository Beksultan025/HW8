package com.example.hw8;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView tv_Result;
    private Integer firstVar;
    private Integer secondVar;
    private Boolean isOperationClick;
    private String operation;
    private Button share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_Result = findViewById(R.id.tv_result);
        share = findViewById(R.id.btn_Share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                String text = tv_Result.getText().toString();
                intent.putExtra("key1", text);
                startActivity(intent);
            }
        });
    }

    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                setTv_Result("1");
                break;
            case R.id.btn_two:
                setTv_Result("2");
                break;
            case R.id.btn_three:
                setTv_Result("3");
                break;
            case R.id.btn_four:
                setTv_Result("4");
                break;
            case R.id.btn_five:
                setTv_Result("5");
                break;
            case R.id.btn_six:
                setTv_Result("6");
                break;
            case R.id.btn_seven:
                setTv_Result("7");
                break;
            case R.id.btn_eight:
                setTv_Result("8");
                break;
            case R.id.btn_nine:
                setTv_Result("9");
                break;
            case R.id.btn_nol:
                setTv_Result("0");
                break;
            case R.id.btn_clear:
                tv_Result.setText("0");
                firstVar = 0;
                secondVar = 0;
                break;
            case R.id.btn_double:
                setTv_Result(".");
                tv_Result.setText(R.id.tv_result + ".");
                break;
            case R.id.btn_minus:
                setTv_Result("-");
                break;
        }
        share.setVisibility(View.INVISIBLE);
    }

    public void setTv_Result(String numbers) {
        if (tv_Result.getText().toString().equals("0")) {
            tv_Result.setText(numbers);
        } else if (isOperationClick) {
            tv_Result.setText(numbers);
        } else {
            tv_Result.append(numbers);
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        share.setVisibility(View.INVISIBLE);
        switch (view.getId()) {
            case R.id.btn_percent:
                setFirstVar();
                isOperationClick = true;
                operation = "%";
                break;
            case R.id.btn_plus:
                setFirstVar();
                isOperationClick = true;
                operation = "+";
                break;
            case R.id.btn_minus:
                setFirstVar();
                isOperationClick = true;
                operation = "-";
                break;
            case R.id.btn_ymnojit:
                setFirstVar();
                isOperationClick = true;
                operation = "X";
                break;
            case R.id.btn_razdelit:
                setFirstVar();
                isOperationClick = true;
                operation = "/";
                break;
            case R.id.btn_ravno:
                setSecondVar();
                Integer result = 0;
                share.setVisibility(View.VISIBLE);
                switch (operation) {
                    case "%":
                        result = (firstVar / 100);
                        tv_Result.setText(result.toString());
                        break;
                    case "+":
                        result = firstVar + secondVar;
                        tv_Result.setText(result.toString());
                        break;
                    case "-":
                        result = firstVar - secondVar;
                        tv_Result.setText(result.toString());
                        break;
                    case "X":
                        result = firstVar * secondVar;
                        tv_Result.setText(result.toString());
                        break;
                    case "/":
                        result = firstVar / secondVar;
                        tv_Result.setText(result.toString());
                        break;
                }
                break;
        }
    }

    public void setFirstVar() {
        firstVar = Integer.parseInt(tv_Result.getText().toString());
    }

    public void setSecondVar() {
        secondVar = Integer.parseInt(tv_Result.getText().toString());
    }
}