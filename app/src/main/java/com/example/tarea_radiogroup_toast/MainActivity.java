package com.example.tarea_radiogroup_toast;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private RadioGroup colorRadioGroup;
    private Button select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        colorRadioGroup = findViewById(R.id.colorRadioGroup);
        select = findViewById(R.id.select);

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectId = colorRadioGroup.getCheckedRadioButtonId();

                if (selectId != -1) {
                    RadioButton selectRadioButton = findViewById(selectId);
                    String selectedColor = selectRadioButton.getText().toString();

                    Toast.makeText(MainActivity.this, "El color es: " + selectedColor, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Selecciona un color", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}