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

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import cn.azir.eUtils.obj.ViewInfo;

public class DefaultEventListener extends EventListener implements OnClickListener, OnItemClickListener,
		OnLongClickListener, OnItemLongClickListener {

	public DefaultEventListener(ViewInfo viewinfo) {
		super(viewinfo);
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
		Class<?>[] clss = { AdapterView.class, View.class, Integer.class, Long.class };
		Object[] params = { parent, view, position, id };
		return (boolean) handEventListener(mViewInfo.getOnItemLongClick(), clss, params);
	}

	@Override
	public boolean onLongClick(View v) {
		Class<?>[] clss = { View.class };
		Object[] params = { v };
		return (boolean) handEventListener(mViewInfo.getOnLongClick(), clss, params);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Class<?>[] clss = { AdapterView.class, View.class, Integer.class, Long.class };
		Object[] params = { parent, view, position, id };
		handEventListener(mViewInfo.getOnItemLongClick(), clss, params);
	}

	@Override
	public void onClick(View v) {
		Class<?>[] clss = { View.class };
		View[] params = { v };
		handEventListener(mViewInfo.getOnClick(), clss, params);
	}
}
