/**
 * Copyright 2016/07/12 . kongxs1017@gmail.com

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
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
		Class<?>[] clss = {AdapterView.class,View.class,Integer.class,Long.class};
		Object[] params = {parent,view,position,id};
		return (boolean) handEventListener(mViewInfo.getOnItemLongClick(), clss, params);
	}

	@Override
	public boolean onLongClick(View v) {
		Class<?>[] clss = {View.class};
		Object[] params = {v};
		return (boolean) handEventListener(mViewInfo.getOnLongClick(), clss, params);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Class<?>[] clss = {AdapterView.class,View.class,Integer.class,Long.class};
		Object[] params = {parent,view,position,id};
		handEventListener(mViewInfo.getOnItemLongClick(), clss, params);
	}

	@Override
	public void onClick(View v) {
		Class<?>[] clss = {View.class};
		View[] params = {v};
		handEventListener(mViewInfo.getOnClick(),clss,params);
	}
	
	private Object handEventListener(String methodName,Class<?>[] clss, Object[] params){
		
		try {
			Object source = mViewInfo.getSource();
			Method method = source.getClass().getDeclaredMethod(methodName, clss);
			if(method != null){
				try {
					method.setAccessible(true);
					return method.invoke(source, params);
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
		return null;
		
	}
	
}
