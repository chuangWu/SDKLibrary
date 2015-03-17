package chuang.sdklibrary.android.framework;

import android.os.Bundle;
import android.util.Log;

import chuang.sdklibrary.util.CubeDebug;
import chuang.sdklibrary.util.lifecycle.IComponentContainer;
import chuang.sdklibrary.util.lifecycle.LifeCycleComponent;
import chuang.sdklibrary.util.lifecycle.LifeCycleComponentManager;


/**
 * manager the components when move from a lifetime to another
 */
public abstract class XActivity extends CubeFragmentActivity implements IComponentContainer {
    private static final boolean DEBUG = CubeDebug.DEBUG_LIFE_CYCLE;
    private LifeCycleComponentManager mComponentContainer = new LifeCycleComponentManager();

    @Override
    protected void onRestart() {
        super.onStart();
        mComponentContainer.onBecomesVisibleFromTotallyInvisible();
        if (DEBUG) {
            showStatus("onRestart");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mComponentContainer.onBecomesPartiallyInvisible();
        if (DEBUG) {
            showStatus("onPause");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mComponentContainer.onBecomesVisibleFromPartiallyInvisible();
        if (DEBUG) {
            showStatus("onResume");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DEBUG) {
            showStatus("onCreate");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mComponentContainer.onBecomesTotallyInvisible();
        if (DEBUG) {
            showStatus("onStop");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mComponentContainer.onDestroy();
        if (DEBUG) {
            showStatus("onDestroy");
        }
    }

    @Override
    public void addComponent(LifeCycleComponent component) {
        mComponentContainer.addComponent(component);
    }

    private void showStatus(String status) {
        final String[] className = ((Object) this).getClass().getName().split("\\.");
        Log.d("cube-lifecycle", String.format("%s %s", className[className.length - 1], status));
    }
}
