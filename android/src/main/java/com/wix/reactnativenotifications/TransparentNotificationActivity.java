package com.wix.reactnativenotifications;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.wix.reactnativenotifications.core.AppLaunchHelper;
import com.wix.reactnativenotifications.core.LocalNotificationService;
import com.wix.reactnativenotifications.core.notifications.ILocalNotification;
import com.wix.reactnativenotifications.core.notifications.LocalNotification;
import com.wix.reactnativenotifications.core.notifications.NotificationProps;

public class TransparentNotificationActivity extends AppCompatActivity {

    private static final String TAG = "TransparentActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the activity as transparent
        setTheme(android.R.style.Theme_Translucent_NoTitleBar);

        // Handle the intent to process the notification
        handleNotificationIntent(getIntent());
    }

    private void handleNotificationIntent(Intent intent) {
        if (intent != null) {
            Bundle notificationBundle = intent.getBundleExtra(LocalNotificationService.EXTRA_NOTIFICATION);
            if (notificationBundle != null) {
                NotificationProps notificationProps = NotificationProps.fromBundle(this, notificationBundle);
                ILocalNotification localNotification = LocalNotification.get(this, notificationProps);
                localNotification.onOpened();
            }
        }

        // Close the transparent activity
        finish();
    }
}
