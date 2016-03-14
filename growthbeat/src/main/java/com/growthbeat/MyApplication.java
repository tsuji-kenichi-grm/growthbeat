package com.growthbeat;

import android.app.Activity;
import android.app.Application;
import android.util.Log;


/**
 * Created by B06423 on 2016/03/14.
 */
public class MyApplication extends Application {

    private MyActivityLifeCycleListener _myActivityLifeCycleListener;

    @Override
    public void onCreate() {
        super.onCreate();
        //GrowthPush.getInstance().setReceiveHandler(new MyReceiveHandler());
        Log.d("Tonic","MyApplication onCreate");

        _myActivityLifeCycleListener    = new MyActivityLifeCycleListener();
        registerActivityLifecycleCallbacks(_myActivityLifeCycleListener);
    }

    public boolean IsActive(){
        if( _myActivityLifeCycleListener == null )
            return false;
        return _myActivityLifeCycleListener.IsActive();
    }

    public static class MyActivityLifeCycleListener implements ActivityLifecycleCallbacks {

        private boolean _isActive   = false;

        @Override
        public void onActivityCreated(Activity activity, android.os.Bundle savedInstanceState) {
            Log.d("Tonic", "push call onActivityCreated:" + activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {
        }

        @Override
        public void onActivityResumed(Activity activity) {
            _isActive   = true;
            Log.d("Tonic", "IsActive:" + _isActive);
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, android.os.Bundle outState) {
        }

        @Override
        public void onActivityPaused(Activity activity) {
            _isActive   = false;
            Log.d("Tonic", "IsActive:" + _isActive);
        }

        @Override
        public void onActivityStopped(Activity activity) {
        }
        @Override
        public void onActivityDestroyed(Activity activity) {
        }

        public boolean IsActive(){
            return _isActive;
        }
    }
}
