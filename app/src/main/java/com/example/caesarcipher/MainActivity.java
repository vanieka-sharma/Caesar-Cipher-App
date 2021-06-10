package com.example.caesarcipher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.caesarcipher.Utility.decryptU;
import static com.example.caesarcipher.Utility.encryptU;

public class MainActivity extends AppCompatActivity {

    private Button encrypt, decrypt;
    private EditText message,cipher,key;
    private TextView screenOutput;

    private static final String alphaString="abcdefghijklmnopqrstuvwxyz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        encrypt  = findViewById(R.id.encrypt_btn);
        decrypt = findViewById(R.id.decrypt_btn);
        screenOutput = findViewById(R.id.tv1);

        message = findViewById(R.id.inputMessage);
        cipher   = findViewById(R.id.cipher);
        key = findViewById(R.id.keyDt);

        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                encrypt12(message.getText().toString(),Integer.parseInt(key.getText().toString()));
            }
        });
        decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrypt12(cipher.getText().toString(),Integer.parseInt(key.getText().toString()));
            }
        });
    }
    public void decrypt12(String cipher,int key){
        screenOutput.setText(Utility.decryptU(cipher,key).toLowerCase());
    }
    public String encrypt12(String message, int shiftKey){
        message = message.toLowerCase();
        String cipherText = "";
        for(int i = 0; i < message.length(); i++){
            int charPosition = alphaString.indexOf(message.charAt(i));
            int keyVal = (shiftKey + charPosition)%26;
            char replaceVal = alphaString.charAt(keyVal);
            cipherText+=replaceVal;
            screenOutput.setText(cipherText);
            cipher.setText(cipherText);
        }
        return cipherText;
    }
}