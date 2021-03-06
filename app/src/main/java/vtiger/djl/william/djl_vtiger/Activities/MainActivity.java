package vtiger.djl.william.djl_vtiger.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import vtiger.djl.william.djl_vtiger.Activities.Base.BaseActivity;
import vtiger.djl.william.djl_vtiger.Fragments.ActividadesFragment;
import vtiger.djl.william.djl_vtiger.Fragments.DashBoardFragment;
import vtiger.djl.william.djl_vtiger.Fragments.HitosFragment;
import vtiger.djl.william.djl_vtiger.Fragments.ProyectoFragment;
import vtiger.djl.william.djl_vtiger.Models.Users;
import vtiger.djl.william.djl_vtiger.R;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private TextView mtvNombreUser;
    private Bundle datosRecibidos;
    private View navHeader;
    private Users user = new Users();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navview);
        navHeader = navigationView.getHeaderView(0);
        setFragmentByDefault();
        navigationView.setNavigationItemSelectedListener(this);
        successLogin();
        /*
        if (Util.getSessionPrefs(prefs)=="1"){
            mtvNombreUser.setText(Util.getNamePrefs(prefs)+" "+Util.getSurnamePrefs(prefs));
        }else {
            successLogin();
        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action, menu);
        return super.onCreateOptionsMenu(menu);
    }



    private void successLogin(){
        datosRecibidos = getIntent().getExtras();
        user.setFirst_name(datosRecibidos.getString("nom"));
        user.setLast_name(datosRecibidos.getString("ape"));

        if (user!=null){
            navHeader = navigationView.getHeaderView(0);
            mtvNombreUser = navHeader.findViewById(R.id.tvUserName);
            mtvNombreUser.setText(user.getFirst_name()+" "+user.getLast_name());
        }else{
            Toast.makeText(this,"Error al recibir los datos",Toast.LENGTH_SHORT).show();
        }
    }

    private void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setFragmentByDefault() {
        changeFragment(new DashBoardFragment(), navigationView.getMenu().getItem(0));
    }

    private void changeFragment(Fragment fragment, MenuItem item) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
        item.setChecked(true);
        getSupportActionBar().setTitle(item.getTitle());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.menu_logout:
                Toast.makeText(getApplicationContext(), "Este es el Log Out", Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        boolean fragmentTransaction = false;
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.menu_proyecto:
                fragment = new ProyectoFragment();
                fragmentTransaction = true;
                break;
            case R.id.menu_hitos:
                fragment = new HitosFragment();
                fragmentTransaction = true;
                break;
            case R.id.menu_actividades:
                fragment = new ActividadesFragment();
                fragmentTransaction = true;
                break;
            case R.id.menu_dashboard:
                fragment = new DashBoardFragment();
                fragmentTransaction = true;
                break;
        }

        if (fragmentTransaction){
            changeFragment(fragment,item);
            drawerLayout.closeDrawers();
        }
        return true;
    }
}
