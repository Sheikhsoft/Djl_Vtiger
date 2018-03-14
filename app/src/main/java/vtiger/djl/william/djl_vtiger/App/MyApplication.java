package vtiger.djl.william.djl_vtiger.App;

import android.app.Application;
import android.os.SystemClock;

/**
 * Created by William on 13/03/2018.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(3000);
    }
}
