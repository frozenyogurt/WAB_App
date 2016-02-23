package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.R;

/**
 * Created by student on 09.02.2016.
 */
public class ServicesSportFragment extends MyRefreshFragment
{
    public ServicesSportFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.services_sport_fragment,container,false);

        TextView beginning = (TextView) view.findViewById(R.id.services_sport_beginning_text);
        TextView titleOne = (TextView) view.findViewById(R.id.services_sport_title_one);
        TextView titleTwo = (TextView) view.findViewById(R.id.services_sport_title_two);
        TextView titleThree = (TextView) view.findViewById(R.id.services_sport_title_three);
        TextView titleFour = (TextView) view.findViewById(R.id.services_sport_title_four);
        TextView textOne = (TextView) view.findViewById(R.id.services_sport_text_one);
        TextView textTwo = (TextView) view.findViewById(R.id.services_sport_text_two);
        TextView textThree = (TextView) view.findViewById(R.id.services_sport_text_three);
        TextView textFour = (TextView) view.findViewById(R.id.services_sport_text_four);
        LinearLayout goToSportWebsite = (LinearLayout) view.findViewById(R.id.services_sport_website);

        TextView title = (TextView) view.findViewById(R.id.title_services_sport);
        title.setText("Sport");
        TextView websiteText = (TextView) view.findViewById(R.id.services_sport_website_text);
        websiteText.setText("Anmeldung und Informationen");

        goToSportWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).goToWebsite("http://sport.htwk-leipzig.de/");
            }
        });

        beginning.setText("Der Sport bietet eine gute Möglichkeit, im studentischen Umfeld mit KommilitonInnen anderer Studiengänge in Kontakt zu kommen. Deshalb haben wir ein attraktives Sportangebot für unsere Studierenden.\n" +
                "Gemeinsam mit dem Hochschulsportzentrum der HTWK Leipzig können unsere Studierenden auch neue Sporttrends kennenlernen. Durch Hochschulmeisterschaften und nationale Meisterschaften bieten sich Möglichkeiten zum gemeinsamen Sporttreiben und geselligem Beisammmensein.");
        titleOne.setText("Sportangebote an der HfTL");
        titleTwo.setText("Zeiten für das Sportangebot der HfTL");
        titleThree.setText("Sportanlagen der HfTL");
        titleFour.setText("Hochschulinterne und außerschulische Turniere und Meisterschaften");

        textOne.setText("Über unser aktuelles Sportangebot in der Sporthalle Arno-Nitzsche-Str. 29 informiert der Sportreferent des HfTL-Studentenrats.\n" +
                "Folgende Sportarten werden direkt von der HfTL betreut:\n" +
                "Fußball\n" +
                "Volleyball\n" +
                "Klettern\n" +
                "Laufen\n" +
                "Badminton\n" +
                "Zahlreiche andere Sportarten, wie Aikido, Baseball, Basketball oder Volleyball werden über das Hochschulsportzentrum der HTWK Leipzig angeboten und können auch von unseren Studierenden genutzt werden. Diese Angebote sind allerdings zum Teil kostenpflichtig. Informieren und anmelden können Sie sich über:\n" +
                "sport.htwk-leipzig.de");
        textTwo.setText("Ab sofort kann in der Sporthalle Arno-Nitzsche-Str. 29 an folgenden Tagen gespielt werden:\n" +
                "Fußball: Montags 17:30 - 19:00 Uhr\n" +
                "Volleyball: Dienstags 17:30 - 19:00 Uhr\n" +
                "Klettern: Dienstags 17:30 - 19:00 Uhr\n" +
                "Laufen: Donnerstags ab 15:30 Uhr\n" +
                "Badminton: Montags 17:30 - 19:00 Uhr\n" +
                "(Badminton kann zusätzlich auch an jedem anderen Wochentag ganztägig gespielt werden)");
        textThree.setText("Sporthalle Arno-Nitzsche-Str. 29\n" +
                "Tischtennisplatte in der HfTL");
        textFour.setText("Im laufenden Studienjahr werden in Abstimmung mit dem Studentenrat 3 bis 4 Hochschulmeister- schaften und Turniere durchgeführt. Die Auswahlmannschaften nehmen jährlich an den Hochschulmeisterschaften des Landes Sachsen teil.\n" +
                "Die HfTL ist Mitglied des ADH (Allgemeiner Deutscher Hochschulsportverband) und kann bei Qualifizierung in einer Sportart auf Landesebene an den Deutschen Hochschulmeisterschaften der Bundesrepublik Deutschland teilnehmen.");

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.underline);
        int color = ((MainActivity) getActivity()).convertColorString();
        if (color != 0)
        {
            layout.setBackgroundColor(color);
            titleOne.setTextColor(color);
            titleTwo.setTextColor(color);
            titleThree.setTextColor(color);
            titleFour.setTextColor(color);
        }
        else
        {
            color = getActivity().getResources().getColor(R.color.hftl_info_color);
            layout.setBackgroundColor(color);
            titleOne.setTextColor(color);
            titleTwo.setTextColor(color);
            titleThree.setTextColor(color);
            titleFour.setTextColor(color);
        }

        return view;
    }
}
