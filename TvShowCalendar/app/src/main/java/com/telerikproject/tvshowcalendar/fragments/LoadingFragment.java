package com.telerikproject.tvshowcalendar.fragments;

import android.app.ProgressDialog;
import android.content.Context;

import com.telerikproject.tvshowcalendar.fragments.base.ILoadingFragment;

public class LoadingFragment implements ILoadingFragment {

    private ProgressDialog loadingDialog;
    private Context context;

    public void show() {
        if (this.loadingDialog == null) {
            this.loadingDialog = new ProgressDialog(this.context);
            this.loadingDialog.setMessage("Please wait...");
            this.loadingDialog.setCancelable(false);
        }

        this.loadingDialog.show();
    }

    public void hide() {
        this.loadingDialog.hide();
        this.loadingDialog.dismiss();
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
