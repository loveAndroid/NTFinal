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
package cn.azir.eUtils;

import java.lang.reflect.Field;
import java.util.List;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import cn.azir.eUtils.listener.EventListener;
import cn.azir.eUtils.obj.ViewInfo;
import cn.azir.eUtils.obj.build.ViewInfoBuild;

public class NTInject {
	
	public static <T extends Activity> void inject(T activity) {
		inject(activity, activity.getWindow().getDecorView());
	}

	public static void inject(Object obj, View view) {
		List<ViewInfo> viewInfos = ViewInfoBuild.getViewInfos(obj, view);
		setViews(viewInfos);
	}

	private static void setViews(List<ViewInfo> viewInfos) {

		if (viewInfos == null || viewInfos.size() <= 0) {
			return;
		}
		
		for (ViewInfo viewInfo : viewInfos) {
			if (viewInfo == null) {
				continue;
			}
			try {
				dispatchListener(viewInfo);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
	}

	private static void dispatchListener(ViewInfo viewInfo) throws IllegalAccessException, IllegalArgumentException {

		Object source = viewInfo.getSource();
		Field field = viewInfo.getField();
		Object obj = field.get(source);
		
		if (obj instanceof View) {
			if (!TextUtils.isEmpty(viewInfo.getOnClick())) {
				((View) obj).setOnClickListener(new EventListener(viewInfo));
			}
			
			if (!TextUtils.isEmpty(viewInfo.getOnLongClick())) {
				((View) obj).setOnLongClickListener(new EventListener(viewInfo));
			}
		}
		
		if (obj instanceof AdapterView<?>) {
			if (!TextUtils.isEmpty(viewInfo.getOnItemClick())) {
				((AdapterView<?>) obj).setOnItemClickListener(new EventListener(viewInfo));
			}
			
			if (!TextUtils.isEmpty(viewInfo.getOnItemLongClick())) {
				((AdapterView<?>) obj).setOnItemLongClickListener(new EventListener(viewInfo));
			}
		}
		
	}

}
