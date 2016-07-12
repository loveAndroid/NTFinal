package cn.azir.eUtils;


import cn.azir.eUtils.annotation.NTViewInject;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	@NTViewInject(id = R.id.helloTv,onClick="onClickEvent")
	private TextView mText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		NTInject.inject(this);
		
		
		mText.setText("hfldkjakls");
	}
	
	
	protected void onClickEvent(View view){
		Toast.makeText(getApplicationContext(), "onclick", 0).show();
	}
	
	
}
