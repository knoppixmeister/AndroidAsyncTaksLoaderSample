package bizapps.lv.asyncloadertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        getSupportFragmentManager().beginTransaction()
                                    .add(R.id.fragment_place, new AppListFragment())
                                    .commit();
    }
}
