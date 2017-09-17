package com.alcatraz.animation;
import android.os.*;
import android.animation.*;
import android.view.*;
import android.view.animation.*;

public class AnimCoreElement
{
	public static void startTranslateAnimation(final View view,View target,final AnimOutController h) {
		int source_local[] = new int[2];
		view.getLocationInWindow(source_local);
		int des_local[] = new int[2];
		target.getLocationInWindow(des_local);
		view.bringToFront();
		
		view.setVisibility(View.VISIBLE);
		float transX=view.getX()+(des_local[0]-source_local[0])+target.getWidth()/2-view.getWidth()/2;
		float transY=view.getY()+(des_local[1]-source_local[1])+target.getHeight()/2-view.getHeight()/2;
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "X",transX);
		ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "Y",transY);
		AnimatorSet as=new AnimatorSet();
		as.setInterpolator(new AccelerateInterpolator());
		as.play(animator).with(animator1);
		as.setDuration(400);
		as.start();
		/*as.addListener(new Animator.AnimatorListener(){

				@Override
				public void onAnimationStart(Animator p1)
				{
					// TODO: Implement this method
				}

				@Override
				public void onAnimationEnd(Animator p1)
				{
					h.onAnimEnd();
					// TODO: Implement this method
				}

				@Override
				public void onAnimationCancel(Animator p1)
				{
					// TODO: Implement this method
				}

				@Override
				public void onAnimationRepeat(Animator p1)
				{
					// TODO: Implement this method
				}
			});*/
    }
	public static void playstart(View v){
		playstart(v, 500,0,new AnimOutController(){

				@Override
				public void onAnimEnd()
				{
					// TODO: Implement this method
				}
			});
	}
	public static void playend(View v){
		playEnd(v, 500,0,new AnimOutController(){

				@Override
				public void onAnimEnd()
				{
					// TODO: Implement this method
				}
			});
	}
	public static void playstart(final View v,int duration,int start_radius,final AnimOutController h){
		v.setVisibility(View.INVISIBLE);
		v.setVisibility(View.VISIBLE);
		if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
			Animator a=ViewAnimationUtils.createCircularReveal(v,(int)v.getX()+(v.getWidth()/2),(int)v.getY()+(v.getHeight()/2),0,v.getHeight()/2);
			a.setInterpolator(new AccelerateInterpolator());
			a.setDuration(duration);
			a.start();
			a.addListener(new Animator.AnimatorListener(){

					@Override
					public void onAnimationStart(Animator p1)
					{
						// TODO: Implement this method
					}

					@Override
					public void onAnimationEnd(Animator p1)
					{
						h.onAnimEnd();
						v.setVisibility(View.GONE);
						// TODO: Implement this method
					}

					@Override
					public void onAnimationCancel(Animator p1)
					{
						// TODO: Implement this method
					}

					@Override
					public void onAnimationRepeat(Animator p1)
					{
						// TODO: Implement this method
					}
				});
		}
	}
	public static interface AnimOutController{
		public void onAnimEnd();
	}
	public static void playFadeIn(final View v,int duration,final AnimOutController h){
		AnimationSet as=new AnimationSet(true);
		AlphaAnimation aa=new AlphaAnimation(0,1);
		aa.setDuration(duration);
		as.addAnimation(aa);
		v.startAnimation(as);
		as.setAnimationListener(new Animation.AnimationListener(){

				@Override
				public void onAnimationStart(Animation p1)
				{
					// TODO: Implement this method
				}

				@Override
				public void onAnimationEnd(Animation p1)
				{
					h.onAnimEnd();
					v.setVisibility(View.VISIBLE);
					// TODO: Implement this method
				}

				@Override
				public void onAnimationRepeat(Animation p1)
				{
					// TODO: Implement this method
				}
			});
	}
	public static void playFadeOut(final View v,int duration,final AnimOutController h){
		AnimationSet as=new AnimationSet(true);
		AlphaAnimation aa=new AlphaAnimation(1,0);
		aa.setDuration(duration);
		as.addAnimation(aa);
		v.startAnimation(as);
		as.setAnimationListener(new Animation.AnimationListener(){

				@Override
				public void onAnimationStart(Animation p1)
				{
					// TODO: Implement this method
				}

				@Override
				public void onAnimationEnd(Animation p1)
				{
					h.onAnimEnd();
					v.setVisibility(View.VISIBLE);
					// TODO: Implement this method
				}

				@Override
				public void onAnimationRepeat(Animation p1)
				{
					// TODO: Implement this method
				}
			});
	}
	public static void playEnd(final View v,int duration,int final_radius,final AnimOutController h){
		if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
			Animator a1=ViewAnimationUtils.createCircularReveal(v,(int)v.getX()+(v.getWidth()/2),(int)v.getY()+(v.getHeight()/2),v.getHeight()/2,0);
			a1.setInterpolator(new AccelerateInterpolator());
			a1.setDuration(duration);
			a1.start();
			a1.addListener(new Animator.AnimatorListener(){

					@Override
					public void onAnimationStart(Animator p1)
					{
						// TODO: Implement this method
					}

					@Override
					public void onAnimationEnd(Animator p1)
					{
						h.onAnimEnd();
						v.setVisibility(View.GONE);
						// TODO: Implement this method
					}

					@Override
					public void onAnimationCancel(Animator p1)
					{
						// TODO: Implement this method
					}

					@Override
					public void onAnimationRepeat(Animator p1)
					{
						// TODO: Implement this method
					}
				});
		}
	}
}
