package com.study.ipctest_aidl_multi;

import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    public static final String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                doWork();
//            }
//        }).start();

    }
    private void doWork()
    {
        BinderPool binderPool=BinderPool.getsInstance(this);
        IBinder securityBinder = binderPool.queryBinder(BinderPool.BINDER_SECURITY_CENTER);
        ISecurityCenter mSecurityCenter = SecurityCenterImpl.asInterface(securityBinder);
        Log.d(TAG, "visit ISecurityCenter");
        String msg="helloWord_安卓";
        try{
            String password=mSecurityCenter.encrypt(msg);
            Log.d(TAG,"content:"+password);
            Log.d(TAG,"decrypt:"+mSecurityCenter.decrypt(password));
        }catch(RemoteException e)
        {
            e.printStackTrace();
        }
        Log.d(TAG,"visit ICompute");
        IBinder computeBinder=binderPool.queryBinder(BinderPool.BINDER_COMPUTE);
        ICompute mCompute=ComputeImpl.asInterface(computeBinder);
        try
        {
            Log.d(TAG,"3+5="+mCompute.add(3,5));
        }catch(RemoteException e)
        {
            e.printStackTrace();
        }
    }
}
