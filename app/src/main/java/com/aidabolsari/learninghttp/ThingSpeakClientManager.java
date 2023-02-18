package com.aidabolsari.learninghttp;

import android.util.Log;

import org.json.*;
import com.loopj.android.http.*;

import cz.msebera.android.httpclient.Header;


public class ThingSpeakClientManager {

    public void getField2() throws JSONException {
        RequestParams requestParams = new RequestParams();
        requestParams.add("api_key", "JYY2LMKB25152SU1");

        ClientManager.CUSTOM_HTTP_CLIENT.get("channels/2037278/fields/2/last.json", requestParams, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    Log.d("MY", response.toString());
                    Log.d("MY", response.getString("field2"));
                    Log.d("MY", response.getString("entry_id"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
                // Pull out the first event on the public timeline
                String tweetText = null;
                try {
                    JSONObject firstEvent = null;
                    firstEvent = (JSONObject) timeline.get(0);
                    tweetText = firstEvent.getString("text");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                System.out.println(tweetText);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                throwable.printStackTrace();
                Log.d("MY", " " + statusCode);
                Log.d("MY", " " + errorResponse);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                throwable.printStackTrace();
                Log.d("MY", " " + statusCode);
                Log.d("MY", " " + errorResponse);
            }
        });
    }
}
