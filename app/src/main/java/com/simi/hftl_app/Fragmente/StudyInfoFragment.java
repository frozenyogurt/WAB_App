package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.simi.hftl_app.Listen.StudyListItem;
import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.Category;
import com.simi.hftl_app.Model.StudyCourse;
import com.simi.hftl_app.R;

/**
 * Created by student on 10.02.2016.
 */
public class StudyInfoFragment extends MyRefreshFragment
{
    public StudyInfoFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.study_info_fragment, container, false);

        StudyListItem element = ((MainActivity) getActivity()).getClickedElement();
        TextView title = (TextView) view.findViewById(R.id.infoStudyTitle);
        title.setText(element.getName());

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.TitleUndeline);
        TextView titleJob = (TextView) view.findViewById(R.id.jobPerspectivesTitle);
        TextView titleCurri = (TextView) view.findViewById(R.id.curriculumTitle);
        if (element.getCategory().equals(Category.NORMAL))
        {
            layout.setBackgroundColor(getActivity().getResources().getColor(R.color.study_color));
            titleJob.setTextColor(getActivity().getResources().getColor(R.color.study_color));
            titleCurri.setTextColor(getActivity().getResources().getColor(R.color.study_color));
        }
        else if (element.getCategory().equals(Category.DUAL))
        {
            layout.setBackgroundColor(getActivity().getResources().getColor(R.color.study_dual_color));
            titleJob.setTextColor(getActivity().getResources().getColor(R.color.study_dual_color));
            titleCurri.setTextColor(getActivity().getResources().getColor(R.color.study_dual_color));
        }
        else
        {
            layout.setBackgroundColor(getActivity().getResources().getColor(R.color.study_job_color));
            titleJob.setTextColor(getActivity().getResources().getColor(R.color.study_job_color));
            titleCurri.setTextColor(getActivity().getResources().getColor(R.color.study_job_color));
        }

        TextView beginning = (TextView) view.findViewById(R.id.beginningText);
        TextView perspectives = (TextView) view.findViewById(R.id.jobPerspectivesText);
        TextView curriculumText = (TextView) view.findViewById(R.id.curriculumText);

        if (element.getCourse().equals(StudyCourse.ICT_MASTER)) //???????????????????????????????????
        {
            beginning.setText(getActivity().getResources().getString(R.string.ICT_MASTER_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.ICT_MASTER_PERSPECTIVES_TEXT));
            curriculumText.setText(getActivity().getResources().getString(R.string.ICT_MASTER_CURRICULUM_TEXT));
        }
        else if (element.getCourse().equals(StudyCourse.KMI_BACHELOR))
        {

            beginning.setText(getActivity().getResources().getString(R.string.KMI_BACHELOR_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.KMI_BACHELOR_PERSPECTIVES_TEXT));
            curriculumText.setText(getActivity().getResources().getString(R.string.KMI_BACHELOR_CURRICULUM_TEXT));
    }
        else if (element.getCourse().equals(StudyCourse.DUAL_KMI_BACHELOR))
        {
            beginning.setText(getActivity().getResources().getString(R.string.DUAL_KMI_BACHELOR_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.DUAL_KMI_BACHELOR_PERSPECTIVES_TEXT));
            curriculumText.setText(getActivity().getResources().getString(R.string.DUAL_KMI_BACHELOR_CURRICULUM_TEXT));
        }
        else if (element.getCourse().equals(StudyCourse.JOB_KMI_BACHELOR))
        {
            beginning.setText(getActivity().getResources().getString(R.string.JOB_KMI_BACHELOR_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.JOB_KMI_BACHELOR_PERSPECTIVES_TEXT));
            curriculumText.setText(getActivity().getResources().getString(R.string.JOB_KMI_BACHELOR_CURRICULUM_TEXT));
        }
        else if (element.getCourse().equals(StudyCourse.IKT_BACHELOR))
        {
            beginning.setText(getActivity().getResources().getString(R.string.IKT_BACHELOR_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.IKT_BACHELOR_PERSPECTIVES_TEXT));
            curriculumText.setText(getActivity().getResources().getString(R.string.IKT_BACHELOR_CURRICULUM_TEXT));
        }
        else if (element.getCourse().equals(StudyCourse.IKT_MASTER))
        {
            beginning.setText(getActivity().getResources().getString(R.string.IKT_MASTER_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.IKT_MASTER_PERSPECTIVES_TEXT));
            curriculumText.setText(getActivity().getResources().getString(R.string.IKT_MASTER_CURRICULUM_TEXT));
        }
        else if (element.getCourse().equals(StudyCourse.IKT_MASTER_ENGLISH)) //Passt hier nicht rein!
        {
            beginning.setText("");
            perspectives.setText("");
            curriculumText.setText("");
        }
        else if (element.getCourse().equals(StudyCourse.JOB_IKT_BACHELOR))
        {
            beginning.setText(getActivity().getResources().getString(R.string.JOB_IKT_BACHELOR_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.JOB_IKT_BACHELOR_PERSPECTIVES_TEXT));
            curriculumText.setText(getActivity().getResources().getString(R.string.JOB_IKT_BACHELOR_CURRICULUM_TEXT));
        }
        else if (element.getCourse().equals(StudyCourse.JOB_IKT_MASTER))
        {
            beginning.setText("Mit dem Master in Informations- und Kommunikationstechnik runden wir unser Spektrum an berufsbegleitenden Studiengängen ab. Das Angebot der HfTL ist optimal auf Deinen Joballtag abgestimmt, denn Du kannst viele Leistungen über Lernplattformen im Internet erbringen – zeitlich und örtlich flexibel. Der Master qualifiziert Dich für verschiedene Einsatzfelder in der IKT-Branche und bereitet Dich darauf vor, Führungsverantwortung zu übernehmen. ");
            perspectives.setText("Als Informations- und Kommunikationstechniker bist Du ganz flexibel einsetzbar – nämlich immer dort, wo es auf eigenverantwortliches Handeln und Entscheiden ankommt: in der Forschung und Entwicklung, bei der Projektierung, der Planung und Überwachung sowie im Marketing und Vertrieb. Da Du sowohl IT-Kompetenz als auch betriebswirtschaftliches Wissen mitbringst, behältst Du immer beide Gesichtspunkte im Auge. Du konzipierst zum Beispiel Netze und Übertragungsstrecken oder managst IT-Systeme.");
            curriculumText.setText("\tPflichtmodule: \n" +
                    "Angewandte Mathematik \n" +
                    "ICT-Consulting \n" +
                    "Projektmanagement \n" +
                    "Informations- und Kommunikationstechnik Laborpraktika \n" +
                    "Recht \n" +
                    "Arbeit am Projekt \n" +
                    " \n" +
                    "Profilierungsmodule:\n" +
                    "10 aus dem Bereich Kommunikationstechnik \n" +
                    "10 Profilierungsmodule aus dem Bereich Informationstechnologie \n" +
                    "\n" +
                    " Das aktuelle Angebot entnehmen Sie bitte dem Curriculum ");
        }
        else if (element.getCourse().equals(StudyCourse.WI_BACHELOR))
        {
            beginning.setText("Unternehmen, die weltweit Lieferungen oder Dienstleistungen koordinieren müssen, sind auf absolut reibungslos funktionierende Systeme angewiesen. Hier kommst Du als Wirtschaftsinformatiker ins Spiel: Die von Dir entwickelte Software sorgt gemeinsam mit von Dir eingeführtem und überwachtem Prozessmanagement mit sorgfältiger Datenauswertung und Analyse im Logistik- und Informationschaos für Ordnung. Die Grundlagen für diese Fähigkeiten sind Kenntnisse in Betriebswirtschaft und Informatik, die Du an der HfTL vermittelt bekommst und in Praxisprojekten direkt unter Beweis stellen kannst.");
            perspectives.setText("Welches Unternehmen hat heute keine IT? Richtig: Keins. Du wirst nahezu überall gebraucht, wo es eine IT gibt, die im weitesten Sinne betriebswirtschaftliche Funktionen hat. Du kannst ganze Systeme gestalten und bist wichtiger Ansprechpartner im ganzen Unternehmen. Dein Arbeitsplatz kann sich in der Produktion, in der Logistik, im Controlling, im Vertrieb, im Marketing und in vielen anderen Abteilungen befinden. Als ProzessmanagerIn machst Du die Betriebsabläufe effizient, als Business Analyst kennst Du dich perfekt in den Unternehmensdaten aus. Damit bist Du von Anfang an ein wichtiger Partner für das Management und gestaltest die Zukunft des Unternehmens aktiv mit. ");
            curriculumText.setText("\tGrundlagen (Mathematik, Statistik, Projektmanagement & Arbeit mit Projekten, Technical & Business Englisch, Recht) \n" +
                    "Wirtschaft (Allgemeine Betriebswirtschaftslehre, Marketing & CRM, Volkswirtschaftslehre, Rechnungswesen & Controlling, Netzbasierte Geschäftsmodelle) \n" +
                    "Informatik (Programmierung, Rechnerarchitekturen, Kommunikationsnetze, Verteilte Anwendungen, IT-Sicherheit) \n" +
                    "Wirtschaftsinformatik (Grundlagen, Prozessmanagement, Datenmanagement, IT-Service- & Supply Chain-Management, Betriebliche Informationssysteme, Softwareengineering, Business Intelligence) \n" +
                    "Profilierung für den internationalen Informations- und Telekommunikationssektor");
        }
        else if (element.getCourse().equals(StudyCourse.DUAL_WI_BACHELOR))
        {
            beginning.setText("Der duale Studiengang Wirtschaftsinformatik, kurz WI, ermöglicht Dir ein Bachelor-Studium an der HfTL und den Einstieg in das Unternehmen Deutsche Telekom. An der HfTL absolvierst Du Dein Studium, lernst wissenschaftliches Arbeiten und erwirbst den Bachelor-Abschluss. Im Praxiseinsatz lernst Du alles über betriebliche Anwendungs- und Informationssysteme und Informations- und Wissensmanagement – in direkter Einbindung in die Arbeitsprozesse der Deutschen Telekom.");
            perspectives.setText("Wirtschaftsinformatiker planen und entwickeln IT- und Kommunikationssysteme und sind direkt an der Konzeption von Geschäftsprozessen beteiligt. Diese können die unterschiedlichsten Bereiche betreffen: Löhne und Gehälter, Produktion, Vertrieb, Kundenservice... Deine Einsatzmöglichkeiten sind sehr vielfältig. \n" +
                    "\n" +
                    "Durch Deine betriebswirtschaftliche Ausbildung kannst Du in Deinen Planungen auf Veränderungen am Markt reagieren und Deine Prozesse flexibel anpassen – für den Erfolg Deines Unternehmens bist Du also an entscheidender Stelle mitverantwortlich. Als „Dolmetscher“ zwischen Informatik und Betriebswirtschaft besetzt du als Business Analyst, Prozessmanager oder auch Online-Marketing-Professional die entscheidenden Schaltstellen des Geschäfts – in nahezu allen Branchen.");
            curriculumText.setText("\tGrundlagen (Mathematik, Statistik, Projektmanagement, Technical & Business Englisch, Recht) \n" +
                    "Wirtschaft (Allgemeine Betriebswirtschaftslehre, Marketing & CRM, Volkswirtschaftslehre, Rechnungswesen und Controlling, Netzbasierte Geschäftsmodelle) \n" +
                    "Informatik (Programmierung, Hard- und Softwaresysteme, Kommunikationsnetze, Verteilte Anwendungen, IT-Sicherheit) \n" +
                    "Wirtschaftsinformatik (Prozessmanagement, Datenmanagement, IT-Service- & Supply Chain Management, Betriebliche Informationssysteme, Softwareengineering, Business Intelligence)");
        }
        else if (element.getCourse().equals(StudyCourse.DUAL_WI_MASTER))
        {
            beginning.setText("Der duale Master ist in Deutschland ein noch nicht sehr verbreitetes Angebot für die Weiterentwicklung von Bachelor-Absolventen aber umso interessanter für Dich, wenn Du ein abgeschlossenes Bachelor-Studium im Bereich der Wirtschaftsinformatik und Talent für höhere Aufgaben hast. Wenn Du einen Bachelor in Wirtschaftswissenschaften oder Informatik hast, kannst Du nach einer Prüfung Deiner Qualifikationen ebenfalls zugelassen werden. Dein Vorteil: Du studierst mit einem Vertrag bei der Deutschen Telekom und kannst so die innovativen Konzepte und Methoden der Wirtschaftsinformatik aus dem Studium direkt praktisch anwenden und dabei auch schon richtiges Gehalt bekommen.\n" +
                    "Der duale Master-Studiengang Wirtschaftsinformatik der HfTL vermittelt Kompetenzen zur Umsetzung IT-gestützter Transformationsprozesse in Unternehmen und Unternehmensnetzwerken.");
            perspectives.setText("Der Master-Studiengang Wirtschaftsinformatik deckt die Themenfelder Enterprise Information Management, Management of Business Information Models und Software & Service Management ab. Details zu den einzelnen Themenfeldern haben wir in einer Dropdown-Liste zusammengefasst:");
            curriculumText.setText("\tPflichtmodule:\n" +
                    "Information Management\n" +
                    "IT-Recht \n" +
                    "New Business Development & Technology Management \n" +
                    "IT-Controlling\n" +
                    "Business Information & Process Modeling\n" +
                    "Research Methods\n" +
                    "Business Process Optimization\n" +
                    "Enterprise Architecture Management\n" +
                    "Software Engineering\n" +
                    "Software Management\n" +
                    "IT-Project Management\n" +
                    "IT-Service Management\n" +
                    "\n" +
                    "Profilierungsbereiche:\n" +
                    "Software Engineering\n" +
                    "Business Analytics");
        }
        else if (element.getCourse().equals(StudyCourse.JOB_WI_BACHELOR))
        {
            beginning.setText("Wenn Du berufstätig bist, kannst Du Dich mit dem Studiengang Wirtschaftsinformatik neben dem Job weiter qualifizieren. Die Studienbedingungen an der HfTL sind optimal auf Deine Bedürfnisse abgestimmt: Lernplattformen und Tutorien im Netz sorgen für zeitliche und räumliche Flexibilität und gewährleisten zusammen mit Präsenzphasen an der Hochschule ein fundiertes Studium. \n" +
                    "\n" +
                    "Als Wirtschaftsinformatiker sprichst Du die Sprache der Betriebswirte und kennst den Wortschatz der Informatik – schließlich bist Du später als Dolmetscher zwischen diesen Welten tätig. Daher verfeinern wir Dein Kommunikationstalent auf Deutsch und Englisch. Einen Einblick bekommst Du zudem in die Rechtswissenschaft.");
            perspectives.setText("Wirtschaftsinformatiker arbeiten fachübergreifend und häufig in internationalen Teams. Sie sind sowohl in Unternehmen als auch in der öffentlichen Verwaltung tätig. Als Prozessmanager hast Du die Zahlen und den Kunden im Blick. Du schaust Dir die bestehenden Geschäftsprozesse genau an, um sie wirtschaftlicher und kundenorientierter auszurichten und stimmst Dich eng mit den anderen Unternehmensbereichen ab. Du sorgst zum Beispiel dafür, dass Prozesse für die Lohn- und Gehaltsabrechnung und die Kundenbetreuung besser funktionieren. \n" +
                    "\n" +
                    "Als Online Marketing Professional kümmerst Du Dich um die Planung, Koordination und Umsetzung von Marketinginstrumenten im Netz. Eine Karriere als Business Analyst ist das Richtige für Dich, wenn Du Daten zum Leben erwecken möchtest. Du weißt sie zu interpretieren und ziehst daraus wichtige Erkenntnisse über das Verhalten von Märkten, Kunden und Konkurrenten. Klar, dass Du für das Management ein wichtiger Ansprechpartner bist und die Zukunft des Unternehmens unmittelbar mitgestaltest.");
            curriculumText.setText("Grundlagen: \n" +
                    "Mathematik, Statistik, Projektmanagement, Technical & Business Englisch, Recht \n" +
                    "\n" +
                    "Wirtschaft: \n" +
                    "Allgemeine Betriebswirtschaftslehre, Marketing & CRM, Volkswirtschaftslehre, Rechnungswesen und Controlling, Netzbasierte Geschäftsmodelle \n" +
                    "\n" +
                    "Informatik: \n" +
                    "Programmierung, Hard- und Softwaresysteme, Kommunikationsnetze, Verteilte Anwendungen, IT-Sicherheit \n" +
                    "\n" +
                    "Wirtschaftsinformatik: \n" +
                    "Prozessmanagement, Datenmanagement, IT-Service- & Supply Chain Management, Betriebliche Informationssysteme, Softwareengineering, Business Intelligence");
        }
        else if (element.getCourse().equals(StudyCourse.JOB_WI_MASTER))
        {
            beginning.setText("Im berufsbegleitenden Studiengang Wirtschaftsinformatik beschäftigst Du Dich mit Wissensgebieten, die zur Erschließung des Produktionsfaktors Information in vernetzten Unternehmen notwendig sind. Da wir Dir an der HfTL viele Lerninhalte online vermitteln, bleibst Du als Berufstätiger immer flexibel. Wenn Du ein abgeschlossenes Bachelor-Studium im Bereich Wirtschaftsinformatik hast, bist Du optimal auf den Master vorbereitet. Aber auch mit einem Bachelor in Wirtschaftswissenschaften oder Informatik kannst Du nach Prüfung der Vorqualifikationen zugelassen werden.");
            perspectives.setText("Mit einem Master in Wirtschaftsinformatik hast Du in der digitalen Welt ausgezeichnete Berufsperspektiven. Du bist ein wichtiger Ansprechpartner für Unternehmen, die IT-gestützte Transformationsprozesse umsetzen möchten. Bei der Arbeit helfen Dir nicht nur Deine tiefgreifenden Kenntnisse in Informatik, sondern auch Dein rechtliches Wissen im IT-Bereich.");
            curriculumText.setText("Pflichtmodule:\n" +
                    "Information Management\n" +
                    "IT-Recht\n" +
                    "New Business Development & Technology Management\n" +
                    "IT-Controlling\n" +
                    "Business Information & Process Modeling\n" +
                    "Research Methods\n" +
                    "Business Process Optimization\n" +
                    "Enterprise Architecture Management\n" +
                    "Software Engineering\n" +
                    "Software Management\n" +
                    "IT-Project Management\n" +
                    "IT-Service Management \n" +
                    "\n" +
                    "Profilierungsbereiche:\n" +
                    "Software Engineering\n" +
                    "Enterprise Planning & Decision Support");
        }
        else if (element.getCourse().equals(StudyCourse.DUAL_AI_BACHELOR))
        {
            beginning.setText("Der duale Studiengang Angewandte Informatik, kurz AI, ermöglicht Dir eine Erstausbildung in Verbindung mit einem Einstieg in das Unternehmen Deutsche Telekom. Er wird mit einem Vertrag der Deutschen Telekom durchgeführt. In diesem Studium lernst Du die Grundlagen der Informatik kennen und wirst in zukunftsorientierte Technologien aus den Bereichen Automotive, Smart Home, Cybersecurity und vielen mehr eingeführt. Da Du immer in die Arbeitsprozesse der Telekom eingebunden bist, sind ein optimaler Lernerfolg und Praxisbezug gesichert.");
            perspectives.setText("Absolventen der Angewandten Informatik sind Multitalente: Deine im Studium erworbenen Kenntnisse werden in nahezu allen innovativen Branchen gebraucht. Cloud Computing, Smart Home, Visualisierung, Datensicherheit und Automotive sind nur einige Bereiche, in denen Du z.B. als Projektmanager arbeiten kannst. Als Schnittstelle zwischen verschiedenen Unternehmensbereichen zeigst Du, was jetzt und in Zukunft machbar ist. Damit Du Deine Ideen auch international optimal vermitteln kannst, steigern wir im Studium auch Deine kommunikativen Fähigkeiten in Deutsch und Englisch. Dein Studiengang ermöglicht Dir den nahtlosen Einstieg in zahlreiche Unternehmensfelder der Deutschen Telekom, aber auch vielfältige Chancen in Versicherungen, Banken, Internet-Dienstleistern und vielen Industrieunternehmen.");
            curriculumText.setText("Grundlagen (Mathematik, Programmierung, Elektrotechnik, Physik, Technische Informatik, Projektmanagement, Technical & Business Englisch, Recht)\n" +
                    "Rechnernetze, Datenbankmanagementsysteme, Betriebssysteme, Sicherheit in Webanwendungen, Rechnerarchitekturen, Softwareengineering, Systemtheorie, Netzinfrastrukturen und Protokolle, Webtechnologien, Verteilte Anwendungen, Datenschutz, Betriebswirtschaftslehre, Projektmanagement, Profilierungsmodule, Social Media Communication, Zukunftstechnologien");
        }

        return view;
    }
}