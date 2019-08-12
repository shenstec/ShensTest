package shens.android.shenstest.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import shens.android.shenstest.R;

/**
 * @ProjectName: ShensTest
 * @Package: shens.android.shenstest.widget
 * @ClassName: SheetDialog
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019/7/22 3:22 PM
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/7/22 3:22 PM
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 * @website: http://www.hitucao.com
 */
public class SheetDialog extends Dialog {

    @BindView(R.id.lv_dialog_sheet_menus)
    ListView lvMenus;

    @BindView(R.id.tv_dialog_sheet_cancle_btn)
    TextView tvCancle;




    private List<String> mMenus = new ArrayList<>();

    private Context mContxt;
    private OnMenuSelectListener mOnMenuSelectListener;



    private SheetDialog(Context context,List<String> menus) {
        super(context,R.style.MyDialog);
        this.mMenus = menus;
        this.mContxt = context;

        Window window = getWindow();//获取当前窗口
        window.getDecorView().setPadding(0,0,0,0);
        window.setGravity(Gravity.BOTTOM); //置于底部显示


        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height =WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
        initView();

        initData();
        initLister();
    }

    public void setOnMenuSelect(OnMenuSelectListener onMenuSelectListener){
        mOnMenuSelectListener = onMenuSelectListener;
    }

    private void initLister() {
        tvCancle.setOnClickListener((v)->dismiss());
        lvMenus.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(mOnMenuSelectListener!=null)
                    mOnMenuSelectListener.onSelect(position);
                dismiss();
            }
        });

    }

    private void initData() {

        lvMenus.setAdapter(new ArrayAdapter<String>(mContxt,android.R.layout.simple_list_item_1,mMenus));

    }

    private void initView() {

        View view = LayoutInflater.from(mContxt).inflate(R.layout.dialog_sheet_view,null);
        ButterKnife.bind(this,view);
        super.setContentView(view);

    }

    public static SheetDialog buildDialog(Context context,List<String> menus){
        return  new SheetDialog(context,menus);
    }

    public interface OnMenuSelectListener{
        public void onSelect(int position);
    }
}
