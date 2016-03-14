package com.growthpush.handler;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Debug;
import android.util.Log;

import com.growthbeat.Logger;
import com.growthbeat.MyApplication;

/**
 * Created by B06423 on 2016/03/11.
 */
public class MyReceiveHandler extends BaseReceiveHandler {

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

        MyApplication   myApp = (MyApplication)context.getApplicationContext();
        boolean isActive = false;
        if( myApp != null ) {
            isActive = myApp.IsActive();
            Log.d("Tonic", "onReceive:" + isActive);
        }
        // アクティブだったら通知を取得しない
        if(!isActive) {
            super.onReceive(context, intent);
            showAlert(context, intent);
            addNotification(context, intent);
        }
    }

}
