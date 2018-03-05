package com.ky.kitchies;

import android.app.FragmentManager;
import android.content.Intent;
import android.net.Network;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.NumberPicker;

public class Drawerlayout extends AppCompatActivity {

    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;
    private ShareActionProvider mShareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawerlayout);
        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerlayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerlayout.addDrawerListener(mToggle);
        NavigationView nvdrawer = (NavigationView) findViewById(R.id.navigationview);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(nvdrawer);
    }

    private void setShareIntent(Intent shareIntent) {
        if (mShareActionProvider != null) {
            mShareActionProvider.setShareIntent(shareIntent);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void selectItemDrawer(MenuItem menuitem) {
        Fragment myfragment = null;
        Class fragmentClass;
        switch (menuitem.getItemId()) {
            case R.id.nav_item_home:
                fragmentClass = HomeFragment.class;
                //Intent myintent2=new Intent(Drawerlayout.this,MainActivity.class);Drawerlayout.this.startActivity(myintent2);setTitle(menuitem.getTitle());
                setTitle(menuitem.getTitle());
                break;
            case R.id.nav_item_category:
                fragmentClass = CategoryFragment.class;
                setTitle(menuitem.getTitle());
                break;
            case R.id.nav_item_recent:
                fragmentClass = RecentlyViewFragment.class;
                setTitle(menuitem.getTitle());
                break;
            case R.id.nav_item_login:
                fragmentClass = LoginFragment.class;
                setTitle(menuitem.getTitle());
                break;
            case R.id.nav_item_rate:
                fragmentClass = HomeFragment.class;
                Uri uri = Uri.parse("market://details?id=");
                Intent myintentrate = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(myintentrate);
                setTitle("Home");
                break;
            case R.id.nav_item_share:
                fragmentClass = HomeFragment.class;
                Intent myintentshare = new Intent(Intent.ACTION_SEND);
                myintentshare.setType("text/plain");
                String shareSub = "Download Our App For New Receipe And Lots More Features.....Link:-http://www.kitchies.com";
                myintentshare.putExtra(Intent.EXTRA_TEXT, shareSub);
                startActivity(Intent.createChooser(myintentshare, "Share Using"));
                setTitle("Home");
                break;
            case R.id.nav_item_feedback:
                fragmentClass = HomeFragment.class;
                Uri uri1 = Uri.parse("market://details?id=");
                Intent myintentfeedback = new Intent(Intent.ACTION_VIEW, uri1);
                startActivity(myintentfeedback);
                setTitle("Home");
                break;
            case R.id.nav_item_setting:
                fragmentClass = SettingFragment.class;
                setTitle(menuitem.getTitle());
                break;
            case R.id.nav_item_aboutus:
                fragmentClass = AboutFragment.class;
                setTitle(menuitem.getTitle());
                break;
            default:
                fragmentClass = HomeFragment.class;
        }
        try {
            myfragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.drawerlinearlayout, myfragment).commit();
        menuitem.setChecked(true);
        mDrawerlayout.closeDrawers();
    }

    private void setupDrawerContent(NavigationView navigationview) {
        navigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()

        {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                selectItemDrawer(item);
                return true;
            }
        });
    }

}
