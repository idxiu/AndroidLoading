/**
 * 
 */
package cn.istarvip.loading; 

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author Clown 是否连接到Network
 */
public class isNetWorkAvailable {
	
	/**
	 * 
	 * 总判断
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isNetWork(Context context) {
		boolean netStatus = false;
		try {
			ConnectivityManager connectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			if (connectivityManager != null) {
				NetworkInfo networkInfo = connectivityManager
						.getActiveNetworkInfo();
				if (networkInfo.isAvailable()||networkInfo.isConnected()) {
					netStatus=true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return netStatus;
	}
}
