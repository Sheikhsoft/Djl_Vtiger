package vtiger.djl.william.djl_vtiger.Splash;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import vtiger.djl.william.djl_vtiger.Activities.LoginActivity;

public class SplashActivity extends AppCompatActivity {
    private SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        Intent intentLogin = new Intent(this, LoginActivity.class);
        startActivity(intentLogin);
        finish();
    }
}
