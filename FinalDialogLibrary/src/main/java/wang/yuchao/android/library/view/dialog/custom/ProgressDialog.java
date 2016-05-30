package wang.yuchao.android.library.view.dialog.custom;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import wang.yuchao.android.library.view.dialog.R;
import wang.yuchao.android.library.view.dialog.base.BaseDialog;

/**
 * 分为有进度和没有进度
 * Created by wangyuchao on 16/5/14.
 */
public class ProgressDialog extends BaseDialog<ProgressDialog> {

    private View rootView;

    private ProgressBar progressBar;
    private TextView tv_progress;
    private LinearLayout ll_container;

    public ProgressDialog(Activity activity) {
        super(activity);

        rootView = View.inflate(mActivity, R.layout.dialog_progress, null);

        this.progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);
        this.tv_progress = (TextView) rootView.findViewById(R.id.tv_progress);
        this.ll_container = (LinearLayout) rootView.findViewById(R.id.ll_container);
    }

    public ProgressDialog setProgressText(String text) {
        tv_progress.setText(text);
        return this;
    }

    @Override
    public void show() {
        setGravity(Gravity.CENTER | Gravity.LEFT | Gravity.RIGHT);
        create(rootView);
        super.show();
    }

    //====================暴露给外面使用====================//

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public TextView getTextView() {
        return tv_progress;
    }

    public LinearLayout getContainerView() {
        return ll_container;
    }
}
