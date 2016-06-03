package bizapps.lv.asyncloadertest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class AppListAdapter extends BaseAdapter {
    private Context ctx;
    private List<String> results;

    public AppListAdapter(Context ctx) {
        this.ctx = ctx;
    }

    public void setData(List<String> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return results != null ? results.size() : 0;
    }

    @Override
    public String getItem(int i) {
        return results.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = LayoutInflater.from(ctx).inflate(R.layout.list_item, viewGroup, false);
        }

        TextView tv1 = (TextView) view.findViewById(R.id.textView);
        tv1.setText(getItem(i));

        return view;
    }
}
