package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText salary, tax, weekly;
    Button compute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        salary = (EditText)findViewById(R.id.salary);
        tax = (EditText)findViewById(R.id.tax);
        weekly = (EditText)findViewById(R.id.weekly);
        compute = (Button)findViewById(R.id.compute);
        compute.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(!salary.getText().toString().equals("")) {
            double sal = Double.parseDouble(salary.getText().toString());
            double annualSalary = sal*12;
            double taxes;
            if(annualSalary <= 50000) {
                taxes = annualSalary;
            } else if(annualSalary > 50000 && annualSalary <= 70000) {
                taxes = annualSalary * .17;
            } else if (annualSalary > 70000 && annualSalary <= 90000) {
                taxes = annualSalary * .23;
            } else {
                taxes = annualSalary * .27;
            }
            tax.setText(String.format("%.2f",taxes));
            double netAnnual = annualSalary - taxes;
            double biWeekly = netAnnual/26;
            weekly.setText(String.format("%.2f",biWeekly));
        }
        else
            Toast.makeText(getApplicationContext(),"Please enter the salary",Toast.LENGTH_LONG).show();
    }
}