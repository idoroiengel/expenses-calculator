package org.idoroiengel.expensescalculator.ui.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import org.idoroiengel.expensescalculator.R;


public class MainLayout extends LinearLayout {

    TextAndValueLayout mTitle;

    public MainLayout(Context context) {
        this(context, null);
    }

    public MainLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.main_layout, this, true);

        bindViews();
        initViews();
    }

    private void bindViews() {
        mTitle = findViewById(R.id.main_layout_title);
    }

    private void initViews() {

    }
}
