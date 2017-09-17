package com.alcatraz.animation;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import android.animation.*;
import android.util.*;

public class MainActivity extends Activity 
{
	CircleObject in;
	Button act;
	StartContainer sc;
	DestinationContainer dc;
	LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initViews();
    }
	public void initViews(){
		sc=(StartContainer) findViewById(R.id.mainStartContainer1);
		dc=(DestinationContainer) findViewById(R.id.mainDesContainer1);
		ll=(LinearLayout) findViewById(R.id.mainLinearLayout1);
		try
		{
			dc.init();
			sc.init();
		}
		catch (Exception e)
		{Log.e("CircleObject","CircleObject:"+e.getMessage());}
		in = (CircleObject) findViewById(R.id.mainCircleObject1);
		
		act=(Button) findViewById(R.id.mainButton1);
		act.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					AnimCoreElement.startTranslateAnimation(sc.getCObj(), dc.getCObj(), new AnimCoreElement.AnimOutController(){

							@Override
							public void onAnimEnd()
							{
								dc.getCObj().setVisibility(View.VISIBLE);
								sc.getCObj().setVisibility(View.INVISIBLE);
								// TODO: Implement this method
							}
						});
					// TODO: Implement this method
				}
			});
		act.setOnLongClickListener(new OnLongClickListener(){

				@Override
				public boolean onLongClick(View p1)
				{
					
					// TODO: Implement this method
					return true;
				}
			});
	}
}
