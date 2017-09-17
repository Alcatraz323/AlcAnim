package com.alcatraz.animation;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.util.*;

public class DestinationContainer extends FrameLayout
{
	private CircleObject mView;
	private boolean hasInit=false;
	public DestinationContainer(android.content.Context context) {
		super(context);
	}

    public DestinationContainer(android.content.Context context, android.util.AttributeSet attrs) {
		super(context,attrs);
	}
	public View getCObj(){
		return mView;
	}
	public DestinationContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
	public void init() throws Exception
	{
		mView=(CircleObject) getChildAt(getChildCount()-1);
		if(mView.getVisibility()!=View.INVISIBLE){
			mView.setVisibility(View.INVISIBLE);
		}
		try{
			mView.testInstance();
		}catch(Exception e){
			throw new Exception("The first child isnt CircleObject");
		}
		hasInit = true;
	}
	public View getStartV() throws Exception{
		if (hasInit)
		{
			if (mView == null)
			{
				if (!(getChildCount() > 1))
				{
					return getChildAt(0);
				}
				else
				{
					throw new Exception("Only one child can be contained in the Container");
				}
			}
		}
		else
		{
			throw new Exception("You cant invoke getStart() without calling StartContainer.init()");
		}
		return this;
	}
}
