package cn.azir.eUtils;


import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import android.app.Activity;
import android.os.Bundle;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import cn.azir.eUtils.annotation.NTViewInject;

public class MainActivity extends Activity {
	
	@NTViewInject(id = R.id.helloTv,onClick="onClickEvent",onLongClick="longEvent")
	private TextView mText;
	
	@NTViewInject(id=R.id.helloListView,onItemClick = "itemClickEvent")
	private ListView helloListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		NTInject.inject(this);
		
		mText.setText("hfldkjakls");
		
		
		
		helloListView.setAdapter(new MyAdapter());
		
		
		try {
			Class<?> cls = Class.forName("android.content.pm.PackageParser");
			Object obj = cls.newInstance();
			Method parsePackage = cls.getDeclaredMethod("parsePackage", File.class,String.class,DisplayMetrics.class,Integer.class);
			
			System.out.println(parsePackage);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception -- " + e.getMessage());
		}
		
		
		
		
	}
	
	
	protected void onClickEvent(View view){
		Toast.makeText(getApplicationContext(), "onClickEvent", 0).show();
		
		try {
			Class<?> cls = Class.forName("android.os.ServiceManager");
			Object obj = cls.newInstance();
			Method addService = cls.getDeclaredMethod("addService", String.class,IBinder.class);
			addService.setAccessible(true);
//			addService.invoke(obj, "hello",new NtService());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception : " +e.getLocalizedMessage());
		}
		
	}
	
	protected boolean longEvent(View v){
		Toast.makeText(getApplicationContext(), "longEvent", 0).show();
		return true;
	}
	
	protected void itemClickEvent(AdapterView<?> parent, View view, int position, long id) {
		Toast.makeText(getApplicationContext(), "itemClickEvent = " + position, 0).show();
	}
	
	
	
	
	
	class MyAdapter extends BaseAdapter {

		
		@Override
		public int getCount() {
			return 10;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			ViewHolder holder = null;
			
			if (convertView == null) {
				convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.test, null);
				holder = new ViewHolder(convertView);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			
			Toast.makeText(getApplicationContext(), "btn == " + (holder.btn == null), 0).show();
			
			return convertView;
		}
		
		class ViewHolder {
			@NTViewInject(id = R.id.button1)
			private TextView btn;
			
			public ViewHolder(View view) {
				NTInject.inject(this, view);
			}
			
		}
		
	}
	
	
	
	
	
	
}
