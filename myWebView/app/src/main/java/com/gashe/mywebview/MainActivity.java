package com.gashe.mywebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = (WebView) findViewById(R.id.myweb);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                TextView textView = (TextView) findViewById(R.id.urltext);
                textView.setText(request.getUrl().toString());
                view.loadUrl(request.getUrl().toString());
                return false;
            }
        });

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.mxcircuit.es");


    }
}
