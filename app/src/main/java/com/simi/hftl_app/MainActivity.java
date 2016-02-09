package com.simi.hftl_app;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView backButton;
    Fragment fragmentToClose = null;
    private boolean isClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hftl_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.statusbar_color));
        }

        backButton = (ImageView) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragmentToClose != null) {
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                    ft.remove(fragmentToClose);
                    ft.commit();
                }
                backButton.setVisibility(View.INVISIBLE);
            }
        });

        final Button study_button = (Button) findViewById(R.id.button_study);
        Button study__dual_button = (Button) findViewById(R.id.button_study_dual);
        Button study_job_button = (Button) findViewById(R.id.button_study_job);
        Button study_test_button = (Button) findViewById(R.id.button_study_test);

        study_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                fragmentToClose = new StudyFragment();
                ft.replace(R.id.activityLayout, fragmentToClose);
                ft.addToBackStack(StudyFragment.class.getSimpleName());
                ft.commit();
                backButton.setVisibility(View.VISIBLE);
                isClose = false;
            }
        });


        study__dual_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                fragmentToClose = new DualStudyFragment();
                ft.replace(R.id.activityLayout, fragmentToClose);
                ft.addToBackStack(DualStudyFragment.class.getSimpleName());
                ft.commit();
                backButton.setVisibility(View.VISIBLE);
                isClose = false;
            }
        });


        study_job_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                fragmentToClose = new JobStudyFragment();
                ft.replace(R.id.activityLayout, fragmentToClose);
                ft.addToBackStack(JobStudyFragment.class.getSimpleName());
                ft.commit();
                backButton.setVisibility(View.VISIBLE);
                isClose = false;
            }
        });


        study_test_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                fragmentToClose = new TestStudyFragment();
                ft.replace(R.id.activityLayout, fragmentToClose);
                ft.addToBackStack(TestStudyFragment.class.getSimpleName());
                ft.commit();
                backButton.setVisibility(View.VISIBLE);
                isClose = false;
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        backButton.setVisibility(View.INVISIBLE);
        boolean isPopBackStack = true;
        if (getSupportFragmentManager().getBackStackEntryCount() == 0)
        {
            closeActivity();
            isPopBackStack = false;
        }
        if (isPopBackStack)
        {
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

    public void closeActivity()
    {
        if (!isClose)
        {
            isClose = true;
            Toast.makeText(getApplicationContext(), "Erneut tippen zum Beenden.", Toast.LENGTH_LONG).show();
        }
        else
        {
            MainActivity.this.finish();
        }
    }
}