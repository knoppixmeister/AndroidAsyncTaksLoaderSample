package bizapps.lv.asyncloadertest;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AppListLoader extends AsyncTaskLoader<List<String>> {
    List<String> results;

    public AppListLoader(Context ctx) {
        super(ctx);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();

        if(results != null) {
            deliverResult(results);
        }
        if(takeContentChanged() || results == null) {
            forceLoad();
        }
    }

    @Override
    public List<String> loadInBackground() {
        List<String> res = new ArrayList<>();

        for(int i=0; i<10; i++) {
            res.add(UUID.randomUUID().toString());
        }

        return res;
    }

    @Override
    public void deliverResult(List<String> data) {
        if(isReset()) {
        }

        this.results = data;

        if(isStarted()) {
            super.deliverResult(data);
        }
    }

    @Override
    protected void onStopLoading() {
        //super.onStopLoading();

        cancelLoad();
    }

    @Override
    public void onCanceled(List<String> data) {
        super.onCanceled(data);
    }
}
