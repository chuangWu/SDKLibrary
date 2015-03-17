package chuang.sdklibrary.android.framework;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import chuang.sdklibrary.R;


public abstract class TitleBaseFragment extends CubeFragment {

    protected TitleHeaderBar mTitleHeaderBar;
    protected LinearLayout mContentContainer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup) inflater.inflate(getFrameLayoutId(), null);
        LinearLayout contentContainer = (LinearLayout) view.findViewById(R.id.title_base_container);

        mTitleHeaderBar = (TitleHeaderBar) view.findViewById(R.id.title_base_header);
        if (enableDefaultBack()) {
            mTitleHeaderBar.setLeftOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        } else {
            mTitleHeaderBar.getLeftViewContainer().setVisibility(View.INVISIBLE);
        }

        mContentContainer = contentContainer;
        View contentView = createView(inflater, view, savedInstanceState);
        contentView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        contentContainer.addView(contentView);
        return view;
    }

    protected int getFrameLayoutId() {
        return R.layout.cube_activity_titlebase;
    }

    /**
     * make it looks like Activity
     */
    private void onBackPressed() {
        getContext().onBackPressed();
    }

    protected boolean enableDefaultBack() {
        return true;
    }

    protected void setHeaderTitle(int id) {
        mTitleHeaderBar.getTitleTextView().setText(id);
    }

    protected void setHeaderTitle(String title) {
        mTitleHeaderBar.getTitleTextView().setText(title);
    }

    public TitleHeaderBar getTitleHeaderBar() {
        return mTitleHeaderBar;
    }
}
