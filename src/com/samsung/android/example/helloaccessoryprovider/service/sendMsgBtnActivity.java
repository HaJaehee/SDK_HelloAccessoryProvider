package com.samsung.android.example.helloaccessoryprovider.service;

import com.samsung.android.example.helloaccessoryprovider.R;
import com.samsung.android.example.helloaccessoryprovider.service.HelloAccessoryProviderService.LocalIBinder;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.widget.Button;

public class sendMsgBtnActivity extends Activity implements OnClickListener{
	
	private Button m_btnSendMsg;

	private HelloAccessoryProviderService m_helloService;
	private boolean m_bound = false; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		Intent intent = new Intent(this, HelloAccessoryProviderService.class);
		bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		m_btnSendMsg = (Button)findViewById(R.id.sendMsg);
		m_btnSendMsg.setOnClickListener(this);
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		if(m_bound)
		{
			unbindService(mConnection);
			m_bound=false;
		}
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if ( arg0 == m_btnSendMsg)
		{
			if (m_bound)
			{
				Log.d("try send msg","true");
				m_helloService.sendMsg("Hello gear2, it's me!");
			}
		}
	}
	
	private ServiceConnection mConnection = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			m_bound = false;
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			LocalIBinder binder = (LocalIBinder) service;
			m_helloService = binder.getService();
			m_bound = true;
		}
	};
	
//	origin below
//	package com.samsung.android.example.helloaccessoryprovider.service;
//
//	import com.samsung.android.example.helloaccessoryprovider.R;
//	import com.samsung.android.example.helloaccessoryprovider.service.HelloAccessoryProviderService.LocalIBinder;
//
//	import android.os.Bundle;
//	import android.os.IBinder;
//	import android.util.Log;
//	import android.view.View;
//	import android.view.View.OnClickListener;
//	import android.app.Activity;
//	import android.content.ComponentName;
//	import android.content.Context;
//	import android.content.Intent;
//	import android.content.ServiceConnection;
//	import android.widget.Button;
//
//	public class startExerciseActivity extends Activity implements OnClickListener{
//		
//		private Button m_btnStartExercise;
//
//		private HelloAccessoryProviderService m_helloService;
//		private boolean m_bound = false; 
//		@Override
//		protected void onCreate(Bundle savedInstanceState) {
//			// TODO Auto-generated method stub
//			super.onCreate(savedInstanceState);
//			setContentView(R.layout.activity_main);
//
//		}
//		@Override
//		protected void onStart() {
//			// TODO Auto-generated method stub
//			super.onStart();
//			
//			Intent intent = new Intent(this, HelloAccessoryProviderService.class);
//			bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
//		}
//		@Override
//		protected void onResume() {
//			// TODO Auto-generated method stub
//			super.onResume();
//			m_btnStartExercise = (Button)findViewById(R.id.startExercise);
//			m_btnStartExercise.setOnClickListener(this);
//		}
//		@Override
//		protected void onPause() {
//			// TODO Auto-generated method stub
//			super.onPause();
//		}
//		@Override
//		protected void onStop() {
//			// TODO Auto-generated method stub
//			super.onStop();
//			if(m_bound)
//			{
//				unbindService(mConnection);
//				m_bound=false;
//			}
//		}
//		
//		@Override
//		protected void onDestroy() {
//			// TODO Auto-generated method stub
//			super.onDestroy();
//		}
//
//		@Override
//		public void onClick(View arg0) {
//			// TODO Auto-generated method stub
//			if ( arg0 == m_btnStartExercise)
//			{
//				if (m_bound)
//				{
//					Log.d("try send msg","true");
//					m_helloService.sendMsg("start exercise");
//				}
//			}
//		}
//		
//		private ServiceConnection mConnection = new ServiceConnection() {
//			
//			@Override
//			public void onServiceDisconnected(ComponentName name) {
//				// TODO Auto-generated method stub
//				m_bound = false;
//			}
//			
//			@Override
//			public void onServiceConnected(ComponentName name, IBinder service) {
//				// TODO Auto-generated method stub
//				LocalIBinder binder = (LocalIBinder) service;
//				m_helloService = binder.getService();
//				m_bound = true;
//			}
//		};
//	}
//

}

