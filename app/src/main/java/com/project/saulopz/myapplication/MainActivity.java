package com.project.saulopz.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Contact> list = new ArrayList<>();
    private int maxId = 0;
    private StableArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ContactActivity.class);
                Bundle parms = new Bundle();
                parms.putInt("id", 0);
                parms.putString("name", "");
                parms.putString("phone", "");
                intent.putExtras(parms);
                startActivityForResult(intent, 0);
            }
        });

        list.add(new Contact(221, "Arisa chan", "99999-1234"));
        list.add(new Contact(123, "Pati", "99999-4321"));
        adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, list);

        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(MainActivity.this, ContactActivity.class);
                Bundle parms = new Bundle();
                parms.putInt("id", ((Contact) parent.getItemAtPosition(position)).getId());
                parms.putString("name", ((Contact) parent.getItemAtPosition(position)).getName());
                parms.putString("phone", ((Contact) parent.getItemAtPosition(position)).getPhone());
                intent.putExtras(parms);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (data.hasExtra("id") && data.hasExtra("name") && data.hasExtra("phone")) {
                int id = data.getExtras().getInt("id");
                String name = data.getExtras().getString("name");
                String phone = data.getExtras().getString("phone");
                if (id == 0) {
                    maxId++;
                    adapter.add(new Contact(maxId, name, phone));
                } else {
                    for (Contact c : list) {
                        if (c.getId() == id) {
                            c.setName(name);
                            c.setPhone(phone);
                            adapter.notifyDataSetChanged();
                            break;
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void dialog(String title, String content) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(title);
        builder.setMessage(content);
        builder.setNeutralButton("OK", null);
        builder.show();
    }
}
