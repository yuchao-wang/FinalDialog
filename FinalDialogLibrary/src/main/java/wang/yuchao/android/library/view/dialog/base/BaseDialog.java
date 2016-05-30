package wang.yuchao.android.library.view.dialog.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import wang.yuchao.android.library.view.dialog.R;

/**
 * @param <T> T extends BaseDialog
 */
public class BaseDialog<T extends BaseDialog> extends Dialog {

    protected Activity mActivity;

    private int mGravity;
    private int mStyleAnimationRes;

    public BaseDialog(Activity activity) {
        super(activity, R.style.FullScreenDialog);//固定为全屏
        this.mActivity = activity;
    }

    protected void create(View view) {
        Window window = getWindow();

        window.setGravity(mGravity);
        window.setWindowAnimations(mStyleAnimationRes);
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(view);

        // TODO: 16/5/24  
//        window.getDecorView().setPadding(0, 0, 0, 0);
//        WindowManager.LayoutParams layoutParams = window.getAttributes();
//        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
//        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        window.setAttributes(layoutParams);

//        WindowManager.LayoutParams attrs = getWindow().getAttributes();
//        attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
//        getWindow().setAttributes(attrs);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    public T setWindowAnimation(int styleAnimationRes) {
        this.mStyleAnimationRes = styleAnimationRes;
        return (T) this;
    }

    public T setGravity(int gravity) {
        this.mGravity = gravity;
        return (T) this;
    }

    /**
     * 返回键
     *
     * @param cancelable
     */
    public T setCanBeCanceled(boolean cancelable) {
        setCancelable(cancelable);
        return (T) this;
    }

    /**
     * 屏幕外触摸
     *
     * @param canBeCanceledTouchOutSide
     */
    public T setCanBeCanceledTouchOutSide(boolean canBeCanceledTouchOutSide) {
        setCanceledOnTouchOutside(canBeCanceledTouchOutSide);
        return (T) this;
    }

    public T setOnCanceledListener(OnCancelListener onCancelListener) {
        setOnCancelListener(onCancelListener);
        return (T) this;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void show() {
        try {
            if (mActivity == null || mActivity.isFinishing() || (Build.VERSION.SDK_INT >= 17 && mActivity.isDestroyed())) {
                return;
            }
            super.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cancel() {
        try {
            if (mActivity == null || mActivity.isFinishing() || (Build.VERSION.SDK_INT >= 17 && mActivity.isDestroyed())) {
                return;
            }
            super.cancel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}