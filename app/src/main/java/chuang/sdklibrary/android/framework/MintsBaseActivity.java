package chuang.sdklibrary.android.framework;


import chuang.sdklibrary.R;

public abstract class MintsBaseActivity extends XActivity {

    @Override
    protected String getCloseWarning() {
        return getString(R.string.cube_mints_exit_tip);
    }

    @Override
    protected int getFragmentContainerId() {
        return 0;
    }
}