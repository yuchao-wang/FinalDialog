package wang.yuchao.android.library.view.dialog.custom;

import android.app.Activity;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import wang.yuchao.android.library.view.dialog.R;
import wang.yuchao.android.library.view.dialog.base.BaseDialog;

/**
 * ================
 * |   toast      |
 * ================
 * Created by wangyuchao on 16/5/14.
 */
public class ToastDialog extends BaseDialog<ToastDialog> {

    private View rootView;

    private LinearLayout ll_container;
    private TextView tv_title;
    private TextView tv_content;

    private String title;
    private String content;

    private long duration;

    public ToastDialog(Activity activity) {
        super(activity);

        rootView = View.inflate(mActivity, R.layout.dialog_toast, null);

        ll_container = (LinearLayout) rootView.findViewById(R.id.ll_container);

        tv_title = (TextView) rootView.findViewById(R.id.tv_title);
        tv_content = (TextView) rootView.findViewById(R.id.tv_content);

        tv_content.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    public ToastDialog setTitleText(String title) {
        this.title = title;
        return this;
    }

    public ToastDialog setContentText(String content) {
        this.content = content;
        return this;
    }

    public ToastDialog setDuration(long duration) {
        this.duration = duration;
        return this;
    }

    @Override
    public void show() {
        setViewLayout();
        create(rootView);
        super.show();
    }

    private void setViewLayout() {

        tv_title.setText(title);
        tv_title.setVisibility(TextUtils.isEmpty(title) ? View.GONE : View.VISIBLE);

        tv_content.setText(content);
        tv_content.setVisibility(TextUtils.isEmpty(content) ? View.GONE : View.VISIBLE);

        if (duration > 0) {
            rootView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    cancel();
                }
            }, duration);
        }
    }

    /*=============接口暴露给外面，方便自定义UI==============*/


    public LinearLayout getContainerView() {
        return ll_container;
    }

    public TextView getTitleView() {
        return tv_title;
    }

    public TextView getContentView() {
        return tv_content;
    }
}
