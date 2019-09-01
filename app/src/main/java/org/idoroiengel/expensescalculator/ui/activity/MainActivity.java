package org.idoroiengel.expensescalculator.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.idoroiengel.expensescalculator.R;
import org.idoroiengel.expensescalculator.ui.component.MainLayout;

public class MainActivity extends AppCompatActivity {

    // UI
    private MainLayout mIncomesLayout;
    private MainLayout mExpensesLayout;
    private TextView mSumTextView;

    // data
    private int mIncomesSum;
    private int mExpensesSum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        bindViews();
        initViews();

    }

    private void initViews() {
        mIncomesSum = mIncomesLayout.getmSummation();
        mExpensesSum = mExpensesLayout.getmSummation();
        mSumTextView.setText(String.valueOf(mIncomesSum - mExpensesSum));
    }

    private void bindViews() {
        mIncomesLayout = findViewById(R.id.activity_main_incomes_layout);
        mExpensesLayout = findViewById(R.id.activity_main_expenses_layout);
        mSumTextView = findViewById(R.id.activity_main_sum_text_view);
    }

}
