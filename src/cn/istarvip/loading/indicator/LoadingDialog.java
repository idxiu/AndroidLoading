package cn.istarvip.loading.indicator;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import cn.istarvip.loading.LoadingIndicatorView;
import cn.istarvip.loading.R;
import cn.istarvip.loading.isNetWorkAvailable;

/**
 * 加载动画 
 * 创建者： Created by zhengluxiu on 2016/3/2. 
 * 项目名称：动画库 
 * 类描述：加载动画操作 
 * 创建时间：14:11
 */
public class LoadingDialog extends Dialog {
	private static LoadingDialog loadingDialog = null;
	private static Activity activity;
	private static String loading_id = "22";
	@SuppressWarnings("unused")
	private static Context mContext;
	// private static TextView tv;
	private static List<LoadingDialog> allDialog;
	static LinearLayout layout;
	private LoadingIndicatorView load;
	LayoutParams params;

	public static List<LoadingDialog> getAllDialog() {
		return allDialog;
	}

	public LoadingDialog(Context context) {
		super(context);
		mContext = context;
	}

	public LoadingDialog(Context context, int theme) {
		super(context, theme);
		mContext = context;
	}

	/**
	 * 创建Dialog
	 * @param loading_id 加载图标id 在（0~27）中选择 默认22
	 * @param context
	 * @return
	 */
	public static LoadingDialog createDialog(Context context, Activity activity, String loading_id) {
		mContext = context;
		allDialog = new ArrayList<LoadingDialog>();
		loadingDialog = new LoadingDialog(context, R.style.CustomProgressDialog);
		LoadingDialog.activity = activity;
		if (loading_id != null) {
			LoadingDialog.loading_id = loading_id;
		}
		loadingDialog.setContentView(R.layout.loading_dialog);
		loadingDialog.getWindow().getAttributes().gravity = Gravity.CENTER;
		// tv = (TextView) loadingDialog
		// .findViewById(R.id.id_tv_loadingmsg);
		// tv.setText("正在拼命加载...");
	   layout = (LinearLayout) loadingDialog.findViewById(R.id.layout); 
		return loadingDialog;
	}

	public void onWindowFocusChanged(boolean hasFocus) {
		if (loadingDialog == null) {
			return;
		}

		int id = Integer.parseInt(loading_id);
		load = new LoadingIndicatorView(activity, id);
		params = new LayoutParams(activity.getResources().getDimensionPixelSize(R.dimen.width),
				activity.getResources().getDimensionPixelSize(R.dimen.height));
		params.gravity = Gravity.CENTER;
		load.setLayoutParams(params);
		layout.removeAllViews();
		layout.addView(load);
	}

	/** 
	 * [Summary] setTitile 标题 
	 * @param strTitle
	 * @return 
	 */
	public LoadingDialog setTitile(String strTitle) {
		return loadingDialog;
	}

	/** 
	 * [Summary] setMessage 提示内容 
	 * @param strMessage
	 * @return 
	 */
	// public LoadingDialog setMessage(String strMessage) {
	// if (tv != null) {
	// tv.setText(strMessage);
	// }
	// return loadingDialog;
	// }

	/**
	 * 设置提示字体颜色
	 * 
	 * @param id
	 * @return
	 */
	// public LoadingDialog setTextColor(int id) {
	// if (tv != null) {
	// tv.setTextColor(id);
	// }
	// return loadingDialog;
	// }

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (loadingDialog != null) {
				if (activity != null) {
					activity.finish();
				}
				if (loadingDialog.isShowing()) {
					loadingDialog.stopProgressDialog(loadingDialog);
					loadingDialog = null;
					return true;
				}
			}
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return false;
	}

	/**
	 * 设置提示字体大小
	 * 
	 * @param size
	 * @return
	 */
	// public LoadingDialog setTextSize(float size) {
	// if (tv != null) {
	// tv.setTextSize(size);
	// }
	// return loadingDialog;
	// }

	/**
	 * 开始
	 */
	public void startProgressDialog(LoadingDialog loadingDialog) {
		if (loadingDialog != null) {
			if (isNetWorkAvailable.isNetWork(activity)) {
				loadingDialog.show();
				allDialog.add(loadingDialog);
			}
		}
	}

	/**
	 * 停止
	 */
	public void stopProgressDialog(LoadingDialog loadingDialog) {
		if (loadingDialog != null) {
			loadingDialog.dismiss();
			// customProgressDialog=null;
			allDialog.remove(loadingDialog);
			System.gc();
		}
	}

}
