package org.idoroiengel.expensescalculator.ui.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.idoroiengel.expensescalculator.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainLayout extends LinearLayout {

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
    private AppCompatButton mAddItemButton;
    private LinearLayout mRootView;

    // data
    private LayoutType mLayoutType;
    private Map<String, Integer> mValuesMap;
    private List<TextAndValueLayout> mItemsList;

    public void setmLayoutType(LayoutType mLayoutType) {
        this.mLayoutType = mLayoutType;
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
        mAddItemButton = findViewById(R.id.main_layout_add_item_button);
        mRootView = findViewById(R.id.main_layout_root_view);
    }

    private void initViews() {
        tweakTitle();
        mValuesMap = new HashMap<>();
        initAddItemButton();
        mItemsList = new ArrayList<>();

    }

    private void initAddItemButton() {
        mAddItemButton.setOnClickListener(v -> {
            TextAndValueLayout layout = new TextAndValueLayout(getContext());
            mItemsList.add(layout);
            addItem(layout);
            mRootView.addView(layout, mRootView.getChildCount() - 1);
        });
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

    public void addItem(TextAndValueLayout textAndValueLayout){
        int value;
        String key = null;
        try {
            key = textAndValueLayout.getmKeyText().getText().toString();
            value = Integer.parseInt(textAndValueLayout.getmValueText().getText().toString());
        }catch (NumberFormatException e){
            value = 0;
        }
        mValuesMap.put(key, value);
    }
}
