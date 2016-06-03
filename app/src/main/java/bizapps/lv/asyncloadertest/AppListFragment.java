package bizapps.lv.asyncloadertest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import java.util.List;

public class AppListFragment extends ListFragment implements LoaderManager.LoaderCallbacks<List<String>> {
    private AppListAdapter adapter;

    public AppListFragment() {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setEmptyText("No data");

        adapter = new AppListAdapter(getActivity());
        setListAdapter(adapter);

        setListShown(false);

        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<List<String>> onCreateLoader(int id, Bundle args) {
        return new AppListLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<List<String>> loader, List<String> data) {
        adapter.setData(data);

        if(isResumed()) setListShown(true);
        else setListShownNoAnimation(true);
    }

    @Override
    public void onLoaderReset(Loader<List<String>> loader) {
        adapter.setData(null);
    }
}
