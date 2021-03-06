package cn.azir.eUtils;


import java.io.File;
import java.lang.reflect.Method;

import com.example.injectactivity.InjectBaseAct;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import cn.azir.eUtils.annotation.NTViewInject;

public class MainActivity extends InjectBaseAct {
	
	@NTViewInject(id = R.id.helloTv,onClick="onClickEvent",onLongClick="longEvent")
	private ImageView mText;
	
	@NTViewInject(id=R.id.helloListView,onItemClick = "itemClickEvent")
	private ListView helloListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		NTInject.inject(this);
		
		ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this);
		ImageLoader.getInstance().init(configuration );
		
		ImageLoader.getInstance().displayImage("https://www.baidu.com/img/bd_logo1.png", mText);
		
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
	
	
	@Override
	public Resources getResources() {
		return super.getResources();
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
