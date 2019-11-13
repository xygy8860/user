package com.chenghui.lib.user;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_web);

        WebView webView = findViewById(R.id.web);
        //webView.getSettings().setJavaScriptEnabled(true);
        // 设置可以支持缩放
        webView.getSettings().setSupportZoom(true);
        // 设置出现缩放工具
        webView.getSettings().setBuiltInZoomControls(true);
        //扩大比例的缩放
        webView.getSettings().setUseWideViewPort(true);
        //自适应屏幕
//        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//        webView.getSettings().setLoadWithOverviewMode(true);

        webView.getSettings().setTextZoom(250);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);

        String article = getIntent().getStringExtra("data");
        webView.loadUrl(article);
    }
}
