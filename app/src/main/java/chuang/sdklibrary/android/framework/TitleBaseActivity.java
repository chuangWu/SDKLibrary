package chuang.sdklibrary.android.framework;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import chuang.sdklibrary.R;


public abstract class TitleBaseActivity extends MintsBaseActivity {

    protected TitleHeaderBar mTitleHeaderBar;
    protected LinearLayout mContentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
    }

    protected int getFrameLayoutId() {
        return R.layout.cube_activity_titlebase;
    }

    protected TitleHeaderBar getTitleHeaderBar() {
        return (TitleHeaderBar) findViewById(R.id.title_base_header);
    }

    protected LinearLayout getContentContainer() {
        return (LinearLayout) findViewById(R.id.title_base_container);
    }

    protected void initViews() {
        super.setContentView(getFrameLayoutId());

        mTitleHeaderBar = getTitleHeaderBar();
        mContentContainer = getContentContainer();

        if (enableDefaultBack()) {
            mTitleHeaderBar.setLeftOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (!processBackPressed()) {
                        doReturnBack();
                    }
                }
            });
        } else {
            mTitleHeaderBar.getLeftViewContainer().setVisibility(View.INVISIBLE);
        }
    }

    protected boolean enableDefaultBack() {
        return true;
    }

    @Override
    public void setContentView(int layoutResID) {
        View view = LayoutInflater.from(this).inflate(layoutResID, null);
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mContentContainer.addView(view);
    }

    public void setContentViewSupper(int layoutResID) {
        super.setContentView(layoutResID);
    }

    protected void setHeaderTitle(int id) {
        mTitleHeaderBar.getTitleTextView().setText(id);
    }

    protected void setHeaderTitle(String title) {
        mTitleHeaderBar.setTitle(title);
    }
}
