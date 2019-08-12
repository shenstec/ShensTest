package shens.android.shenstest.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * @ProjectName: ShensTest
 * @Package: shens.android.shenstest.widget
 * @ClassName: TestButton
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/7/18 9:59 AM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/7/18 9:59 AM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */
@SuppressLint("AppCompatCustomView")
public class TestButton extends TextView {
    public TestButton(Context context) {
        super(context);
    }

    public TestButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {




        return super.onTouchEvent(event);
    }
}
