package com.alcatraz.animation;
import android.view.*;

public interface TransmitImpl
{
	public void onStartObjectStartToCollapse(View target);
	public void onStartObjectEndCollapsing(View target);
	public void onStartTransmit(View neutral);
	public void onAccelerationComplete(View neutral);
	public void onEndTransmit(View neutral);
	public void onStartExpandTraget(View target);
	public void onFinished(View target,View source);
}
