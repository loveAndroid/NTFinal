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
