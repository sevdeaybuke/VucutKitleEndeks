package com.sevdeaybuke.vucutkitleindeks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText e1 = (EditText) findViewById(R.id.e1);
        final EditText e2 = (EditText) findViewById(R.id.e2);
        final TextView tv_results_bmi = (TextView) findViewById(R.id.tv_results_bmi);
        final TextView tv4 = (TextView) findViewById(R.id.tv4);
        findViewById(R.id.ib1).setOnClickListener(new View.OnClickListener() {

            // Logic for validation, input can't be empty
            @Override
            public void onClick(View v) {

                String str1 = e1.getText().toString();
                String str2 = e2.getText().toString();

                if(TextUtils.isEmpty(str1)){
                    e1.setError("Lütfen Kilonuzu Giriniz");
                    e1.requestFocus();
                    return;
                }

                if(TextUtils.isEmpty(str2)){
                    e2.setError("Lütfen Boyunuzu Giriniz");
                    e2.requestFocus();
                    return;
                }

                float weight = Float.parseFloat(str1);
                float height = Float.parseFloat(str2)/100;
                float bmiValue = calculateBMI(weight, height);

                String bmiInterpretation = interpretBMI(bmiValue);

                tv_results_bmi.setText(String.valueOf(bmiValue));
                tv4.setText(String.valueOf(bmiInterpretation));
            }
        });

    }

    private float calculateBMI (float weight, float height) {
        return (float) (weight / (height * height));
    }

    private String interpretBMI(float bmiValue) {

        if (bmiValue < 16) {
            return "Çok Zayıf";
        } else if (bmiValue < 18.5) {

            return "Zayıf";
        } else if (bmiValue < 25) {

            return "Normal";
        } else if (bmiValue < 30) {

            return "Fazla";
        } else {
            return "Obez";
        }
    }

}
