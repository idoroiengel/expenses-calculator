package org.idoroiengel.expensescalculator.ui.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.idoroiengel.expensescalculator.R;


public class MainLayout extends LinearLayout {

    public static final String LOG_TAG = "DEBUG";

    public enum LayoutType{
        INCOME(0, R.string.layout_type_incomes_title),
        EXPENSE(1, R.string.layout_type_expenses_title);

        private int mResource;
        private int mType;

        LayoutType(int type, int mResource) {
            this.mType = type;
            this.mResource = mResource;
        }
        public static LayoutType getByType(int type){
            LayoutType result = null;
            for (LayoutType layoutType : LayoutType.values()) {
                if(layoutType.mType == type){
                    result = layoutType;
                }
            }
            return result;
        }
    }

    // UI
    private TextView mTitle;
    private AppCompatButton mAddLayoutButton;
    private LinearLayout mTextAndValueLayoutRootView;

    // data
    private LayoutType mLayoutType;
    private int mSummation;
    private SparseArray<String> mValuesMap;

    public void setmLayoutType(LayoutType mLayoutType) {
        this.mLayoutType = mLayoutType;
    }

    public int getmSummation() {
        return mSummation;
    }

    public MainLayout(Context context) {
        this(context, null);
    }

    public MainLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.main_layout, this, true);
        determineListType(context, attrs);

        bindViews();
        initViews();
    }

    private void bindViews() {
        mTitle = findViewById(R.id.main_layout_title);
        mAddLayoutButton = findViewById(R.id.main_layout_add_item_button);
        mTextAndValueLayoutRootView = findViewById(R.id.main_layout_text_and_value_layout_layout);
    }

    private void initViews() {
        tweakTitle();
        initButton();
        mValuesMap = new SparseArray<>();
    }

    private void initButton() {
        mAddLayoutButton.setOnClickListener(v -> {
            addTextAndValueLayout();

            popFocusForNewLayout();


        });
    }

    private void popFocusForNewLayout() {
        mTextAndValueLayoutRootView.getChildAt(mTextAndValueLayoutRootView.getChildCount() - 1).requestFocus();
    }

    private void addTextAndValueLayout() {
        mTextAndValueLayoutRootView.addView(new TextAndValueLayout(getContext()), mTextAndValueLayoutRootView.getChildCount());
    }

    private void determineListType(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MainLayout);
        String listType = typedArray.getString(R.styleable.MainLayout_main_layout_type);
        setmLayoutType(LayoutType.getByType(Integer.valueOf(listType)));
        typedArray.recycle();
    }

    private void tweakTitle() {
        mTitle.setText(getContext().getString(mLayoutType.mResource));
    }


}
