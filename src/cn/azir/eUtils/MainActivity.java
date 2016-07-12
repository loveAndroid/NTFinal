package cn.azir.eUtils;


import cn.azir.eUtils.annotation.NTViewInject;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	@NTViewInject(id = R.id.helloTv,onClick="onClickEvent",onLongClick="longEvent")
	private TextView mText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		NTInject.inject(this);
		
		
		mText.setText("hfldkjakls");
	}
	
	
	protected void onClickEvent(View view){
		Toast.makeText(getApplicationContext(), "onClickEvent", 0).show();
	}
	
	protected boolean longEvent(View v){
		Toast.makeText(getApplicationContext(), "longEvent", 0).show();
		return true;
	}
}
