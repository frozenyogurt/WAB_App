package com.simi.hftl_app.Main;

import android.content.Intent;
import android.content.res.Configuration;
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
import com.simi.hftl_app.Fragmente.MyRefreshFragment;
import com.simi.hftl_app.Fragmente.StudyFragment;
import com.simi.hftl_app.Fragmente.TestStudyFragment;
import com.simi.hftl_app.Listen.EducationListItem;
import com.simi.hftl_app.Listen.FAQListItem;
import com.simi.hftl_app.Listen.PersonListItem;
import com.simi.hftl_app.Listen.StudyListItem;
import com.simi.hftl_app.Model.Answer;
import com.simi.hftl_app.Model.Question;
import com.simi.hftl_app.R;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
//TODO Implementierung des Testfragments
//TODO Links auf die Website einbinden
//TODO 2 Designs anbieten (vielleicht nur die Hauptseite oder die Farben der Boxen verändern lassen)
//TODO Feste Strings(auch andere Werte) in xml File auslagern
//TODO Answers der Question vereinfachen mit einer Liste

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
    private FAQListItem clickedFAQ;
    private String language = "de";
    private boolean isGoBack = false;
    private ArrayList<Question> questionsList = new ArrayList<>();
    private int currentPage;
    private boolean isFirstElement = false;

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
                handleMenuClick();
            }
        });

        study_button = (Button) findViewById(R.id.button_study);
        study_dual_button = (Button) findViewById(R.id.button_study_dual);
        study_job_button = (Button) findViewById(R.id.button_study_job);
        study_test_button = (Button) findViewById(R.id.button_study_test);
        education_button = (Button) findViewById(R.id.button_education);
        maps_button = (Button) findViewById(R.id.button_maps);
        hftl_button = (Button) findViewById(R.id.button_hftl_info);

        setLocale(language);

        education_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.replace(R.id.activityLayout, new EducationFragment(), "EducationFragment");
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
                navigateToHFTL();
            }
        });

        study_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.replace(R.id.activityLayout, new StudyFragment(), "StudyFragment");
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
                ft.replace(R.id.activityLayout, new DualStudyFragment(), "DualStudyFragment");
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
                ft.replace(R.id.activityLayout, new JobStudyFragment(), "JobStudyFragment");
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
                ft.replace(R.id.activityLayout, new TestStudyFragment(), "TestStudyFragment");
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
        String lastFragmentName = getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1).getName();
        questionsList = new ArrayList<>();
        if (getSupportFragmentManager().getBackStackEntryCount() == 0)
        {
            isGoBack = false;
            setToolbarTitle("HFTL");
            backButton.setVisibility(View.INVISIBLE);
            closeActivity();
        }
        else if (getSupportFragmentManager().getBackStackEntryCount() == 1)
        {
            isGoBack = false;
            setToolbarTitle("HFTL");
            backButton.setVisibility(View.INVISIBLE);
            super.onBackPressed();
        }
        else if (lastFragmentName != null)
        {
            if (!(lastFragmentName.equals("SettingsFragment") || lastFragmentName.equals("AboutUsFragment")))
            {
                isGoBack = false;
            }
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

    public FAQListItem getClickedFAQ() {
        return clickedFAQ;
    }

    public void setClickedFAQ(FAQListItem clickedElement) {
        this.clickedFAQ = clickedElement;
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

    public void sendMail(PersonListItem person)
    {
        final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

        emailIntent.setType("plain/text");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{person.getMail()});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, new String[] {"Frage"});
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Hallo " + person.getName() + ",");

        startActivity(Intent.createChooser(emailIntent, "Mail senden..."));
    }

    public void callPerson(String number)
    {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + number));
        startActivity(intent);
    }

    public void setLocale(String language)
    {
        this.language = language;
        Locale locale = new Locale(this.language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getApplicationContext().getResources().updateConfiguration(config, null);
    }

    public String getLanguage()
    {
        return this.language;
    }

    public void handleMenuClick()
    {
        if (isMenuTapped || isGoBack)
        {
            onBackPressed();
            isMenuTapped = true;
        }
        else
        {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
            ft.add(R.id.activityLayout, new MenuFragment(), "MenuFragment");
            ft.addToBackStack(MenuFragment.class.getSimpleName());
            ft.commit();
            backButton.setVisibility(View.VISIBLE);
            isClose = false;
            isGoBack = true;
        }
        isMenuTapped = !isMenuTapped;
    }

    public void refreshFragments()
    {
        for (int entry = 0; entry < getSupportFragmentManager().getBackStackEntryCount(); entry++)
        {
            String name = getSupportFragmentManager().getBackStackEntryAt(entry).getName();
            MyRefreshFragment fragment = (MyRefreshFragment) getSupportFragmentManager().findFragmentByTag(name);
            if (fragment != null)
            {
                fragment.refresh();
            }
        }
    }

    public void goToWebsite(String website)
    {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(website));
        startActivity(intent);
    }

    public void navigateToHFTL()
    {
        String uri = String.format(Locale.ENGLISH,
                "http://maps.google.com/maps?daddr=%f,%f (%s)",
                51.312870,
                12.374920,
                "Hochschule für Telekommunikation Leipzig");
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        startActivity(intent);
    }

    public ArrayList<Question> getQuestions()
    {
        return questionsList;
    }

    public void setAnswerActive(int answer, String question, boolean isActive)
    {
        for (int i = 0; i < questionsList.size(); i++)
        {
            if (questionsList.get(i).getQuestionName().equals(question))
            {
                questionsList.get(i).getAnswers().get(0).setIsSet(answer == 1 && isActive);
                questionsList.get(i).getAnswers().get(1).setIsSet(answer == 2 && isActive);
                questionsList.get(i).getAnswers().get(2).setIsSet(answer == 3 && isActive);
                questionsList.get(i).getAnswers().get(3).setIsSet(answer == 4 && isActive);
                questionsList.get(i).getAnswers().get(4).setIsSet(answer == 5 && isActive);
            }
        }
    }

    public void initQuestionList()
    {
        ArrayList<Answer> answers1 = new ArrayList<>();
        answers1.add(new Answer("Antwort 1"));
        answers1.add(new Answer("Antwort 2"));
        answers1.add(new Answer("Antwort 3"));
        answers1.add(new Answer("Antwort 4"));
        answers1.add(new Answer("Antwort 5"));

        questionsList.add(new Question("Frage 1", answers1));

        ArrayList<Answer> answers2 = new ArrayList<>();
        answers2.add(new Answer("Antwort 1"));
        answers2.add(new Answer("Antwort 2"));
        answers2.add(new Answer("Antwort 3"));
        answers2.add(new Answer("Antwort 4"));
        answers2.add(new Answer("Antwort 5"));
        questionsList.add(new Question("Frage 2", answers2));

        ArrayList<Answer> answers3 = new ArrayList<>();
        answers3.add(new Answer("Antwort 1"));
        answers3.add(new Answer("Antwort 2"));
        answers3.add(new Answer("Antwort 3"));
        answers3.add(new Answer("Antwort 4"));
        answers3.add(new Answer("Antwort 5"));
        questionsList.add(new Question("Frage 3", answers3));

        ArrayList<Answer> answers4 = new ArrayList<>();
        answers4.add(new Answer("Antwort 1"));
        answers4.add(new Answer("Antwort 2"));
        answers4.add(new Answer("Antwort 3"));
        answers4.add(new Answer("Antwort 4"));
        answers4.add(new Answer("Antwort 5"));
        questionsList.add(new Question("Frage 4", answers4));

        ArrayList<Answer> answers5 = new ArrayList<>();
        answers5.add(new Answer("Antwort 1"));
        answers5.add(new Answer("Antwort 2"));
        answers5.add(new Answer("Antwort 3"));
        answers5.add(new Answer("Antwort 4"));
        answers5.add(new Answer("Antwort 5"));
        questionsList.add(new Question("Frage 5", answers5));

        ArrayList<Answer> answers6 = new ArrayList<>();
        answers6.add(new Answer("Antwort 1"));
        answers6.add(new Answer("Antwort 2"));
        answers6.add(new Answer("Antwort 3"));
        answers6.add(new Answer("Antwort 4"));
        answers6.add(new Answer("Antwort 5"));
        questionsList.add(new Question("Frage 6", answers6));
    }

    public int getCurrentViewPagerItem()
    {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public boolean isTestValid()
    {
        boolean isValid = true;
        boolean isAnswered = false;
        for (Question question : questionsList)
        {
            for (int i = 0; i < question.getAnswers().size(); i++)
            {
                if (question.getAnswers().get(i).isSet())
                {
                    isAnswered = true;
                }
            }
            if (!isAnswered)
            {
                isValid = false;
                break;
            }
            isAnswered = false;
        }
        return isValid;
    }

    public boolean isFirstElement()
    {
        return isFirstElement;
    }

    public void setIsFirstElement(boolean isFirstElement) {
        this.isFirstElement = isFirstElement;
    }

    public void endTest()
    {
        onBackPressed();
        onBackPressed();
        onBackPressed();
        setCurrentPage(0);
        questionsList = new ArrayList<>();
    }

    /*public void openImage(int id)
    {
        Uri path = Uri.parse("" + id);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(path, "image/png");
        startActivity(intent);
    }**/
}