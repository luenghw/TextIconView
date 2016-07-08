package com.tiangxi.business.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tiangxi.business.R;
import com.tiangxi.business.utils.DensityUtils;

/**
 * Created by SB on 2016/7/8.
 */
public class TextIconView extends LinearLayout {
    private int mTextIcon;
    private float mTextSize;
    private float mIconSize;
    private int mTextColor;
    private String mText;
    private ImageView mIconView;
    private TextView mTextView;
    private Context mContext;

    public TextIconView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.text_icon_view, this);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TextIconView, 0, 0);
        try {
            mText = typedArray.getString(R.styleable.TextIconView_text);
            mIconSize = typedArray.getDimension(R.styleable.TextIconView_iconSize, 0);
            mTextSize = typedArray.getDimension(R.styleable.TextIconView_textSize, 0);
            mTextIcon = typedArray.getResourceId(R.styleable.TextIconView_textIcon, 0);
            mTextColor = typedArray.getColor(R.styleable.TextIconView_textColor, 0xff333333);
        } catch (Exception e) {

        } finally {
            typedArray.recycle();
        }
        init();
    }

    private void init() {
        mIconView = (ImageView) findViewById(R.id.img_text_icon);
        mTextView = (TextView) findViewById(R.id.text_icon);
        mTextView.setTextColor(mTextColor);
        if (!TextUtils.isEmpty(mText)) {
            mTextView.setText(mText);
        }
        if (mTextIcon != 0) {
            mIconView.setImageResource(mTextIcon);
        }
        if (mTextSize != 0) {
            mTextView.setTextSize(mTextSize);
        }
        if (mIconSize != 0) {
            mIconView.setLayoutParams(new LinearLayout.LayoutParams(DensityUtils.dp2px(mContext, mIconSize), DensityUtils.dp2px(mContext, mIconSize)));
        }
        if (mTextIcon != 0) {
            mIconView.setImageResource(mTextIcon);
        }
        invalidate();
    }

    public void setText(String text) {
        mText = text;
        invalidate();
    }

    public void setTextIcon(int iconRes) {
        mTextIcon = iconRes;
        invalidate();
    }

    public void setIconSize(float iconSize) {
        mIconSize = iconSize;
        invalidate();
    }

    public void setTextColor(int textColor) {
        mTextColor = textColor;
        invalidate();
    }
}
