package com.alcatraz.animation;
import android.view.*;
import android.os.*;
import android.animation.*;
import android.view.animation.*;

public class WayAnimation
{
	private StartContainer sc;
	private DestinationContainer dc;
	private int start_duration;
	private int transmit_duration;
	private int collapse_duration;
	private int radius;
	private boolean usead;
	

	public void setStartDuration(int s){
		start_duration=s;
	}
	public void setTransmitDuration(int s){
		transmit_duration=s;
	}
	public void setCollapseDuration(int s){
		collapse_duration=s;
	}
	public void setRadius(int s){
		radius=s;
	}
	public void setUseADInterpolator(boolean s){
		//Not the Advertisement AD-Accelerate/Decelerate
		usead=s;
	}
	
	public WayAnimation(StartContainer sc,DestinationContainer dc){
		this.sc=sc;
		this.dc=dc;
	}
	public void setStartContainer(StartContainer sc){
		this.sc=sc;
	}
	public void setDestiContainer(DestinationContainer dc){
		this.dc=dc;
	}
	public void play(){
		
	}
}
