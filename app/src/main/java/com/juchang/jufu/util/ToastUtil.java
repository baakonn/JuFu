package com.juchang.jufu.util;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.juchang.jufu.view.base.BaseApplication;

/**
 * ToastUtil
 */
public class ToastUtil {

	public static void show(Context context, int no_result) {
		Toast.makeText(context, no_result, Toast.LENGTH_LONG).show();
	}

	public static void show(int no_result) {
		Toast.makeText(BaseApplication.baseContext, no_result, Toast.LENGTH_LONG).show();
	}

	public static void showShort(String no_result) {
		if (TextUtils.isEmpty(no_result)) {
			return;
		}
		Toast.makeText(BaseApplication.baseContext, no_result, Toast.LENGTH_SHORT).show();
	}
	public static void showShort(Context context, String no_result) {
		if (TextUtils.isEmpty(no_result)) {
			return;
		}
		Toast.makeText(context, no_result, Toast.LENGTH_SHORT).show();
	}
}
