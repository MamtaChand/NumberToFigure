package com.s.numbertofigure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtNumber;
    TextView numberInFigure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumber = findViewById(R.id.txtNumber);
        numberInFigure = findViewById(R.id.numberInFigure);

        TextWatcher fieldValidatorTextWatcher = new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (filterLongEnough()) {
                    int number = Integer.parseInt(txtNumber.getText().toString());
                    numberInFigure.setText(Figure.convert(number));
                } else {
                    numberInFigure.setText("");
                }
            }

            private boolean filterLongEnough() {
                return txtNumber.getText().toString().trim().length() > 0;
            }
        };
        txtNumber.addTextChangedListener(fieldValidatorTextWatcher);
    }
}