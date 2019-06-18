package org.idoroiengel.expensescalculator.ui.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import org.idoroiengel.expensescalculator.R;

public class TextAndValueLayout extends LinearLayout {

    private EditText mKeyText;
    private EditText mValueText;

    public EditText getmKeyText() {
        return mKeyText;
    }

    public EditText getmValueText() {
        return mValueText;
    }

    public TextAndValueLayout(Context context) {
        this(context, null);
    }

    public TextAndValueLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.text_and_value_layout, this, true);

        bindViews();
        initViews();
    }

    private void bindViews() {
        mKeyText = findViewById(R.id.text_and_value_layout_key_text);
        mValueText = findViewById(R.id.text_and_value_layout_value_text);
    }

    private void initViews() {

    }

    public void setTitle(String string) {
        mKeyText.setText(string);
        if(mValueText.getText().toString().isEmpty()){
            mValueText.setVisibility(View.GONE);
        }
    }
}
