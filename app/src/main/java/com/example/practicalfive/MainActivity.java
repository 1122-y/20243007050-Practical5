package com.example.practicalfive;

import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    /** Intent extra key shared with {@link Municipality}. */
    public static final String EXTRA_MUNICIPALITY = "municipality_name";

    private EditText municipalityInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        municipalityInput = findViewById(R.id.municipalityInput);

        // Trigger validation when the user presses the Go action on the keyboard.
        municipalityInput.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_GO) {
                submitInput();
                return true;
            }
            return false;
        });
    }

    private void submitInput() {
        String raw = municipalityInput.getText().toString();
        String result = TextProcessor.processMunicipality(raw);

        if (result == null) {
            boolean empty = raw == null || raw.trim().isEmpty();
            municipalityInput.setError(
                    getString(empty ? R.string.error_empty : R.string.error_invalid));
            return;
        }

        Intent intent = new Intent(this, Municipality.class);
        intent.putExtra(EXTRA_MUNICIPALITY, result);
        startActivity(intent);
    }
}
