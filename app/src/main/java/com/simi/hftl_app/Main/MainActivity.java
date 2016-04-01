package com.simi.hftl_app.Main;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.simi.hftl_app.Fragmente.DualStudyFragment;
import com.simi.hftl_app.Fragmente.EducationFragment;
import com.simi.hftl_app.Fragmente.FullscreenImageFragment;
import com.simi.hftl_app.Fragmente.HFTLInfoFragment;
import com.simi.hftl_app.Fragmente.JobStudyFragment;
import com.simi.hftl_app.Fragmente.MenuFragment;
import com.simi.hftl_app.Fragmente.MyRefreshFragment;
import com.simi.hftl_app.Fragmente.StudyFragment;
import com.simi.hftl_app.Fragmente.TestStudyFragment;
import com.simi.hftl_app.Listen.EducationListItem;
import com.simi.hftl_app.Listen.PersonListItem;
import com.simi.hftl_app.Listen.StudyListItem;
import com.simi.hftl_app.Model.Answer;
import com.simi.hftl_app.Model.MyDragListener;
import com.simi.hftl_app.Model.MyLongClickListener;
import com.simi.hftl_app.Model.Question;
import com.simi.hftl_app.Model.Rating;
import com.simi.hftl_app.Model.StudyCourse;
import com.simi.hftl_app.Model.TextSize;
import com.simi.hftl_app.R;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

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
    private String language = "de";
    private boolean isGoBack = false;
    private ArrayList<Question> questionsList = new ArrayList<>();
    private int currentPage;
    private ArrayList<StudyCourse> winner;
    private StudyCourse alternative;
    private Rating rating;
    private int imageID;
    private TextSize textSize = TextSize.MIDDLE;
    private TextView toolbarTitle;

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

        toolbarTitle = (TextView) this.findViewById(R.id.toolbarTitle);
        study_button = (Button) findViewById(R.id.button_study);
        study_dual_button = (Button) findViewById(R.id.button_study_dual);
        study_job_button = (Button) findViewById(R.id.button_study_job);
        study_test_button = (Button) findViewById(R.id.button_study_test);
        education_button = (Button) findViewById(R.id.button_education);
        maps_button = (Button) findViewById(R.id.button_maps);
        hftl_button = (Button) findViewById(R.id.button_hftl_info);

        setTextSizeForViews();

        study_button.setOnLongClickListener(new MyLongClickListener(getWidth()/2, this));
        study_dual_button.setOnLongClickListener(new MyLongClickListener(getWidth() /2, this));
        study_job_button.setOnLongClickListener(new MyLongClickListener(getWidth() /2, this));
        study_test_button.setOnLongClickListener(new MyLongClickListener(getWidth() /2, this));
        education_button.setOnLongClickListener(new MyLongClickListener(getWidth() /2, this));
        maps_button.setOnLongClickListener(new MyLongClickListener(getWidth() /2, this));
        hftl_button.setOnLongClickListener(new MyLongClickListener(getWidth() /2, this));

        study_button.setOnDragListener(new MyDragListener(this, getResources().getColor(R.color.study_color)));
        study_dual_button.setOnDragListener(new MyDragListener(this, getResources().getColor(R.color.study_dual_color)));
        study_job_button.setOnDragListener(new MyDragListener(this, getResources().getColor(R.color.study_job_color)));
        study_test_button.setOnDragListener(new MyDragListener(this, getResources().getColor(R.color.study_test_color)));
        education_button.setOnDragListener(new MyDragListener(this, getResources().getColor(R.color.education_color)));
        maps_button.setOnDragListener(new MyDragListener(this, getResources().getColor(R.color.maps_color)));
        hftl_button.setOnDragListener(new MyDragListener(this, getResources().getColor(R.color.hftl_info_color)));

        setLocale(language);

        education_button.setText(getResources().getString(R.string.ACTIVITY_EDUCATION_TITLE));
        education_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.replace(R.id.activityLayout, new EducationFragment(), "EducationFragment");
                ft.addToBackStack(EducationFragment.class.getSimpleName());
                ft.commit();
                setToolbarTitle(getResources().getString(R.string.ACTIVITY_EDUCATION_TITLE));
                backButton.setVisibility(View.VISIBLE);
                isClose = false;
            }
        });

        hftl_button.setText(getResources().getString(R.string.ACTIVITY_HFTL_INFO_TITLE_BUTTON));
        hftl_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.replace(R.id.activityLayout, new HFTLInfoFragment(), "HFTLInfoFragment");
                ft.addToBackStack(HFTLInfoFragment.class.getSimpleName());
                ft.commit();
                setToolbarTitle(getResources().getString(R.string.ACTIVITY_HFTL_INFO_TITLE));
                backButton.setVisibility(View.VISIBLE);
                isClose = false;
            }
        });

        maps_button.setText(getResources().getString(R.string.ACTIVITY_MAPS_TITLE));
        maps_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToHFTL();
            }
        });

        study_button.setText(getResources().getString(R.string.ACTIVITY_DIRECT_TITLE));
        study_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.replace(R.id.activityLayout, new StudyFragment(), "StudyFragment");
                ft.addToBackStack(StudyFragment.class.getSimpleName());
                ft.commit();
                setToolbarTitle(getResources().getString(R.string.ACTIVITY_DIRECT_TITLE));
                backButton.setVisibility(View.VISIBLE);
                isClose = false;
            }
        });

        study_dual_button.setText(getResources().getString(R.string.ACTIVITY_DUAL_TITLE));
        study_dual_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.replace(R.id.activityLayout, new DualStudyFragment(), "DualStudyFragment");
                ft.addToBackStack(DualStudyFragment.class.getSimpleName());
                ft.commit();
                setToolbarTitle(getResources().getString(R.string.ACTIVITY_DUAL_TITLE));
                backButton.setVisibility(View.VISIBLE);
                isClose = false;
            }
        });

        study_job_button.setText(getResources().getString(R.string.ACTIVITY_JOB_TITLE_BUTTON));
        study_job_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.replace(R.id.activityLayout, new JobStudyFragment(), "JobStudyFragment");
                ft.addToBackStack(JobStudyFragment.class.getSimpleName());
                ft.commit();
                setToolbarTitle(getResources().getString(R.string.ACTIVITY_JOB_TITLE));
                backButton.setVisibility(View.VISIBLE);
                isClose = false;
            }
        });

        study_test_button.setText(getResources().getString(R.string.ACTIVITY_Test_TITLE_BUTTON));
        study_test_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
                ft.replace(R.id.activityLayout, new TestStudyFragment(), "TestStudyFragment");
                ft.addToBackStack(TestStudyFragment.class.getSimpleName());
                ft.commit();
                setToolbarTitle(getResources().getString(R.string.ACTIVITY_Test_TITLE));
                backButton.setVisibility(View.VISIBLE);
                isClose = false;
            }
        });

        setToolbarTitle(getResources().getString(R.string.ACTIVITY_APP_TITLE));
    }

    @Override
    public void onBackPressed()
    {
        isMenuTapped = false;
        String lastFragmentName = null;
        if(getSupportFragmentManager().getBackStackEntryCount() > 0)
        {
            lastFragmentName = getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1).getName();
        }
        if (getSupportFragmentManager().getBackStackEntryCount() == 0)
        {
            questionsList = new ArrayList<>();
            isGoBack = false;
            setToolbarTitle(getResources().getString(R.string.ACTIVITY_APP_TITLE));
            backButton.setVisibility(View.INVISIBLE);
            closeActivity();
        }
        else if (getSupportFragmentManager().getBackStackEntryCount() == 1)
        {
            questionsList = new ArrayList<>();
            isGoBack = false;
            setToolbarTitle(getResources().getString(R.string.ACTIVITY_APP_TITLE));
            backButton.setVisibility(View.INVISIBLE);
            super.onBackPressed();
        }
        else if (lastFragmentName != null)
        {
            if (lastFragmentName.equals("StudyTestQuestionsFragment"))
            {
                setCurrentPage(0);
                questionsList = new ArrayList<>();
            }
            else if (lastFragmentName.equals("ResultTestDataFragment")
                    || lastFragmentName.equals("MenuFragment")
                    || lastFragmentName.equals("StudyTestResultFragment")
                    || lastFragmentName.equals("StudyInfoFragment"))
            {
                if (lastFragmentName.equals("MenuFragment"))
                {
                    setCurrentPage(getCurrentViewPagerItem());
                }
                refreshFragments();
                isGoBack = false;
            }
            else if (!(lastFragmentName.equals("SettingsFragment")
                    || lastFragmentName.equals("AboutUsFragment")
                    || lastFragmentName.equals("FullscreenImageFragment")))
            {
                questionsList = new ArrayList<>();
                isGoBack = false;
            }
            super.onBackPressed();
        }
        else
        {
            questionsList = new ArrayList<>();
            super.onBackPressed();
        }
    }

    public void closeActivity()
    {
        if (!isClose)
        {
            isClose = true;
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.ACTIVITY_TOUCH_AGAIN), Toast.LENGTH_LONG).show();
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
        toolbarTitle.setText(title);
    }

    public int convertColorString()
    {
        int color = 0;
        if(getColor() != null)
        {
            try
            {
                color = Color.parseColor("#" + getColor());
                return color;
            }
            catch (Exception e)
            {
                return color;
            }
        }
        return color;
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
            study_button.setTextColor(getResources().getColor(android.R.color.white));
            hftl_button.setBackgroundColor(getResources().getColor(R.color.hftl_info_color));
            hftl_button.setTextColor(getResources().getColor(android.R.color.white));
            education_button.setBackgroundColor(getResources().getColor(R.color.education_color));
            education_button.setTextColor(getResources().getColor(android.R.color.white));
            maps_button.setBackgroundColor(getResources().getColor(R.color.maps_color));
            maps_button.setTextColor(getResources().getColor(android.R.color.white));
            study_dual_button.setBackgroundColor(getResources().getColor(R.color.study_dual_color));
            study_dual_button.setTextColor(getResources().getColor(android.R.color.white));
            study_job_button.setBackgroundColor(getResources().getColor(R.color.study_job_color));
            study_job_button.setTextColor(getResources().getColor(android.R.color.white));
            study_test_button.setBackgroundColor(getResources().getColor(R.color.study_test_color));
            study_test_button.setTextColor(getResources().getColor(android.R.color.white));
        }
        else if (color.equals(Integer.toHexString(getResources().getColor(R.color.magenta))))
        {
            study_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.box));
            //study_button.setTextColor(getResources().getColor(R.color.magenta));
            hftl_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.box));
            //hftl_button.setTextColor(getResources().getColor(R.color.magenta));
            education_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.box));
            //education_button.setTextColor(getResources().getColor(R.color.magenta));
            maps_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.box));
            //maps_button.setTextColor(getResources().getColor(R.color.magenta));
            study_dual_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.box));
            //study_dual_button.setTextColor(getResources().getColor(R.color.magenta));
            study_job_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.box));
            //study_job_button.setTextColor(getResources().getColor(R.color.magenta));
            study_test_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.box));
            //study_test_button.setTextColor(getResources().getColor(R.color.magenta));
        }
    }

    public void sendMail(PersonListItem person)
    {
        final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

        emailIntent.setType("plain/text");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{person.getMail()});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, new String[]{getResources().getString(R.string.ACTIVITY_MAIL_EXTRA_SUBJECT)});
        emailIntent.putExtra(Intent.EXTRA_TEXT, getResources().getString(R.string.ACTIVITY_MAIL_HELLO) + person.getName() + ",");

        startActivity(Intent.createChooser(emailIntent, getResources().getString(R.string.ACTIVITY_MAIL_CHOOSER_TITLE)));
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
                getResources().getString(R.string.ACTIVITY_HFTL_NAME));
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
                if (questionsList.get(i).getAnswers().size() > 2)
                {
                    questionsList.get(i).getAnswers().get(2).setIsSet(answer == 3 && isActive);
                    if (questionsList.get(i).getAnswers().size() > 3)
                    {
                        questionsList.get(i).getAnswers().get(3).setIsSet(answer == 4 && isActive);
                        if (questionsList.get(i).getAnswers().size() > 4)
                        {
                            questionsList.get(i).getAnswers().get(4).setIsSet(answer == 5 && isActive);
                        }
                    }
                }
            }
        }
    }

    public void initQuestionList()
    {
        ArrayList<Answer> answers1 = new ArrayList<>();

        answers1.add(new Answer(getResources().getString(R.string.QUESTION_ONE_ANSWER_ONE), Rating.getInitializedRatingMap(0,0,0,6,6,6,6,0,0)));
        answers1.add(new Answer(getResources().getString(R.string.QUESTION_ONE_ANSWER_TWO), Rating.getInitializedRatingMap(0,0,0,4,6,4,4,0,0)));
        answers1.add(new Answer(getResources().getString(R.string.QUESTION_ONE_ANSWER_THREE), Rating.getInitializedRatingMap(0,0,0,2,6,2,2,0,0)));
        answers1.add(new Answer(getResources().getString(R.string.QUESTION_ONE_ANSWER_FOUR), Rating.getInitializedRatingMap(0,0,0,0,6,0,0,0,0)));
        questionsList.add(new Question(getResources().getString(R.string.QUESTION_ONE_NAME), answers1));

        ArrayList<Answer> answers2 = new ArrayList<>();
        answers2.add(new Answer("Ja, so viele wie möglich", Rating.getInitializedRatingMap(0,0,0,6,0,6,6,0,0)));
        answers2.add(new Answer("Ja, einige sind gut", Rating.getInitializedRatingMap(0,0,0,4,2,4,4,0,0)));
        answers2.add(new Answer("Nur wenn es sein muss", Rating.getInitializedRatingMap(0,0,0,2,4,2,2,0,0)));
        answers2.add(new Answer("Auf keinen Fall", Rating.getInitializedRatingMap(0,0,0,0,6,0,0,0,0)));
        questionsList.add(new Question("Bist du an den math.-naturwissenschaftlichen Grundlagen der Informatik interessiert?", answers2));

        ArrayList<Answer> answers3 = new ArrayList<>();
        answers3.add(new Answer("Ja, sie sind sehr wichtig", Rating.getInitializedRatingMap(0,0,0,0,6,0,0,0,0)));
        answers3.add(new Answer("Ja, sie sind wichtig", Rating.getInitializedRatingMap(0,0,0,2,4,2,2,0,0)));
        answers3.add(new Answer("Geht so", Rating.getInitializedRatingMap(0,0,0,4,2,4,4,0,0)));
        answers3.add(new Answer("Gar nicht wichtig", Rating.getInitializedRatingMap(0,0,0,6,0,6,6,0,0)));
        questionsList.add(new Question("Sind Dir wirtschaftliche Module wie Allgemeine Betriebswirtschaftslehre, Marketing & CRM und Volks\u00ADwirtschaftslehre wichtig?", answers3));

        ArrayList<Answer> answers4 = new ArrayList<>();
        answers4.add(new Answer("Rechnungswesen & Controlling", Rating.getInitializedRatingMap(0,0,0,0,6,0,0,0,0)));
        answers4.add(new Answer("Programmierung", Rating.getInitializedRatingMap(0,0,0,6,6,0,6,0,0)));
        answers4.add(new Answer("Social Media Communication", Rating.getInitializedRatingMap(0,0,0,0,0,0,6,0,0)));
        questionsList.add(new Question("Welches dieser Themengebiete sagt Dir am meisten zu?", answers4));

        ArrayList<Answer> answers5 = new ArrayList<>();
        answers5.add(new Answer("ProjektmanagerIn in Themen wie Cloud Computingoder  Datensicherheit", Rating.getInitializedRatingMap(0,0,0,0,0,0,6,0,0)));
        answers5.add(new Answer("In Kapazitätsplanung und -management", Rating.getInitializedRatingMap(0,0,0,0,0,6,0,0,0)));
        answers5.add(new Answer("SoftwareentwicklerIn, SystembetreuerIn oder SystemdesignerIn großer Systeme", Rating.getInitializedRatingMap(0,0,0,6,0,0,0,0,0)));
        answers5.add(new Answer("überall, wo IT auf betriebswirtschaftliche Funktionen trifft", Rating.getInitializedRatingMap(0,0,0,0,6,0,0,0,0)));
        questionsList.add(new Question("In welchem dieser Tätigkeitsbereiche würdest Du am liebsten arbeiten?", answers5));

        ArrayList<Answer> answers6 = new ArrayList<>();
        answers6.add(new Answer("Netztopologie", Rating.getInitializedRatingMap(0,0,0,6,0,0,0,0,0)));
        answers6.add(new Answer("Signalverarbeitung", Rating.getInitializedRatingMap(0,0,0,0,0,6,0,0,0)));
        answers6.add(new Answer("Datensicherheit/Datenkompression", Rating.getInitializedRatingMap(0,0,0,0,6,0,0,0,0)));
        answers6.add(new Answer("Datenanalyse", Rating.getInitializedRatingMap(0,0,0,0,0,0,6,0,0)));
        questionsList.add(new Question("Welches dieser Stichworte interessiert dich bei der Datenübertragung am meisten?", answers6));

        ArrayList<Answer> answers7 = new ArrayList<>();
        answers7.add(new Answer("ja", Rating.getInitializedRatingMap(3,0,6,0,0,0,0,0,0)));
        answers7.add(new Answer("nein", Rating.getInitializedRatingMap(6,6,-300,0,0,0,0,0,0)));
        questionsList.add(new Question("Hast du bereits eine Ausbildung im IT-Bereich absolviert?", answers7));

        ArrayList<Answer> answers8 = new ArrayList<>();
        answers8.add(new Answer("Nein, unter keinen Umständen.", Rating.getInitializedRatingMap(6,0,0,0,0,0,0,0,0)));
        answers8.add(new Answer("Ja, ich wäre bereit sie selbst zu zahlen.", Rating.getInitializedRatingMap(3,6,3,0,0,0,0,0,0)));
        answers8.add(new Answer("Ja, wenn ich diese durch eine Anstellung bei der Telekom finanzieren kann.", Rating.getInitializedRatingMap(3,0,6,0,0,0,0,0,0)));
        questionsList.add(new Question("Wärst Du bereit Studiengebühren in Höhe von 250 pro Monat zu zahlen?", answers8));

        ArrayList<Answer> answers9 = new ArrayList<>();
        answers9.add(new Answer("Ja, sehr wichtig, am besten das einer ausgelernten IT Fachkraft.", Rating.getInitializedRatingMap(2,0,6,0,0,0,0,0,0)));
        answers9.add(new Answer("Ja, es soll primär die Kosten decken, die mir entstehen.", Rating.getInitializedRatingMap(6,6,2,0,0,0,0,0,0)));
        answers9.add(new Answer("Nein, ich will nicht nebenbei bei der Telekom arbeiten, um Geld zu verdienen.", Rating.getInitializedRatingMap(0,6,0,0,0,0,0,0,0)));
        questionsList.add(new Question("Ist es dir wichtig neben dem Studium auch ein Gehalt von der Telekom zu beziehen - und wenn ja, wie viel?", answers9));

        ArrayList<Answer> answers10 = new ArrayList<>();
        answers10.add(new Answer("Ja, es ist mir sehr wichtig", Rating.getInitializedRatingMap(6,0,6,0,0,0,0,0,0)));
        answers10.add(new Answer("Ja, es ist mir wichtig", Rating.getInitializedRatingMap(4,0,4,0,0,0,0,0,0)));
        answers10.add(new Answer("Es ist mir nicht so wichtig", Rating.getInitializedRatingMap(2,3,2,0,0,0,0,0,0)));
        answers10.add(new Answer("Nein, denn ich will mich nur auf das Studium konzentrieren", Rating.getInitializedRatingMap(0,6,0,0,0,0,0,0,0)));
        questionsList.add(new Question("Ist es Dir wichtig auch Berufserfahrung während des Studiums zu gewinnen?", answers10));

        ArrayList<Answer> answers11 = new ArrayList<>();
        answers11.add(new Answer("Nein, ich will mir nach dem Studium meinen Arbeitgeber selbst aussuchen oder ohne Verzögerung einen Master machen.", Rating.getInitializedRatingMap(0,6,3,0,0,0,0,0,0)));
        answers11.add(new Answer("Ja, für zwei Jahre ist das in Ordnung.", Rating.getInitializedRatingMap(4,0,3,0,0,0,0,0,0)));
        answers11.add(new Answer("Ja, ich will ohnehin bei der Telekom bleiben.", Rating.getInitializedRatingMap(6,0,6,0,0,0,0,0,0)));
        questionsList.add(new Question("Kannst Du dir vorstellen für mindestens zwei Jahre nach dem Studium bei der Telekom zu bleiben?", answers11));

        ArrayList<Answer> answers12 = new ArrayList<>();
        answers12.add(new Answer("Mir ist eine Übernahme komplett unwichtig.",Rating.getInitializedRatingMap(0,6,0,0,0,0,0,0,0)));
        answers12.add(new Answer("Eine Übernahme wäre nicht schlecht, muss aber nicht sein.", Rating.getInitializedRatingMap(3,3,3,0,0,0,0,0,0)));
        answers12.add(new Answer("Ich will mit hoher Wahrscheinlichkeit übernommen werden.", Rating.getInitializedRatingMap(6,0,6,0,0,0,0,0,0)));
        questionsList.add(new Question("Wie wichtig ist Dir die Aussicht auf eine Übernahme bei der Telekom?", answers12));

        ArrayList<Answer> answers13 = new ArrayList<>();
        answers13.add(new Answer("Anhand von Skripten lernen ist für mich ideal.", Rating.getInitializedRatingMap(4,0,6,0,0,0,0,0,0)));
        answers13.add(new Answer("Skripte sind gut, aber Vorlesungen sind auch wichtig.", Rating.getInitializedRatingMap(6,0,4,0,0,0,0,0,0)));
        answers13.add(new Answer("Ich möchte lieber weniger anhand von Skripten lernen, sondern eher an Vorlesungen teilnehmen.", Rating.getInitializedRatingMap(2,6,0,0,0,0,0,0,0)));
        answers13.add(new Answer("Ich muss bei jeder Vorlesung dabei sein.", Rating.getInitializedRatingMap(0,6,0,0,0,0,0,0,0)));
        questionsList.add(new Question("Vermittelst du dir eher über Skripte oder Vorlesungen die Lerninhalte?", answers13));

        ArrayList<Answer> answers14 = new ArrayList<>();
        answers14.add(new Answer("Ja", Rating.getInitializedRatingMap(6,6,6,0,0,0,0,0,0)));
        answers14.add(new Answer("Nein", Rating.getInitializedRatingMap(0,6,0,0,0,0,0,0,0)));
        answers14.add(new Answer("Teilweise", Rating.getInitializedRatingMap(4,6,0,0,0,0,0,0,0)));
        questionsList.add(new Question("Bist du bereit auf Freizeit zu verzichten, um dein Studium mit einer Berufstätigkeit zu verbinden?", answers14));

        ArrayList<Answer> answers15 = new ArrayList<>();
        answers15.add(new Answer("Ja", Rating.getInitializedRatingMap(0,0,0,0,0,0,0,0,6)));
        answers15.add(new Answer("Nein", Rating.getInitializedRatingMap(0,0,0,0,0,0,0,6,0)));
        answers15.add(new Answer("Das weiß ich noch nicht.", Rating.getInitializedRatingMap(0,0,0,0,0,0,0,6,6)));
        questionsList.add(new Question("Planst du nach deinem Bachelor einen Master Studiengang?", answers15));
    }

    public int getCurrentViewPagerItem()
    {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public ArrayList<Integer> getNotAnsweredQuestions()
    {
        ArrayList<Integer> notAnsweredQuestion = new ArrayList<>();
        boolean isAnswered = false;
        int i;
        for (i = 0; i < questionsList.size(); i++)
        {
            for (int j = 0; j < questionsList.get(i).getAnswers().size(); j++)
            {
                if (questionsList.get(i).getAnswers().get(j).isSet())
                {
                    isAnswered = true;
                    break;
                }
            }
            if (!isAnswered)
            {
                notAnsweredQuestion.add(i+1);
            }
            isAnswered = false;
        }
        return notAnsweredQuestion;
    }

    public void endTest(boolean isLast)
    {
        onBackPressed();
        onBackPressed();
        onBackPressed();
        if (isLast)
        {
            onBackPressed();
        }
        setCurrentPage(0);
        questionsList = new ArrayList<>();
    }

    public ArrayList<StudyCourse> getWinner() {
        return winner;
    }

    public void setWinner(ArrayList<StudyCourse> winner) {
        this.winner = winner;
    }

    public StudyCourse getAlternative() {
        return alternative;
    }

    public void setAlternative(StudyCourse alternative) {
        this.alternative = alternative;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public int getWidth()
    {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;
    }
    public void openImage(int id)
    {
        imageID = id;
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
        ft.add(R.id.activityLayout, new FullscreenImageFragment(), "FullscreenImageFragment");
        ft.addToBackStack(FullscreenImageFragment.class.getSimpleName());
        ft.commit();
    }

    public Drawable getImage()
    {
        return getResources().getDrawable(imageID);
    }

    public TextSize getTextSize() {
        return textSize;
    }

    public void setTextSize(TextSize textSize)
    {
        this.textSize = textSize;
        setTextSizeForViews();
    }

    public void setTextSizeForViews()
    {
        if (this.textSize.equals(TextSize.MIDDLE))
        {
            study_button.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_middle));
            study_job_button.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_middle));
            study_test_button.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_middle));
            study_dual_button.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_middle));
            education_button.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_middle));
            maps_button.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_middle));
            hftl_button.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_middle));
            toolbarTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.special_title_size_middle));
        }
        else if (this.textSize.equals(TextSize.SMALL))
        {
            study_button.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size));
            study_job_button.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size));
            study_test_button.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size));
            study_dual_button.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size));
            education_button.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size));
            maps_button.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size));
            hftl_button.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size));
            toolbarTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.special_title_size));
        }
        else if (this.textSize.equals(TextSize.BIG))
        {
            study_button.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_big));
            study_job_button.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_big));
            study_test_button.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_big));
            study_dual_button.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_big));
            education_button.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_big));
            maps_button.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_big));
            hftl_button.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.default_button_text_size_big));
            toolbarTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.special_title_size_big));
        }
    }
}