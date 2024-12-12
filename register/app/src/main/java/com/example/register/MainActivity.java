package com.example.register;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button confirm;
    private EditText email;
    private EditText haslo;
    private EditText powtorzhaslo;
    private TextView komunikat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        confirm = findViewById(R.id.przycisk);
        email = findViewById(R.id.Email);
        haslo = findViewById(R.id.password);
        powtorzhaslo = findViewById(R.id.powtorzpassword);
        komunikat = findViewById(R.id.komunikaty);


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String input_email = email.getText().toString().trim();
                String input_haslo = haslo.getText().toString().trim();
                String input_powtorzhaslo = powtorzhaslo.getText().toString().trim();

                if (input_email.isEmpty()) {
                    komunikat.setText("Wypelnij pole E-mail");
                    return;
                }
                if (input_haslo.isEmpty()) {
                    komunikat.setText("Wypelnij pole Haslo");
                    return;
                }
                if (input_powtorzhaslo.isEmpty()) {
                    komunikat.setText("Wypelnij pole Powtorz haslo");
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(input_email).matches()) {
                    komunikat.setText("Email jest nie poprawny");
                    return;
                }

                if (!input_powtorzhaslo.equals(input_haslo)) {
                    komunikat.setText("Haslo musi byc identyczne");
                    return;
                }

                if (!input_email.isEmpty() && !input_haslo.isEmpty() && !input_powtorzhaslo.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(input_email).matches() && input_powtorzhaslo.equals(input_haslo)) {
                    komunikat.setText("Witaj " + input_email);
                }
            }
        });
    }
}