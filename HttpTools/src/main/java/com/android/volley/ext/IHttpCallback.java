package com.android.volley.ext;

import org.json.JSONObject;

public interface IHttpCallback {
	void onHttpStart();
	void onHttpFinish();
	void onHttpResult(String string);
	void onHttpResultJsonObject(JSONObject jsonObject);
	void onHttpError(Exception e);
	void onHttpCancelled();
	void onHttpLoading(long count, long current);
}
