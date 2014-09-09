package com.jiaqiang.waiterclient.entity;

import android.annotation.SuppressLint;
import android.os.StrictMode;

public class StrictModeUtil {
	
	public static String IPADRESS="http://58.195.49.55:8080";
	
	@SuppressLint("NewApi")
	public static void getStrictModeUtil() {
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.detectDiskReads().detectDiskWrites().detectNetwork()
				.penaltyLog().build());
		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
				.detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath()

				.build());
	}

}
