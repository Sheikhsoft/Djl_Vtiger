package vtiger.djl.william.djl_vtiger.Splash;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import vtiger.djl.william.djl_vtiger.Activities.Base.BaseActivity;
import vtiger.djl.william.djl_vtiger.Activities.LoginActivity;
import vtiger.djl.william.djl_vtiger.Activities.MainActivity;
import vtiger.djl.william.djl_vtiger.Utils.Util;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        Intent intentLogin = new Intent(this, LoginActivity.class);
        Intent intentMain = new Intent(this, MainActivity.class);
        startActivity(intentLogin);
        /*
        if (Util.getSessionPrefs(prefs) == "1"){
            startActivity(intentMain);
        }else{
            startActivity(intentLogin);
        }*/
        finish();
    }
}
