package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.Category;
import com.simi.hftl_app.Model.StudyCourse;
import com.simi.hftl_app.R;
import com.simi.hftl_app.Listen.StudyListItem;

/**
 * Created by student on 10.02.2016.
 */
public class StudyInfoFragment extends Fragment
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
            //getActivity().getResources().getDrawable(R.drawable.pbh_saupe); //Test aber noch entfernen
        }
        else if (element.getCourse().equals(StudyCourse.KMI_BACHELOR))
        {

            beginning.setText(getActivity().getResources().getString(R.string.KMI_BACHELOR_BEGINNING_TEXT));
            perspectives.setText(getActivity().getResources().getString(R.string.KMI_BACHELOR_PERSPECTIVES_TEXT));
            curriculumText.setText(getActivity().getResources().getString(R.string.KMI_BACHELOR_CURRICULUM_TEXT));


            perspectives.setText("Unternehmen organisieren sich immer stärker in Netzwerken: Zulieferer, Partner und Kunden werden in großen Systemen organisiert. Hierfür braucht man Softwareentwickler und Systembetreuer – und damit Dich. Du lernst, wie man sichere Netze konzipiert, entwickelt und einführt. Auch im Projektmanagement kannst Du als SystemarchitektIn oder SystemdesignerIn arbeiten – nicht nur bei der Telekom: Auch andere Informations- und Telekommunikationsunternehmen melden einen hohen Fachkräftebedarf für Leute mit Deiner Ausbildung an. Zudem stellen Automobilhersteller, Hard- und Softwarefirmen, der Energiesektor und Behörden Kommunikations- und MedieninformatikerInnen gerne ein. ");
            curriculumText.setText("\tallgemeine Grundlagen (Projektmanagement, Wirtschaft und Recht, technisches Englisch) \n" +
                    "Mathematisch-naturwissenschaftliche Grundlagen (Mathematik, Physik, Elektrotechnik/Elektronik) \n" +
                    "Informatik (Grundlagen, Programmierung, Softwaretechnik, Datenbanken, Hard- und Softwarearchitekturen, Netze, Simulationen, Routing, Switching, Protokolle) \n" +
                    "Verteilte Anwendungen \n" +
                    "Telekommunikation (Signale und Systeme, Übertragungstechnik, Netzmanagement, Funk)");
        }
        else if (element.getCourse().equals(StudyCourse.DUAL_KMI_BACHELOR))
        {
            beginning.setText("Im dualen Studiengang Kommunikations- und Medieninformatik, erhältst Du eine Erstausbildung und den Einstieg in das Unternehmen Deutsche Telekom. Du studierst mit einem Vertrag der Deutschen Telekom AG in enger Verzahnung zwischen Studium und Beruf. So kannst Du sowohl in der Hochschule, als auch im Unternehmen das Wissen für Deinen späteren Beruf erwerben. Präsenzphasen an der HfTL kombinieren sich im Studienverlauf mit Selbstlernphasen von Zuhause aus. Deine erworbenen Kenntnisse in Mathematik, Physik, Elektrotechnik, Informatik und Telekommunikation kannst Du in Projekten der Telekom direkt in betrieblichen Aufgabenstellungen anwenden.");
            perspectives.setText("Nach dem Erwerb deines Bachelor of Engineering kannst Du viele Wege einschlagen. Besonders weil der Kommunikationsbedarf der ganzen Welt rasant ansteigt. Ein konkretes Beispiel ist das Qualitätsmanagement: Du koordinierst und überwachst alle Prozesse, so dass am Ende ein gutes Produkt entsteht. Netzbetreiber wie die Telekom verlassen sich auf dein analytisches Können: In Kapazitätsplanung- und Management entwickelst Du die Netze von Morgen. Außerdem kriegst Du durch deine duale Studienform in deinem Betrieb viel Erfahrung, wodurch dir eine Übernahme im Konzern fast garantiert ist.");
            curriculumText.setText("allgemeine Grundlagen (Projektmanagement, Wirtschaft und Recht, technisches Englisch) \n" +
                    "mathematisch-naturwissenschaftliche Grundlagen (Mathematik, Physik, Elektrotechnik/Elektronik) \n" +
                    "Informatik (Grundlagen, Programmierung, Softwaretechnik, Datenbanken, Hard- und Softwarearchitekturen, Netze, Simulationen, Routing, Switching, Protokolle) \n" +
                    "Verteilte Anwendungen \n" +
                    "Telekommunikation (Signale und Systeme, Übertragungstechnik, Netzmanagement, Funk)");
        }
        else if (element.getCourse().equals(StudyCourse.JOB_KMI_BACHELOR))
        {
            beginning.setText("Der Bachelor-Studiengang Kommunikations- und Medieninformatik ermöglicht Dir eine Weiterbildung parallel zum Beruf. Da Du den Großteil der Qualifizierung zeitlich und örtlich flexibel über eine Online-Lernplattform absolvierst, kannst Du das Studium optimal mit Deinem Beruf vereinbaren. \n" +
                    "\n" +
                    "Kommunikations- und Medieninformatik vermittelt Kenntnisse aus den Bereichen Physik, Elektrotechnik, Informatik und Telekommunikation. Du lernst, die neuen Medien ganzheitlich zu begreifen. Auf welche informationstechnischen Prinzipien und Technologien basiert das Web 2.0? Wie funktionieren soziale Netzwerke und Applikationen? Das und mehr vermitteln wir Dir an der HfTL.");
            perspectives.setText("Die Nachfrage nach IT-Fachkräften ist groß, deren Einsatzpalette bunt. Hier nur einige Beispiele für mögliche Berufsfelder: Weil sich Unternehmen zunehmend mit ihren Zulieferern, Kunden und Partnern vernetzen, entstehen immer komplexere IT-Landschaften. Deren Planung und Betrieb verantworten System- und Netzwerkspezialisten. Sie sorgen dafür, dass die internetbasierten Dienste der Kunden – wie beispielsweise deren Webportale – jederzeit verfügbar sind. \n" +
                    "\n" +
                    "Kommunikations- und Medieninformatiker sind zudem als Software-Entwickler tätig. Sie schaffen unter anderem Applikationen für Desktop PCs oder Smartphones und behalten dabei immer die Sicherheits- und Qualitätsstandards im Blick. Systemarchitekten entwickeln und verwalten internetbasierte Anwendungen und Webportale. Um komplette Firmennetzwerke und um den weltweiten Breitbandausbau kümmern sich Netzarchitekten. Und Consultants beraten die Kunden bei IT-Projekten.");
            curriculumText.setText("allgemeine Grundlagen: \n" +
                    "Projektmanagement, Wirtschaft und Recht, technisches Englisch \n" +
                    "\n" +
                    "Mathematisch-naturwissenschaftliche Grundlagen: \n" +
                    "Mathematik, Physik, Elektrotechnik/Elektronik \n" +
                    "\n" +
                    "Informatik: \n" +
                    "Grundlagen, Programmierung, Softwaretechnik, Datenbanken, Hard- und Softwarearchitekturen, Netze, Simulationen, Routing, Switching, Protokolle  \n" +
                    "\n" +
                    "Verteilte Anwendungen, Telekommunikation: \n" +
                    "Signale und Systeme, Übertragungstechnik, Netzmanagement, Funk  ");
        }
        else if (element.getCourse().equals(StudyCourse.IKT_BACHELOR))
        {
            beginning.setText("Für Nachrichten benötigt man Signale – egal, ob es um das Verschicken einer SMS geht oder um das Produktionsband in einem Fahrzeugwerk. Dafür, dass diese Signale und die von ihnen transportierten Informationen ihren Weg zum richtigen Empfänger finden, sorgen NachrichtentechnikerInnen. \n" +
                    "Die Informations- und Kommunikationstechnik ist als ein Zusammenspiel von Mathematik, Physik, Informatik und Elektrotechnik zu verstehen – jede Teildisziplin trägt zur gemeinsamen Aufgabe entscheidend bei. So lassen sich Systeme gestalten, mit denen Informationen über die unterschiedlichsten Medien übertragen werden können. Dabei geht es im Kern um Übertragungsmedien, um Signalaufbereitung und -verarbeitung sowie um Verfahren und Methoden der Nachrichtenübermittlung an den Empfänger.");
            perspectives.setText("Der Kommunikationsbedarf der Menschen steigt rasant – die Welt wird digital. Daher stehen Dir als KommunikationstechnikerIn sehr viele Chancen in den unterschiedlichsten Unternehmen und Tätigkeitsfeldern offen. \n" +
                    "\n" +
                    "Ein konkretes Beispiel ist das Fertigungs- und Qualitätsmanagement: Du koordinierst und überwachst die Tätigkeiten Deiner Kollegen, damit am Ende ein gutes Produkt entsteht. Netzbetreiber hingegen verlassen sich auf Dein analytisches Können und Deine vorausschauenden Fähigkeiten: In Kapazitätsplanung und -management legst Du die Grundlagen für das Netz von morgen. Auch in Einkauf und Logistik, im Dienstleistungsbereich, im Marketing, im Vertrieb, in der Automobilindustrie, in der Medizintechnik, in der Steuerungs- und Regeltechnik, in Schulung und Weiterbildung... Nachrichtentechnik ist einfach überall.");
            curriculumText.setText("allgemeine Grundlagen (Projektmanagement, Wirtschaft und Recht, technisches Englisch) \n" +
                    " Mathematisch-naturwissenschaftliche Grundlagen (Mathematik, Physik) \n" +
                    " Grundlagen der Elektrotechnik und Informationstechnik (Informatik, Elektrotechnik) \n" +
                    " Signale & Systeme \n" +
                    " Photonik \n" +
                    " Felder & Wellen \n" +
                    " Netze \n" +
                    " Funk \n" +
                    " Hard- und Softwarearchitektur");
        }
        else if (element.getCourse().equals(StudyCourse.IKT_MASTER))
        {
            beginning.setText("Mit einem Master in Informations- und Kommunikationstechnik legst Du einen wichtigen Grundstein für Deine Karriere in der Telekommunikationsbranche. Der Abschluss eröffnet Dir aber noch ganz andere Möglichkeiten: Vertiefte Fachkenntnisse in Telekommunikation, Informatik und Schlüsselqualifikationen aus BWL, Recht und Projektmanagement machen Dich bereit für leitende Positionen ganz weit oben auf der Karriereleiter. Mit dem Master erhältst Du alle Voraussetzungen, um komplexe Telekommunikationssysteme verantwortlich zu entwickeln und Führungsverantwortung zu übernehmen.");
            perspectives.setText("Informations- und KommunikationstechnikerInnen arbeiten in nahezu allen Branchen und in den unterschiedlichsten Bereichen. Ihr Fachwissen sowie ihre Management- und Methodenkompetenz werden von Unternehmen wie der Deutschen Telekom, SAP, Siemens oder IBM weltweit geschätzt. Als Master-AbsolventIn der Informations- und Kommunikationstechnik kannst Du Projekte managen und effizient führen – schließlich durchschaust Du auch die ökonomischen Zusammenhänge. \n" +
                    "\n" +
                    "Die Einsatzgebiete für den „Master of Engineering“ sind weit gesteckt: Konzeption von Netzen und Übertragungsstrecken, Entwicklung von IT-Systemen, Forschung und Entwicklung in den unterschiedlichsten Bereichen gehören zu den klassischen Aufgaben. Aber auch im Marketing und im Vertrieb kannst Du Deinen ökonomischen Sachverstand mit deinem technischen Fachwissen effizient kombinieren. ");
            curriculumText.setText("\tDas Studium gliedert sich in einen Kernbereich und 2 Profilierungsmodule.\n" +
                    "Kernbereich: \n" +
                    " Angewandte Mathematik \n" +
                    " Systemtheorie \n" +
                    " Software-Technologie \n" +
                    " Photonik \n" +
                    " Systeme der Funktechnik \n" +
                    " Networking \n" +
                    " BWL \n" +
                    " Recht \n" +
                    " Projektmanagement \n" +
                    " \n" +
                    "Profilierungsmodule Kommunikationstechnik \n" +
                    " \n" +
                    "Profilierungsmodule Informationstechnologie ");
        }
        else if (element.getCourse().equals(StudyCourse.IKT_MASTER_ENGLISH)) //Passt hier nicht rein!
        {
            beginning.setText("");
            perspectives.setText("");
            curriculumText.setText("");
        }
        else if (element.getCourse().equals(StudyCourse.JOB_IKT_BACHELOR))  //Verlinkung auf HFTL Seite geht nicht.
        {
            beginning.setText("Der Bachelor-Studiengang Informations- und Kommunikationstechnik ist eine berufsbegleitende Weiterqualifizierung, die Dir Kenntnisse zu den Anforderungen moderner Telekommunikation vermittelt. Damit Du immer die Balance zwischen Beruf und Studium hältst, bietet Dir die HfTL moderne IT-gestützte Bildungstechnologien sowie Lehr- und Lernszenarien auf der Basis des Web 2.0. \n" +
                    "\n" +
                    "Der Studiengang ist speziell auf die Anforderungen der Deutschen Telekom zugeschnitten. Zu den Inhalten gehören Mathematik, Physik, Informatik und Elektrotechnik. Du lernst das Wichtigste zu Übertragungsmedien, Signalaufbereitung und -verarbeitung sowie zu Verfahren und Methoden der Nachrichtenübermittlung.");
            perspectives.setText("Als Informations- und Kommunikationstechniker hast Du zahlreiche Berufsmöglichkeiten: Entwicklungsingenieure sind immer dann gefragt, wenn es um technische Problemstellungen geht. Sie entwickeln wirtschaftlich arbeitende IT-Lösungen und optimieren diese laufend. Projektingenieure planen und betreiben Geräte und Anlagen der Nachrichtentechnik. Sie übernehmen die Projektleitung und haben dabei immer die Wünsche der Kunden im Blick. Vertriebsingenieure planen und steuern komplexe Marketing- und Vertriebsprozesse im nachrichtentechnischen Umfeld. Zu ihren Tätigkeiten gehören auch Marktforschung und Konkurrenzanalyse. \n" +
                    "\n" +
                    "Ein wichtiger Trend auf dem Telekommunikationsmarkt ist die Konvergenz – das Zusammenwachsen von Sprach- und Datendiensten sowie Mobil- und Festnetz. Um diese Entwicklung zu gestalten, brauchen Unternehmen Informations- und Kommunikationstechniker, die sich vor allem um die Kapazitätsplanung und das Management kümmern. Schließlich sollten Netze so konzipiert sein, dass sie den Ansprüchen von morgen gerecht werden. ");
            curriculumText.setText("Grundlagen:\n" +
                    "Projektmanagement, Technisches Englisch, Wirtschaft, Recht,\n" +
                    "Wissenschaftlich Angeleitete Berufspraxis, Studienbegleitung zur Vertiefung von Soft- und Management Skills, Projektarbeit (innovative Projekte aus dem Unternehmen DTAG und Forschungsarbeiten an der Hochschule)\n" +
                    "\n" +
                    "Mathematisch-naturwissenschaftliche Grundlagen:\n" +
                    "Mathematik, Physik, Messtechnik, Elektrotechnik, Schaltungstechnik,\n" +
                    "Telekommunikationstechnik und Telekommunikationsnetze\n" +
                    "Signalverarbeitung, Grundprinzipien der Datenkompression, Methoden\n" +
                    "zum Schutz von Signalen vor Übertragungsfehlern, Übertragungsverfahren, optische Übertragungssysteme und -technologien (vom Weitverkehr bis in das\n" +
                    "Zugangsnetz), Hochfrequenztechnik, mobile Datenkommunikation\n" +
                    "Qualitätsanalyse und Qualitätssicherungsverfahren in\n" +
                    "Telekommunikationsnetzen im Rahmen des Netzmanagements, verkehrstheoretische Informationsflussanalysen, Planung von Netzen\n" +
                    "\n" +
                    "Informatik:\n" +
                    "Grundlagen der Informatik, Programmierung und technische Informatik\n" +
                    "\n" +
                    "Betriebswirtschaft:\n" +
                    "Kostenmanagement, Kunden- und Preismanagement, Rechnungswesen,\n" +
                    "Controlling, Marketing ");
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