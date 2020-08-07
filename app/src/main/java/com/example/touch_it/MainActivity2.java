package com.example.touch_it;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.touch_it.Fragment.AddFragment;
import com.example.touch_it.Fragment.HomeFragment;
import com.example.touch_it.Fragment.ImFragment;
import com.example.touch_it.Fragment.SearchFragment;
import com.example.touch_it.Fragment.VideoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity2 extends AppCompatActivity {


    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private HomeFragment homeFragment;
    private SearchFragment searchFragment;
    private AddFragment addFragment;
    private VideoFragment videoFragment;
    private ImFragment imFragment;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
       mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);

        homeFragment = new HomeFragment();
        searchFragment = new SearchFragment();
        addFragment = new AddFragment();
        videoFragment = new VideoFragment();
        imFragment = new ImFragment();

        setFragment(homeFragment);


        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
               switch (menuItem.getItemId()) {

                   case R.id.nav_home:
                       mMainNav.setItemBackgroundResource(R.color.colorAccent);
                       setFragment(homeFragment);
                       return true;

                   case R.id.nav_search:
                       mMainNav.setItemBackgroundResource(R.color.colorAccent);
                       setFragment(searchFragment);
                       return true;

                   case R.id.nav_add:
                       mMainNav.setItemBackgroundResource(R.color.colorAccent);
                       setFragment(addFragment);
                       return true;


                   case R.id.nav_video:
                       mMainNav.setItemBackgroundResource(R.color.colorAccent);
                       setFragment(videoFragment);
                       return true;

                   case R.id.nav_im:
                       mMainNav.setItemBackgroundResource(R.color.colorAccent);
                       setFragment(imFragment);
                       return true;

                   default:
                       return false;
               }

           }
       });

    }
    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }
}