package com.simi.hftl_app.Main;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.simi.hftl_app.Fragmente.DualStudyFragment;
import com.simi.hftl_app.Fragmente.EducationFragment;
import com.simi.hftl_app.Fragmente.HFTLInfoFragment;
import com.simi.hftl_app.Fragmente.JobStudyFragment;
import com.simi.hftl_app.Fragmente.MenuFragment;
import com.simi.hftl_app.Fragmente.StudyFragment;
import com.simi.hftl_app.Fragmente.TestStudyFragment;
import com.simi.hftl_app.Listen.EducationListItem;
import com.simi.hftl_app.Listen.StudyListItem;
import com.simi.hftl_app.R;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
//TODO Implementierung des Testfragments
//TODO Funktionen der Optionen im Menü implemetieren
//TODO Links auf die Website einbinden
//TODO Inhalte der Studiengänge eintragen
//TODO HFTL Info Fragment
//TODO Weiterbildung einbinden!?
//TODO 2 Designs anbieten (vielleicht nur die Hauptseite oder die Farben der Boxen verändern lassen)
//TODO Feste Strings(auch andere Werte) in xml File auslagern

    private ImageView backButton;
    private boolean isClose;
    private boolean isMenuTapped = false;
    private StudyListItem clickedElement;
    private EducationListItem clickedEductaion;
    private String color = null;
    private Button study_button;
    private Button study_dual_button;
    private Button study_job_button;
    private Button study_test_button;
    private Button education_button;
    private Button maps_button;
    private Button hftl_button;

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
                onBackPressed();
            }
        });

        ImageView menuButton = (ImageView) findViewById(R.id.menu_icon);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (isMenuTapped)
                {
                    onBackPressed();
                    isMenuTapped = true;
                }
                else
                {
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                    ft.add(R.id.activityLayout, new MenuFragment());
                    ft.addToBackStack(MenuFragment.class.getSimpleName());
                    ft.commit();
                    backButton.setVisibility(View.VISIBLE);
                    isClose = false;
                }
                isMenuTapped = !isMenuTapped;
            }
        });

        study_button = (Button) findViewById(R.id.button_study);
        study_dual_button = (Button) findViewById(R.id.button_study_dual);
        study_job_button = (Button) findViewById(R.id.button_study_job);
        study_test_button = (Button) findViewById(R.id.button_study_test);
        education_button = (Button) findViewById(R.id.button_education);
        maps_button = (Button) findViewById(R.id.button_maps);
        hftl_button = (Button) findViewById(R.id.button_hftl_info);

        education_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.replace(R.id.activityLayout, new EducationFragment());
                ft.addToBackStack(EducationFragment.class.getSimpleName());
                ft.commit();
                setToolbarTitle("Weiterbildung");
                backButton.setVisibility(View.VISIBLE);
                isClose = false;
            }
        });

        hftl_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.replace(R.id.activityLayout, new HFTLInfoFragment(), "HFTLInfoFragment");
                ft.addToBackStack(HFTLInfoFragment.class.getSimpleName());
                ft.commit();
                setToolbarTitle("HFTL Übersicht");
                backButton.setVisibility(View.VISIBLE);
                isClose = false;
            }
        });

        maps_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = String.format(Locale.ENGLISH,
                                           "http://maps.google.com/maps?daddr=%f,%f (%s)",
                                           51.312870,
                                           12.374920,
                                           "Hochschule für Technik Leipzig");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });

        study_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.replace(R.id.activityLayout, new StudyFragment());
                ft.addToBackStack(StudyFragment.class.getSimpleName());
                ft.commit();
                setToolbarTitle("Direktstudium");
                backButton.setVisibility(View.VISIBLE);
                isClose = false;
            }
        });

        study_dual_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.replace(R.id.activityLayout, new DualStudyFragment());
                ft.addToBackStack(DualStudyFragment.class.getSimpleName());
                ft.commit();
                setToolbarTitle("Dualstudium");
                backButton.setVisibility(View.VISIBLE);
                isClose = false;
            }
        });

        study_job_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.replace(R.id.activityLayout, new JobStudyFragment());
                ft.addToBackStack(JobStudyFragment.class.getSimpleName());
                ft.commit();
                setToolbarTitle("Berufsbegleitend");
                backButton.setVisibility(View.VISIBLE);
                isClose = false;
            }
        });

        study_test_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.replace(R.id.activityLayout, new TestStudyFragment());
                ft.addToBackStack(TestStudyFragment.class.getSimpleName());
                ft.commit();
                setToolbarTitle("Studientest");
                backButton.setVisibility(View.VISIBLE);
                isClose = false;
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        isMenuTapped = false;
        if (getSupportFragmentManager().getBackStackEntryCount() == 0)
        {
            setToolbarTitle("HFTL");
            backButton.setVisibility(View.INVISIBLE);
            closeActivity();
        }
        else if (getSupportFragmentManager().getBackStackEntryCount() == 1)
        {
            setToolbarTitle("HFTL");
            backButton.setVisibility(View.INVISIBLE);
            super.onBackPressed();
        }
        else
        {
            super.onBackPressed();
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

    public StudyListItem getClickedElement() {
        return clickedElement;
    }

    public void setClickedElement(StudyListItem clickedElement) {
        this.clickedElement = clickedElement;
    }

    public EducationListItem getClickedEductaion() {
        return clickedEductaion;
    }

    public void setClickedEductaion(EducationListItem clickedElement) {
        this.clickedEductaion = clickedElement;
    }

    public void setToolbarTitle(String title)
    {
        TextView toolbarTitle = (TextView) this.findViewById(R.id.toolbarTitle);
        toolbarTitle.setText(title);
    }

    public int convertColorString(boolean isFragment)
    {
        int color = 0;
        if(getColor() != null)
        {
            try{
                color = Color.parseColor(getColor());
                study_button.setBackgroundColor(color);
                hftl_button.setBackgroundColor(color);
                education_button.setBackgroundColor(color);
                maps_button.setBackgroundColor(color);
                study_dual_button.setBackgroundColor(color);
                study_job_button.setBackgroundColor(color);
                study_test_button.setBackgroundColor(color);
                Fragment fragment = getSupportFragmentManager().findFragmentByTag("HFTLInfoFragment");
                if (fragment != null && !isFragment)
                {
                    fragment.onResume();
                }
                return color;
            }
            catch (Exception e)
            {
                return 0;
            }
        }
        return 0;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
        if (color == null)
        {
            study_button.setBackgroundColor(getResources().getColor(R.color.study_color));
            hftl_button.setBackgroundColor(getResources().getColor(R.color.hftl_info_color));
            education_button.setBackgroundColor(getResources().getColor(R.color.education_color));
            maps_button.setBackgroundColor(getResources().getColor(R.color.maps_color));
            study_dual_button.setBackgroundColor(getResources().getColor(R.color.study_dual_color));
            study_job_button.setBackgroundColor(getResources().getColor(R.color.study_job_color));
            study_test_button.setBackgroundColor(getResources().getColor(R.color.study_test_color));
        }
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("HFTLInfoFragment");
        if (fragment != null)
        {
            fragment.onResume();
        }
    }
}