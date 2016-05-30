package wang.yuchao.android.library.view.dialog.custom;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import wang.yuchao.android.library.view.dialog.R;
import wang.yuchao.android.library.view.dialog.base.BaseDialog;

/**
 * 链式结构
 * <pre>
 *  ===============================
 *  |           title             |
 *  |-----------------------------|
 *  | context                     |
 *  |-----------------------------|
 *  |  left  |  center  |  right  |
 *  ===============================
 * </pre>
 * Created by wangyuchao on 16/5/14.
 */
public class NormalDialog extends BaseDialog<NormalDialog> {

    private View rootView;

    private LinearLayout containerView;

    private TextView tv_title;
    private TextView tv_content;
    private TextView tv_left;
    private TextView tv_center;
    private TextView tv_right;

    private String title;
    private String content;

    private String textLeft;
    private View.OnClickListener onClickListenerLeft;
    private String textCenter;
    private View.OnClickListener onClickListenerCenter;
    private String textRight;
    private View.OnClickListener onClickListenerRight;

    public NormalDialog(Activity activity) {
        super(activity);
        rootView = View.inflate(mActivity, R.layout.dialog_normal, null);

        containerView = (LinearLayout) rootView.findViewById(R.id.ll_container);

        tv_title = (TextView) rootView.findViewById(R.id.tv_title);
        tv_content = (TextView) rootView.findViewById(R.id.tv_content);
        tv_left = (TextView) rootView.findViewById(R.id.tv1);
        tv_center = (TextView) rootView.findViewById(R.id.tv2);
        tv_right = (TextView) rootView.findViewById(R.id.tv3);
    }

    public NormalDialog setTitleText(String title) {
        this.title = title;
        return this;
    }

    public NormalDialog setContentText(String content) {
        this.content = content;
        return this;
    }

    public NormalDialog setButtonLeft(String text, View.OnClickListener onClickListener) {
        this.textLeft = text;
        this.onClickListenerLeft = onClickListener;
        return this;
    }

    public NormalDialog setButtonCenter(String text, View.OnClickListener onClickListener) {
        this.textCenter = text;
        this.onClickListenerCenter = onClickListener;
        return this;
    }

    public NormalDialog setButtonRight(String text, View.OnClickListener onClickListener) {
        this.textRight = text;
        this.onClickListenerRight = onClickListener;
        return this;
    }

    private void setViewLayout() {
        tv_title.setText(title);
        tv_title.setVisibility(TextUtils.isEmpty(title) ? View.GONE : View.VISIBLE);

        tv_content.setText(content);
        tv_content.setVisibility(TextUtils.isEmpty(content) ? View.GONE : View.VISIBLE);

        tv_left.setText(textLeft);
        tv_left.setOnClickListener(onClickListenerLeft);

        tv_center.setText(textCenter);
        tv_center.setOnClickListener(onClickListenerCenter);

        tv_right.setText(textRight);
        tv_right.setOnClickListener(onClickListenerRight);

        if (TextUtils.isEmpty(textLeft) || onClickListenerLeft == null) {
            tv_left.setVisibility(View.GONE);
            rootView.findViewById(R.id.line1).setVisibility(View.GONE);
        }

        if (TextUtils.isEmpty(textCenter) || onClickListenerCenter == null) {
            tv_center.setVisibility(View.GONE);
            rootView.findViewById(R.id.line1).setVisibility(View.GONE);
        }

        if (TextUtils.isEmpty(textRight) || onClickListenerRight == null) {
            tv_right.setVisibility(View.GONE);
            rootView.findViewById(R.id.line2).setVisibility(View.GONE);
        }
    }

    @Override
    public void show() {
        setViewLayout();
        create(rootView);
        super.show();
    }

    /*=======================暴露布局内的参数给外部调用，方便自定义=============================*/

    public LinearLayout getContainerView() {
        return containerView;
    }

    public TextView getTitleView() {
        return tv_title;
    }

    public TextView getContentView() {
        return tv_content;
    }

    public TextView getLeftView() {
        return tv_left;
    }

    public TextView getCenterView() {
        return tv_center;
    }

    public TextView getRightView() {
        return tv_right;
    }
}
