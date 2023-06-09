package com.example.mission4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    Button sendButton;
    EditText smsInput;
    TextView byteView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendButton = (Button) findViewById(R.id.send);
        smsInput = (EditText) findViewById(R.id.smsInput);
        byteView = (TextView) findViewById(R.id.byteView);

        smsInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                bytesCounter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void onSendButtonClicked(View v) {
        String message = smsInput.getText().toString();
        showToast(message);
    }

    public void showToast(String str) {
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
    }

    public void bytesCounter(CharSequence s) {
        byteView.setText("" + s.toString().getBytes().length + " / 80 바이트");
    }
}