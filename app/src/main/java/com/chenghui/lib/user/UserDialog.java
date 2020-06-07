package com.chenghui.lib.user;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;


/**
 * 求好评
 * Created by 2017/5/18.
 */

public class UserDialog {

    private AlertDialog dialog;
    private String userUrl;
    private String yinsiUrl;


    public UserDialog(Activity activity, View.OnClickListener onAgreeListener) {
        this(activity, onAgreeListener, null);
    }

    public UserDialog(Activity activity, View.OnClickListener onAgreeListener, View.OnClickListener onCloseListener) {
        this(activity, true, true, true, onAgreeListener, onCloseListener);
    }

    public UserDialog(final Activity activity, boolean isStorage, boolean isPhone, boolean isLocation, final View.OnClickListener onAgreeListener, final View.OnClickListener onCloseListener) {

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

        if (!isStorage && !isLocation && !isPhone) {
            dialog.findViewById(R.id.user_tips).setVisibility(View.GONE);
            dialog.findViewById(R.id.user_des).setVisibility(View.GONE);
        }

        dialog.findViewById(R.id.user_close_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();

                if (onCloseListener != null) {
                    onCloseListener.onClick(view);
                }
            }
        });

        dialog.findViewById(R.id.user_agree_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onAgreeListener != null) {
                    onAgreeListener.onClick(view);
                }
            }
        });

        dialog.findViewById(R.id.user_click_user).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, WebActivity.class);
                intent.putExtra("data", TextUtils.isEmpty(userUrl) ? "http://www.chenghuigaoke.top/user.htm" : userUrl);
                activity.startActivity(intent);
            }
        });

        dialog.findViewById(R.id.user_click_yinsi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, WebActivity.class);
                intent.putExtra("data", TextUtils.isEmpty(yinsiUrl) ? "http://www.chenghuigaoke.top/yinsi.htm" : yinsiUrl);
                activity.startActivity(intent);
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

    public void setYinsiUrl(String yinsiUrl) {
        this.yinsiUrl = yinsiUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }
}
