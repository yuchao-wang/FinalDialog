package wang.yuchao.android.library.view.dialog.sample;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import wang.yuchao.android.library.view.dialog.custom.ConfirmDialog;
import wang.yuchao.android.library.view.dialog.custom.MenuDialog;
import wang.yuchao.android.library.view.dialog.custom.NormalDialog;
import wang.yuchao.android.library.view.dialog.custom.ProgressDialog;
import wang.yuchao.android.library.view.dialog.custom.ToastDialog;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ConfirmDialog confirmDialog = new ConfirmDialog(MainActivity.this);
                confirmDialog.setTitleText("确定删除吗？")
                        .setOnConfirmClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                confirmDialog.cancel();
                            }
                        })
                        .show();
            }
        });

        findViewById(R.id.button04).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<MenuDialog.Menu> allMenu = new ArrayList<MenuDialog.Menu>();
                for (int i = 0; i < 5; i++) {
                    MenuDialog.Menu menu = new MenuDialog.Menu();
                    menu.text = "按钮" + i;
                    if (i != 3) {
                        menu.background = R.mipmap.ic_launcher;
                    }
                    allMenu.add(menu);
                }

                final MenuDialog menuDialog = new MenuDialog(MainActivity.this);
                menuDialog.setCanBeCanceled(true)
                        .setTitleText("请选择种类")
                        .setMenu(allMenu)
                        .setPosition(MenuDialog.Position.BOTTOM)
                        .setCanBeCanceledTouchOutSide(false)
                        .setOnCanceledListener(new DialogInterface.OnCancelListener() {
                            @Override
                            public void onCancel(DialogInterface dialog) {
                                Toast.makeText(MainActivity.this, "取消......", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });

        findViewById(R.id.button06).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("这是NormalDialog，title,button,content可根据需求灵活组装");
                for (int i = 0; i < 1000; i++) {
                    stringBuffer.append("王玉超" + i);
                }

                final NormalDialog normalDialog = new NormalDialog(MainActivity.this);
                normalDialog
                        .setCanBeCanceled(true)
                        .setCanBeCanceledTouchOutSide(false)
                        .setOnCanceledListener(new DialogInterface.OnCancelListener() {
                            @Override
                            public void onCancel(DialogInterface dialog) {
                            }
                        })
                        .setTitleText("确定退出吗？")
                        .setContentText(stringBuffer.toString())
                        .setButtonLeft("取消", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                normalDialog.cancel();
                            }
                        })
                        .setButtonRight("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                normalDialog.cancel();
                            }
                        })
                        .show();
            }
        });

        findViewById(R.id.button07).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog
                        .setCanBeCanceled(true)
                        .setCanBeCanceledTouchOutSide(false)
                        .setProgressText("已经加载50%")
                        .setOnCanceledListener(new DialogInterface.OnCancelListener() {
                            @Override
                            public void onCancel(DialogInterface dialog) {
                                Toast.makeText(MainActivity.this, "取消...", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });


        findViewById(R.id.button08).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ToastDialog toastDialog = new ToastDialog(MainActivity.this);
                toastDialog.setCanBeCanceled(true)
                        .setGravity(Gravity.CENTER)
                        .setCanBeCanceledTouchOutSide(false)
                        .setOnCanceledListener(new DialogInterface.OnCancelListener() {
                            @Override
                            public void onCancel(DialogInterface dialog) {
                                Toast.makeText(MainActivity.this, "取消啦...", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setDuration(3000)
                        .setTitleText("友情提醒")
                        .setContentText("您的申请已经提交成功，需要2-3个工作日才能审核完成，请留意短信通知，即将跳转到审核页面！")
                        .show();

            }
        });
    }
}
