package com.growthbeat;

import android.app.Application;
import com.growthpush.GrowthPush;
//import com.growthpush.handler.MyReceiveHandler;
import com.growthbeat.Logger;

/**
 * Created by B06423 on 2016/03/14.
 */
public class MyApplication extends Application {

    private final Logger logger = new Logger("GrowthPushEx");

    @Override
    public void onCreate() {
        super.onCreate();
        //GrowthPush.getInstance().setReceiveHandler(new MyReceiveHandler());
        logger.info("MyApplication onCreate");
    }
}
