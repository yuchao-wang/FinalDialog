package wang.yuchao.android.library.view.dialog.custom;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import wang.yuchao.android.library.view.dialog.R;
import wang.yuchao.android.library.view.dialog.base.BaseDialog;

/**
 * 确认对话框（主要用来警告）
 * Created by wangyuchao on 16/5/14.
 */
public class ConfirmDialog extends BaseDialog<ConfirmDialog> {

    public TextView tv_title;
    public Button btn_confirm;
    public Button btn_cancel;
    public LinearLayout ll_container;
    private View rootView;

    public ConfirmDialog(Activity activity) {
        super(activity);
        rootView = View.inflate(mActivity, R.layout.dialog_confirm, null);

        this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
        this.btn_confirm = (Button) rootView.findViewById(R.id.btn_confirm);
        this.btn_cancel = (Button) rootView.findViewById(R.id.btn_cancel);
        this.ll_container = (LinearLayout) rootView.findViewById(R.id.ll_container);
    }

    public ConfirmDialog setTitleText(String titleText) {
        this.tv_title.setText(titleText);
        return this;
    }

    public ConfirmDialog setConfirmText(String confirmText) {
        this.btn_confirm.setText(confirmText);
        return this;
    }

    public ConfirmDialog setOnConfirmClickListener(View.OnClickListener onClickListener) {
        this.btn_confirm.setOnClickListener(onClickListener);
        return this;
    }

    public ConfirmDialog setCancelText(String cancelText) {
        this.btn_cancel.setText(cancelText);
        return this;
    }

    public ConfirmDialog setOnCancelClickListener(View.OnClickListener onClickListener) {
        this.btn_cancel.setOnClickListener(onClickListener);
        return this;
    }

    @Override
    public void show() {

        setWindowAnimation(R.style.BottomDialog);
        setGravity(Gravity.BOTTOM | Gravity.LEFT | Gravity.RIGHT);

        create(rootView);

        super.show();
    }

    //================暴露给外面调用================//

    public TextView getTitleView() {
        return tv_title;
    }

    public Button getConfirmButton() {
        return btn_confirm;
    }

    public Button getCancelButton() {
        return btn_cancel;
    }

    public LinearLayout getContainerView() {
        return ll_container;
    }
}
