/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
*/
package com.erisu.cordova.dynamicUserAgent;

import java.util.TimeZone;

import android.webkit.WebSettings;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.engine.SystemWebViewEngine;
import org.apache.cordova.engine.SystemWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.provider.Settings;

public class DynamicUserAgent extends CordovaPlugin {
    public static final String TAG = "DynamicUserAgent";

    public static String platform; // Device OS

    private static final String ANDROID_PLATFORM = "Android";

    /**
     * Constructor.
     */
    public DynamicUserAgent() { }

    /**
     * Sets the context of the Command. This can then be used to do things like
     * get file paths associated with the Activity.
     *
     * @param cordova The context of the main Activity.
     * @param webView The CordovaWebView Cordova is running in.
     */
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);

        SystemWebViewEngine systemWebViewEngine = (SystemWebViewEngine) webView.getEngine();
        SystemWebView systemWebView = (SystemWebView) systemWebViewEngine.getView();
        WebSettings settings = systemWebView.getSettings();

        settings.setUserAgentString(settings.getUserAgentString() + " " + getPlatform() + "/" + getOSVersion());
    }

    /**
     * Get the OS name.
     *
     * @return
     */
    public String getPlatform() {
        return ANDROID_PLATFORM;
    }

    /**
     * Get the OS version.
     *
     * @return
     */
    public String getOSVersion() {
        String osversion = android.os.Build.VERSION.RELEASE;
        return osversion;
    }
}
