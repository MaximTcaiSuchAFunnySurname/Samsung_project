package com.example.maxim.protov20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
        Button add;
        Button switchButton;
        ListView listView;
        List<String> list, listDeleted;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            listView = (ListView) findViewById(R.id.list);
            switchButton = (Button) findViewById(R.id.switch_button);
            add = (Button) findViewById(R.id.add);
            final long[] buttonCTRL = {0};
            final ArrayAdapter<String> regularList = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, list);
            final ArrayAdapter<String> deleteList = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, listDeleted);
            listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent,
                                               View view, int position, long id) {
                    String temp = list.get(position);
                    list.remove(position);
                    listDeleted.add(temp);
                    regularList.notifyDataSetChanged();
                    deleteList.notifyDataSetChanged();
                    return true;
                }
            });
            switchButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (buttonCTRL[0] % 2 == 0) {
                        listView.setAdapter(regularList);
                        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                            @Override
                            public boolean onItemLongClick(AdapterView<?> parent,
                                                           View view, int position, long id) {
                                String temp = list.get(position);
                                list.remove(position);
                                listDeleted.add(temp);
                                regularList.notifyDataSetChanged();
                                deleteList.notifyDataSetChanged();
                                return true;
                            }
                        });
                    } else {
                        listView.setAdapter(deleteList);
                        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                            @Override
                            public boolean onItemLongClick(AdapterView<?> parent,
                                                           View view, int position, long id) {
                                listDeleted.remove(position);
                                deleteList.notifyDataSetChanged();
                                return true;
                            }
                        });
                    }
                    buttonCTRL[0]++;
                }
            });

        }
    }
