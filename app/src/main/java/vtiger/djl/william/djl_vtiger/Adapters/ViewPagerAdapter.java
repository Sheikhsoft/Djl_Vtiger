package vtiger.djl.william.djl_vtiger.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import vtiger.djl.william.djl_vtiger.Fragments.ProjectDetailFragment;
import vtiger.djl.william.djl_vtiger.Fragments.ProjectResumeFragment;

import static vtiger.djl.william.djl_vtiger.Activities.ProjectActivity.PROJECT_DETAILS_TAB;
import static vtiger.djl.william.djl_vtiger.Activities.ProjectActivity.PROJECT_RESUMEN_TAB;

/**
 * Created by William on 02/04/2018.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private int numberOfTabs;

    public ViewPagerAdapter(FragmentManager fm, Context context, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case PROJECT_RESUMEN_TAB:
                return new ProjectResumeFragment();
            case PROJECT_DETAILS_TAB:
                return new ProjectDetailFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
