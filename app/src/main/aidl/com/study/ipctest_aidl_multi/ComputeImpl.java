package com.study.ipctest_aidl_multi;

import android.os.RemoteException;

/**
 * Created by dnw on 2017/7/18.
 */

public class ComputeImpl extends ICompute.Stub {
    @Override
    public int add(int a, int b) throws RemoteException {
        return a+b;
    }
}
