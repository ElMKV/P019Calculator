package com.example.p019calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final int MENU_RESET_ID = 1;
    final int MENU_QUIT_ID = 2;

    EditText etNum1;
    EditText etNum2;

    Button btmAdd;
    Button btmSub;
    Button btmMult;
    Button btmDiv;

    TextView tvResult;

    String oper = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNum1 = (EditText) findViewById(R.id.editTextTextNum1);
        etNum2 = (EditText) findViewById(R.id.editTextTextNum2);

        btmAdd = (Button) findViewById(R.id.buttonPlus);
        btmSub = (Button) findViewById(R.id.buttonMinues);
        btmMult = (Button) findViewById(R.id.buttonDuplicate);
        btmDiv = (Button) findViewById(R.id.buttonDelimer);

        tvResult = (TextView) findViewById(R.id.textNumber);

        btmAdd.setOnClickListener(this);
        btmDiv.setOnClickListener(this);
        btmMult.setOnClickListener(this);
        btmSub.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_RESET_ID, 0, "Reset");
        menu.add(0, MENU_QUIT_ID, 0, "Quit");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case MENU_RESET_ID:
                etNum1.setText("");
                etNum2.setText("");
                tvResult.setText("");
                break;
            case MENU_QUIT_ID:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        float num1 = 0;
        float num2 = 0;
        float numResult = 0;

        if (etNum1.getText().toString().isEmpty() || etNum2.getText().toString().isEmpty()) {
            tvResult.setText("Введите число");
            return;
        }
        num1 = Float.parseFloat(etNum1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());

        switch (view.getId()) {
            case R.id.buttonPlus: {
                oper = " + ";
                numResult = num1 + num2;
                tvResult.setText(num1 + oper + num2 + " = " + numResult);
                break;

            }
            case R.id.buttonMinues: {
                oper = " - ";
                numResult = num1 - num2;
                tvResult.setText(num1 + oper + num2 + " = " + numResult);
                break;

            }
            case R.id.buttonDuplicate: {
                oper = " * ";
                numResult = num1 * num2;
                tvResult.setText(num1 + oper + num2 + " = " + numResult);
                break;

            }
            case R.id.buttonDelimer: {
                oper = " / ";
                numResult = num1 / num2;
                tvResult.setText(num1 + oper + num2 + " = " + numResult);
                break;

            }

        }


    }
}