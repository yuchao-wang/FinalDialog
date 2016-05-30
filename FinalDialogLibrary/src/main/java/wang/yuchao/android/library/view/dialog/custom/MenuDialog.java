package wang.yuchao.android.library.view.dialog.custom;

import android.app.Activity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import wang.yuchao.android.library.view.dialog.R;
import wang.yuchao.android.library.view.dialog.base.BaseDialog;

/**
 * 菜单对话框：肯定是单选：
 * Created by wangyuchao on 16/5/16.
 */
public class MenuDialog extends BaseDialog<MenuDialog> {

    private View rootView;

    private LinearLayout ll_container;
    private TextView tv_title;
    private ListView listView;

    private Position position = Position.CENTER;

    private String title;

    private ArrayList<Menu> allMenu = new ArrayList<Menu>();

    public MenuDialog(Activity activity) {
        super(activity);
        rootView = View.inflate(mActivity, R.layout.dialog_menu, null);

        this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
        this.listView = (ListView) rootView.findViewById(R.id.listView);
        this.ll_container = (LinearLayout) rootView.findViewById(R.id.ll_container);
    }

    public MenuDialog setTitleText(String title) {
        this.title = title;
        return this;
    }

    public MenuDialog setMenu(ArrayList<Menu> allMenu) {
        this.allMenu = allMenu;
        return this;
    }

    @Override
    public void show() {
        setView();

        if (position == Position.BOTTOM) {
            setWindowAnimation(R.style.BottomDialog);
            setGravity(Gravity.BOTTOM | Gravity.LEFT | Gravity.RIGHT);
        } else if (position == Position.TOP) {
            setGravity(Gravity.TOP | Gravity.LEFT | Gravity.RIGHT);
            setWindowAnimation(R.style.TopDialog);
        } else {//中间弹出来
        }

        create(rootView);
        super.show();
    }

    private void setView() {
        tv_title.setText(title);
        tv_title.setVisibility(TextUtils.isEmpty(title) ? View.GONE : View.VISIBLE);

        if (allMenu != null && allMenu.size() > 0) {
            this.listView.setAdapter(new BaseAdapter() {
                @Override
                public int getCount() {
                    return allMenu.size();
                }

                @Override
                public Object getItem(int position) {
                    return allMenu.get(position);
                }

                @Override
                public long getItemId(int position) {
                    return position;
                }

                @Override
                public View getView(int position, View view, ViewGroup parent) {
                    Menu menu = allMenu.get(position);

                    ViewHolder holder = null;
                    if (view == null) {
                        view = LayoutInflater.from(mActivity).inflate(R.layout.menu_item, null);
                        holder = new ViewHolder(view);
                        view.setTag(holder);
                    } else {
                        holder = (ViewHolder) view.getTag();
                    }

                    holder.tv_name.setText(menu.text);
                    if (menu.background == 0) {
                        holder.iv_icon.setVisibility(View.GONE);
                    } else {
                        holder.iv_icon.setVisibility(View.VISIBLE);
                        holder.iv_icon.setBackgroundResource(menu.background);
                    }
                    return view;
                }

                class ViewHolder {
                    public TextView tv_name;
                    public ImageView iv_icon;

                    public ViewHolder(View view) {
                        this.tv_name = (TextView) view.findViewById(R.id.tv_name);
                        this.iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
                    }
                }
            });
        }

    }

    public MenuDialog setPosition(Position position) {
        this.position = position;
        return this;
    }

    public MenuDialog setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        if (this.listView != null) {
            this.listView.setOnItemClickListener(onItemClickListener);
        }
        return this;
    }


    //====================暴露给外部用====================//

    public TextView getTitleView() {
        return tv_title;
    }

    public ListView getListView() {
        return listView;
    }

    public LinearLayout getContainerView() {
        return ll_container;
    }


    public enum Position {
        BOTTOM, CENTER, TOP
    }

    public static class Menu {
        public String text;
        public int background;
    }
}
