package shens.android.shenstest.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * @ProjectName: ShensTest
 * @Package: shens.android.shenstest.widget
 * @ClassName: MyViewGroup
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/9/19 6:19 PM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/9/19 6:19 PM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */
public class MyViewGroup extends ViewGroup {
    public MyViewGroup(Context context) {
        super(context);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
