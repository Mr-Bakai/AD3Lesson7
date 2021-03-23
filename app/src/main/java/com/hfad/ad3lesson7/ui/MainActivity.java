package com.hfad.ad3lesson7.ui;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.hfad.ad3lesson7.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding ui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ui = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(ui.getRoot());
    }
}