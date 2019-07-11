package com.bran.alcstarter;

import android.annotation.SuppressLint;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AboutALC extends AppCompatActivity {

    private WebView aboutPage;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        aboutPage = findViewById(R.id.aboutWebview);
        webPreview();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void webPreview() {
        aboutPage.loadUrl("https://www.andela.com/alc");
        aboutPage.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
                toolbar.setTitle(aboutPage.getTitle());
            }
        });

        WebSettings webSettings = aboutPage.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}
