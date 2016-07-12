package cn.azir.eUtils.obj.build;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import android.view.View;
import cn.azir.eUtils.annotation.NTViewInject;
import cn.azir.eUtils.obj.ViewInfo;

public class ViewInfoBuild {
	
	public static List<ViewInfo> getViewInfos(Object source, View view){
		List<ViewInfo> infos = new ArrayList<>();
		Field[] fields = source.getClass().getDeclaredFields();
		if(fields != null && fields.length > 0) {
			for (Field field : fields) {
				field.setAccessible(true);
				ViewInfo viewInfo = resolveField(source,view,field);
				if(viewInfo != null) {
					infos.add(viewInfo);
				}
			}
		}
		return infos;
	}

	
	private static ViewInfo resolveField(Object source, View view, Field field) {
		
		NTViewInject annotation = field.getAnnotation(NTViewInject.class);
		ViewInfo info = null;
		if(annotation != null) {
			int id = annotation.id();
			String onClick = annotation.onClick();
			String onItemClick = annotation.onItemClick();
			String onItemLongClick = annotation.onItemLongClick();
			String onLongClick = annotation.onLongClick();
			
			try {
				field.set(source, view.findViewById(id));
			} catch (IllegalAccessException | IllegalArgumentException e) {
				e.printStackTrace();
			}
			
			info = new ViewInfo()
					.setId(id)
					.setOnClick(onClick)
					.setOnItemClick(onItemClick)
					.setOnItemLongClick(onItemLongClick)
					.setField(field)
					.setSource(source)
					.setOnLongClick(onLongClick);
		}
		return info;
	}
	
}
