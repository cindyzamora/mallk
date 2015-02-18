package com.example.cindy.mallk.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = "com.example.cindy.mallk.app.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        private ArrayAdapter<String> mallAdapter;
        ArrayList<String> storesList;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            String[] storesArray = {
                    "La Tiendita",
                    "Tortillas los 3 tiempos",
                    "Tu amigo",
                    "La Bendicion"
            };

            storesList = new ArrayList<String>(
                    Arrays.asList(storesArray));

            mallAdapter =
                    new ArrayAdapter<String>(
                            getActivity(),
                            R.layout.list_item_stores,
                            R.id.list_item_stores_textview,
                            storesList
                    );

            ListView listView = (ListView) rootView.findViewById(
                    R.id.listview_stores);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i = new Intent(getActivity(),StoreDetail.class);
                    i.putExtra("NAME", storesList.get(position));
                    startActivity(i);
                }
            });
            listView.setAdapter(mallAdapter);

            return rootView;
        }
    }

    public void viewDetail(View view){
        Intent intent = new Intent(this, StoreDetail.class);

        ListView listView = (ListView) findViewById(R.id.listview_stores);

//        String message = listView.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, "Tiendaa");

        startActivity(intent);
    }
}
