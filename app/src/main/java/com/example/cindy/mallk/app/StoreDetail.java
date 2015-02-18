package com.example.cindy.mallk.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class StoreDetail extends ActionBarActivity {
    TextView txtStoreName,txtLinkData, btnCallStore, txtStorePhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_detail);
        txtStoreName = (TextView) findViewById(R.id.storeName);
        txtLinkData =(TextView) findViewById(R.id.linkData);
        btnCallStore =(Button) findViewById(R.id.callStore);
        txtStorePhone =(TextView) findViewById(R.id.storePhone);

        Linkify.addLinks(txtLinkData,Linkify.ALL);
        Linkify.addLinks(btnCallStore,Linkify.ALL);
        Linkify.addLinks(txtStorePhone,Linkify.ALL);

        String name= getIntent().getStringExtra("NAME");

        txtStoreName.setText(name);
        //Toast.makeText(this,name,Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_store_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent i = getIntent();

        switch (id){
            case R.id.action_share:
                String name = i.getStringExtra("NAME");
                String msg = getString(R.string.message, name);

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(intent.EXTRA_TEXT, msg);
                intent.setType("text/plain");

                startActivity(Intent.createChooser(intent,getString(R.string.share)));
                return true;
            case R.id.action_settings:
                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }

//        return super.onOptionsItemSelected(item);
    }
}
