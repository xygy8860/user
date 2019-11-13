package com.chenghui.lib.user;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;


/**
 * 求好评
 * Created by 2017/5/18.
 */

public class UserDialog {

    private AlertDialog dialog;

    public UserDialog(Activity activity, View.OnClickListener listener) {
        this(activity, true, true, true, listener);
    }

    public UserDialog(Activity activity, boolean isStorage, boolean isPhone, boolean isLocation, final View.OnClickListener listener) {

        dialog = new AlertDialog.Builder(activity, R.style.user_dialog).create();
        dialog.show();
        dialog.getWindow().setContentView(R.layout.user_dialog);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(false);

        if (!isStorage) {
            dialog.findViewById(R.id.user_storage).setVisibility(View.GONE);
        }

        if (!isPhone) {
            dialog.findViewById(R.id.user_phone).setVisibility(View.GONE);
        }

        if (!isLocation) {
            dialog.findViewById(R.id.user_location).setVisibility(View.GONE);
        }

        dialog.findViewById(R.id.user_close_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.user_agree_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClick(view);
                }
            }
        });
    }

    public void dismiss() {
        dialog.dismiss();
    }

    public void show() {
        dialog.show();
    }

    public boolean isShowing() {
        return dialog.isShowing();
    }
}
