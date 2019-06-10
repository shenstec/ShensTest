package shens.android.shenstest.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;


/**
 * 自定义view测试
 */
public class MyView extends View {


    private Paint paint;

    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context,  AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //布局的宽高都是有这个方法指定
        //指定控件的宽高,需要测量
        //获取宽高的模式
        int widthModel = MeasureSpec.getMode(widthMeasureSpec);
        int heightmodel = MeasureSpec.getMode(heightMeasureSpec);
        /**
         * MeasureSpec.AT_MOST : 在布局中指定了wrap_content
         * MeasureSpec.EXACTLY : 在不居中指定了确切的值  100dp   match_parent  fill_parent
         * MeasureSpec.UNSPECIFIED : 尽可能的大,很少能用到，ListView , ScrollView 在测量子布局的时候会用UNSPECIFIED
         */
        //获取宽高的大小

        //1.确定的值，这时候不需要计算的
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        //2.不确定的值，wrap_content 需要计算

        setMeasuredDimension(width,height);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint= new Paint();
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.STROKE);//填充样式改为描边
        paint.setStrokeWidth(5);//设置画笔宽度

        Path path = new Path();

        path.moveTo(100, 100); //设定起始点
        path.lineTo(100, 800);//第一条直线的终点，也是第二条直线的起点
        path.lineTo(800, 800);//画第二条直线
        path.lineTo(800, 1000);//第三条直线
        path.close();//闭环

        canvas.drawPath(path, paint);
    }


}
