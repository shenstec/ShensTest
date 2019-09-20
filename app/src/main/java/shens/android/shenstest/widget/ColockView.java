package shens.android.shenstest.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Calendar;

import shens.android.shenstest.R;


/**
 * 自定义view测试
 */
public class ColockView extends View {


    private Paint paint;//画笔
    private float width;//宽度
    private int longColor;//时刻度颜色
    private int shortColor;//分刻度颜色
    private float textSize;//文字显示颜色

    private String title="";



    public ColockView(Context context) {
        this(context,null);
    }

    public ColockView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ColockView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        obtainStyledAttrs(attrs);
        initPaint();
        //获取屏幕宽度
        int widthPixels = context.getResources().getDisplayMetrics().widthPixels;
        //获取屏幕高度
        int heightPixels = context.getResources().getDisplayMetrics().heightPixels;
        // 默认和屏幕的宽高最小值相等
        width = Math.min(widthPixels, heightPixels);
    }

    /**
     * 初始化获取属性配置
     * @param attrs
     */
    private void obtainStyledAttrs(AttributeSet attrs){
        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.ColockView);
        textSize = array.getDimension(R.styleable.ColockView_text_size,20);
        longColor = array.getColor(R.styleable.ColockView_long_color,getResources().getColor(R.color.colorAccent));
        shortColor = array.getColor(R.styleable.ColockView_short_color,getResources().getColor(R.color.colorAccent));
        title = array.getString(R.styleable.ColockView_title_text);
        array.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//
        setMeasuredDimension(measureSize(widthMeasureSpec),measureSize(heightMeasureSpec));


    }

    // 这里不用管测量模式是什么，因为咱们有屏幕短边保底，只取其中一个小值即可。测量宽高和屏幕短边作对比，返回最小值
    private int measureSize(int measureSpec) {
        int size=MeasureSpec.getSize(measureSpec);
        width=Math.min(width,size);
        return (int) width;
    }

    /**
     * 初始化画笔
     */
    private void initPaint(){
        paint= new Paint();

        paint.setColor(longColor);  //设置画笔颜色
        paint.setStyle(Paint.Style.STROKE);//填充样式改为描边
        paint.setTextSize(textSize);//绘制文字大小 单位px
        paint.setStrokeWidth(5);//设置画笔宽度
        paint.setAntiAlias(true);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制表盘外圈
        drawCircle(canvas);

//        canvas.translate(-width/12,-width/3+75);
        //绘制表盘名称

        Paint textPaint = new Paint();
        textPaint.setTextSize(textSize);
        textPaint.setStrokeWidth(1);
        if(!TextUtils.isEmpty(title)){
            Rect titleRect = new Rect();
            textPaint.getTextBounds(title,0,title.length(),titleRect);

            float thlf = titleRect.width()/2.0f;
            Log.d("Client","标题长度一半>>>>>"+thlf);
            canvas.drawText(title,width/2.0f-thlf,width/3,textPaint);
            canvas.restore();
        }



        int count = 60;
        int lineWidth = 40;
        for(int i = 0;i<count;i++){
            if(i%5==0){
                //时刻度
                paint.setStrokeWidth(2);
                paint.setColor(longColor);
                lineWidth = 40;
                String text = String.valueOf(i/5==0?12:i/5);

                Rect textRect = new Rect();
                textPaint.getTextBounds(text,0,text.length(),textRect);
                canvas.drawText(text,width/2-textRect.width()/2,textRect.height()+lineWidth+10,textPaint);
            }else{
                //分刻度
                lineWidth = 30;
                paint.setColor(shortColor);
                paint.setStrokeWidth(1);
            }
            canvas.drawLine(width/2,0,width/2,lineWidth,paint);
            canvas.rotate(6,width/2,width/2); //旋转画纸
        }

        //绘制指针
        drawPointer(canvas);

        postInvalidateDelayed(1000);
    }

    private void drawCircle(Canvas canvas){
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        canvas.drawCircle(width/2,width/2,width/2,paint);
        canvas.save();

    }

    //绘制指针
    private void drawPointer(Canvas canvas){
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);// 时
        int minute = calendar.get(Calendar.MINUTE);// 分
        int second = calendar.get(Calendar.SECOND);// 秒

        float angleHour = (hour + (float) minute / 60) * 360 / 12;
        float angleMinute = (minute + (float) second / 60) * 360 / 60;
        float angleSecond = second*6;
        //绘制时针
        canvas.save();
        Log.d("Client",hour+"angleHour>>>>>"+angleHour);
        canvas.rotate(angleHour-180,width/2,width/2); //旋转画纸
        RectF rectFHour = new RectF(width/2-5,width/2,width/2+5,width/2+width/2/3);
        paint.setColor(shortColor);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5);
        canvas.drawRect(rectFHour,paint);
        canvas.restore();
        //绘制分针
        canvas.save();
        canvas.rotate(angleMinute-180,width/2,width/2); //旋转画纸
        RectF rectFMin = new RectF(width/2-5,width/2,width/2+5,width/2+width/2/3*2);
        paint.setColor(longColor);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5);
        canvas.drawRect(rectFMin,paint);
        canvas.restore();

        //绘制秒针
        Log.d("Client",second+"angleHour>>>>>"+angleSecond);
        canvas.save();
        canvas.rotate(angleSecond-180,width/2,width/2); //旋转画纸
        RectF rectFSecond = new RectF(width/2-5,width/2,width/2+5,width/2+width/2/3*2);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5);
        canvas.drawRect(rectFSecond,paint);
        canvas.restore();

        //绘制表芯
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(width/2,width/2,10,paint);
    }


}
