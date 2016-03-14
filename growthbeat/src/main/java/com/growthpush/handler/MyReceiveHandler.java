package com.growthpush.handler;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Debug;
import android.util.Log;

import com.growthbeat.Logger;

/**
 * Created by B06423 on 2016/03/11.
 */
public class MyReceiveHandler extends BaseReceiveHandler {

    private static class ActivityLifeCycleListener implements Application.ActivityLifecycleCallbacks {

        private final Logger logger = new Logger("GrowthPushEx");

        @Override
        public void onActivityCreated(Activity activity, android.os.Bundle savedInstanceState) {
            logger.debug("push call onActivityCreated:" + activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {
        }

        @Override
        public void onActivityResumed(Activity activity) {
            logger.debug("push call onActivityResumed:" + activity);
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, android.os.Bundle outState) {
        }

        @Override
        public void onActivityPaused(Activity activity) {
            logger.debug("push call onActivityPaused:" + activity);
        }

        @Override
        public void onActivityStopped(Activity activity)
        {
        }
        @Override
        public void onActivityDestroyed(Activity activity)
        {
        }
    }

    public MyReceiveHandler() {
        super();

        Log.d("Tonic", "MyReceiveHandler");
    }

    public MyReceiveHandler(Callback callback) {
        this();
        setCallback(callback);
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d("Tonic", "onReceive");

       // if(isRunning) {
            super.onReceive(context, intent);
            showAlert(context, intent);
            addNotification(context, intent);
       // }
    }

}
