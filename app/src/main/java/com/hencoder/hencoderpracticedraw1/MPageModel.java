package com.hencoder.hencoderpracticedraw1;

import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;

/**
 * Created by 张英杰 on 2018/4/23.
 */

public class MPageModel {
   public int sampleLayoutRes;
    @StringRes
    public int titleRes;
    @LayoutRes
    public int practiceLayoutRes;

    //        PageModel(@LayoutRes int sampleLayoutRes, @StringRes int titleRes, @LayoutRes int practiceLayoutRes) {
    public MPageModel(int sampleLayoutRes,@StringRes  int titleRes, @LayoutRes int practiceLayoutRes) {
        this.sampleLayoutRes = sampleLayoutRes;
        this.titleRes = titleRes;
        this.practiceLayoutRes = practiceLayoutRes;
    }
}
