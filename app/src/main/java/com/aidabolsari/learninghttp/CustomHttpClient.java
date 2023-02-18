package com.aidabolsari.learninghttp;

import com.loopj.android.http.*;

public class CustomHttpClient {

    private String baseUrl;

    private AsyncHttpClient client = new AsyncHttpClient();

    CustomHttpClient(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void get(String relativeUrl, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(relativeUrl), params, responseHandler);
    }

    public void post(String relativeUrl, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(relativeUrl), params, responseHandler);
    }

    private String getAbsoluteUrl(String relativeUrl) {
        return baseUrl + relativeUrl;
    }

}
