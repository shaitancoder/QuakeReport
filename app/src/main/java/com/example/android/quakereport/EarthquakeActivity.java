/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONException;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
       /* ArrayList<Flavour> androidFlavors = new ArrayList<>();

        androidFlavors.add(new Flavour ("9.8","San Francisco","feb 2 2016"));

        androidFlavors.add(new Flavour( "4.8","London","Mar 2 2016"));

        androidFlavors.add(new Flavour( "5.6","New York","Apr 5 2017"));

        androidFlavors.add(new Flavour( "3.5","Moscow","feb 2 2016"));

        androidFlavors.add(new Flavour( "1.4","San Francisco","feb 2 2016"));

        androidFlavors.add(new Flavour( "5.6","San Francisco","feb 2 2016"));

        androidFlavors.add(new Flavour( "4.7","San Francisco","feb 2 2016"));

        androidFlavors.add(new Flavour("2.7","San Francisco","feb 2 2016"));
*/

        ArrayList<Flavour> androidFlavors = QueryUtils.extractEarthquakes();


        // Get a reference to the ListView, and attach the adapter to the listView.

        ListView listView = (ListView) findViewById(R.id.list);
        FlavourAdapter flavorAdapter = new FlavourAdapter(this, androidFlavors);

        listView.setAdapter(flavorAdapter);

        final FlavourAdapter adapter=new FlavourAdapter(this,androidFlavors);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Flavour currentEarthquake = adapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri earthquakeUri = Uri.parse(currentEarthquake.getUrl());

                // Create a new intent to view the earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);

            }
        });
    }
}
