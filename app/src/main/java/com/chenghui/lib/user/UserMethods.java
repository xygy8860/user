package com.chenghui.lib.user;

import android.content.Context;
import android.content.Intent;

public class UserMethods {

    public static void startYinsiActivity(Context context) {
        startYinsiActivity(context, "http://www.chenghuigaoke.top/yinsi.htm");
    }

    public static void startYinsiActivity(Context context, String url) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra("data", url);
        context.startActivity(intent);
    }

    public static void startUserActivity(Context context) {
        startUserActivity(context, "http://www.chenghuigaoke.top/user.htm");
    }

    public static void startUserActivity(Context context, String url) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra("data", url);
        context.startActivity(intent);
    }
}
