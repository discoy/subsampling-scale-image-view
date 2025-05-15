package com.davemorrissey.labs.subscaleview.test;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.davemorrissey.labs.subscaleview.test.R.id;
import com.davemorrissey.labs.subscaleview.test.animation.AnimationActivity;
import com.davemorrissey.labs.subscaleview.test.basicfeatures.BasicFeaturesActivity;
import com.davemorrissey.labs.subscaleview.test.configuration.ConfigurationActivity;
import com.davemorrissey.labs.subscaleview.test.eventhandling.EventHandlingActivity;
import com.davemorrissey.labs.subscaleview.test.eventhandlingadvanced.AdvancedEventHandlingActivity;
import com.davemorrissey.labs.subscaleview.test.extension.ExtensionActivity;
import com.davemorrissey.labs.subscaleview.test.imagedisplay.ImageDisplayActivity;
import com.davemorrissey.labs.subscaleview.test.viewpager.ViewPagerActivity;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.main_title);
        }
        setContentView(R.layout.main);
        findViewById(id.basicFeatures).setOnClickListener(this);
        findViewById(id.imageDisplay).setOnClickListener(this);
        findViewById(id.eventHandling).setOnClickListener(this);
        findViewById(id.advancedEventHandling).setOnClickListener(this);
        findViewById(id.viewPagerGalleries).setOnClickListener(this);
        findViewById(id.animation).setOnClickListener(this);
        findViewById(id.extension).setOnClickListener(this);
        findViewById(id.configuration).setOnClickListener(this);
        findViewById(id.github).setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        final int viewId = view.getId();
        if(id.basicFeatures == viewId) startActivity(BasicFeaturesActivity.class);
        else if(id.imageDisplay == viewId) startActivity(ImageDisplayActivity.class);
        else if(id.eventHandling == viewId) startActivity(EventHandlingActivity.class);
        else if(id.advancedEventHandling == viewId) startActivity(AdvancedEventHandlingActivity.class);
        else if(id.viewPagerGalleries == viewId) startActivity(ViewPagerActivity.class);
        else if(id.animation == viewId) startActivity(AnimationActivity.class);
        else if(id.extension == viewId) startActivity(ExtensionActivity.class);
        else if(id.configuration == viewId) startActivity(ConfigurationActivity.class);
        else if(id.github == viewId) openGitHub();
    }

    private void startActivity(Class<? extends Activity> activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

    private void openGitHub() {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://github.com/davemorrissey/subsampling-scale-image-view"));
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
