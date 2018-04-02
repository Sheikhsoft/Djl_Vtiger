package vtiger.djl.william.djl_vtiger.Activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import vtiger.djl.william.djl_vtiger.Activities.Base.BaseActivity;
import vtiger.djl.william.djl_vtiger.Adapters.ViewPagerAdapter;
import vtiger.djl.william.djl_vtiger.R;

public class ProjectActivity extends BaseActivity {

    private TabLayout mtbLayoutProject;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    //Indice de posiciones de los tabs
    public static final int PROJECT_RESUMEN_TAB = 0;
    public static final int PROJECT_DETAILS_TAB = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        setToolbar();
        setTabLayout();
        setViewPager();
        setListenerTabLayout(viewPager);
    }

    private void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setTabLayout() {
        mtbLayoutProject = findViewById(R.id.tabLayout);
        mtbLayoutProject.addTab(mtbLayoutProject.newTab().setText("Resumen"));
        mtbLayoutProject.addTab(mtbLayoutProject.newTab().setText("Detalles"));
    }

    private void setViewPager() {
        viewPager = findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), this, mtbLayoutProject.getTabCount());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mtbLayoutProject));
    }

    private void setListenerTabLayout(final ViewPager viewPager) {
        mtbLayoutProject.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }
}
