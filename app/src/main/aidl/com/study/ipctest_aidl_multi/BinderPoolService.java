package com.study.ipctest_aidl_multi;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by dnw on 2017/7/18.
 */

public class BinderPoolService extends Service {
    public static final String TAG="MainActivity";
    private Binder mBinderPool=new BinderPool.BinderPoolImpl();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG,"On binger");
        return mBinderPool;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
