package com.simi.hftl_app.Fragmente;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.simi.hftl_app.R;

/**
 * Created by student on 12.02.2016.
 */
public class ContactHFTLFragment extends Fragment
{
    public ContactHFTLFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.contact_hftl_fragment,container,false);

        TextView text = (TextView) view.findViewById(R.id.contact_text);
        LinearLayout sendForm = (LinearLayout) view.findViewById(R.id.send_form);

        text.setText("Kontakt Text");

        sendForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.hft-leipzig.de/de/kontakt/kontakt.html"));
                startActivity(intent);
            }
        });

        return view;
    }
}
