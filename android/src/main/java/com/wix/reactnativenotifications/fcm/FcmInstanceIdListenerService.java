package com.wix.reactnativenotifications.fcm;

import android.content.Intent;

import com.google.firebase.messaging.FirebaseMessagingService;;

public class FcmInstanceIdListenerService extends FirebaseMessagingService {

    @Override
    public void onTokenRefresh() {
        final Intent intent = new Intent(this, FcmTokenService.class);
        intent.setAction(FcmTokenService.ACTION_REFRESH_TOKEN);
        startService(intent);
    }
}
