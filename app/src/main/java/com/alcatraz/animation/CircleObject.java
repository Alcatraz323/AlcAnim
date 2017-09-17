package com.alcatraz.animation;
import android.view.*;
import android.transition.*;
import android.graphics.*;
import android.util.*;
import android.content.*;

public class CircleObject extends View
{
	//Pt
	Paint p=new Paint();
	//Args
	String color="#3f51b5";
	int[] shadow={10,5,10};
	String shadowColor="#787878";
	int DEF_WIDTH_HEIGHT=dp2px(getContext(),56);
	int mWidth=0;
	int mHeight=0;
	public static int dp2px(Context context, float dpVal)  
	{  
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dpVal, context.getResources().getDisplayMetrics());
	}  
	public CircleObject(android.content.Context context) {
		super(context);
	}

    public CircleObject(android.content.Context context, android.util.AttributeSet attrs) {
		super(context,attrs);
		
	}
	public CircleObject(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
	public void setViewSize(int width,int height){
        ViewGroup.LayoutParams params = getLayoutParams();
        params.width = width;
        params.height = height;
        setLayoutParams(params);
    }
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
		//判断当属性为wrap_content的时候
        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(DEF_WIDTH_HEIGHT,DEF_WIDTH_HEIGHT);
        }
        else if (widthMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(DEF_WIDTH_HEIGHT,heightSize);
        }
        else if (heightMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(widthSize,DEF_WIDTH_HEIGHT);
        }
        else {
            super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        }
	}
	public void testInstance(){};
	@Override
	protected void onDraw(Canvas canvas)
	{
		
		// TODO: Implement this method
		super.onDraw(canvas);
		initPaintBasicProperty();
		mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
        //获取半径
        int radium = Math.min(mWidth,mHeight)/2;
        //画圆
        canvas.drawCircle(mWidth/2,mHeight/2,radium,p);
		Log.e("Alcn",DEF_WIDTH_HEIGHT+"");
	}
	public void setColor(String rgba){
		color=rgba;
		invalidate();
	}
	public void setShadow(int[] s){
		shadow=s;
		invalidate();
	}
	public void initPaintBasicProperty(){
		p.setAntiAlias(true);
		p.setShadowLayer(shadow[0],shadow[1],shadow[2],Color.GRAY);
		p.setStyle(Paint.Style.FILL);
		p.setColor(Color.parseColor(color));
	}
}
