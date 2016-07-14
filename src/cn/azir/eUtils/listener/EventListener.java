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

public abstract class EventListener {
	
	protected ViewInfo mViewInfo;
	
	public EventListener(ViewInfo viewinfo){
		this.mViewInfo = viewinfo;
	}
	
	protected Object handEventListener(String methodName,Class<?>[] clss, Object[] params){
		
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
