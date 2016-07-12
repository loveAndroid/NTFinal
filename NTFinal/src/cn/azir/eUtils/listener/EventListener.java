package cn.azir.eUtils.listener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import cn.azir.eUtils.obj.ViewInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

public class EventListener implements OnClickListener,OnItemClickListener,OnLongClickListener,OnItemLongClickListener{

	private ViewInfo mViewInfo;
	
	public EventListener(ViewInfo mViewInfo) {
		this.mViewInfo = mViewInfo;
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
		return false;
	}

	@Override
	public boolean onLongClick(View v) {
		return false;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
	}

	@Override
	public void onClick(View v) {
		Class<?>[] clss = {View.class};
		View[] params = {v};
		handEventListener(mViewInfo.getOnClick(),clss,params);
	}
	
	private void handEventListener(String methodName,Class<?>[] clss, View[] params){
		
		try {
			Object source = mViewInfo.getSource();
			Method method = source.getClass().getDeclaredMethod(methodName, clss);
			if(method != null){
				try {
					method.setAccessible(true);
					method.invoke(source, params);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		
	}
	
}
