package org.idoroiengel.expensescalculator.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.idoroiengel.expensescalculator.R;
import org.idoroiengel.expensescalculator.ui.component.MainLayout;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

    }

}
