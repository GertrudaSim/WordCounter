package com.example.wordcounter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText txtInput;
    private Spinner spinner;
    private Button btnCount;
    private TextView txtResult;
    private CounterHelper counterHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Susiejame elementus su XML vaizdu
        txtInput = findViewById(R.id.txtInput);
        spinner = findViewById(R.id.spinner);
        btnCount = findViewById(R.id.btnCount);
        txtResult = findViewById(R.id.txtResult);

        // Inicializuojame pagalbinę klasę
        counterHelper = new CounterHelper();

        // Mygtuko paspaudimo įvykio apdorojimas
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = txtInput.getText().toString();

                // Patikriname, ar įvesties laukas tuščias
                if (TextUtils.isEmpty(inputText)) {
                    Toast.makeText(MainActivity.this, "Please enter some text", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Pasirenkame, ką skaičiuoti
                String selectedOption = spinner.getSelectedItem().toString();
                int result;

                if (selectedOption.equals("Words")) {
                    result = counterHelper.countWords(inputText);
                } else {
                    result = counterHelper.countCharacters(inputText);
                }

                // Rezultato rodymas
                txtResult.setText(String.format(getString(R.string.result_text), result ));
            }
        });
    }
}
