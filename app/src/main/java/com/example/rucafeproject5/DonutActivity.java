package com.example.rucafeproject5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Activity class that directly controls our activity_donut activity (.xml) file.
 * This class uses Intent to set up the activities for different Donut flavors (Jelly,
 * Boston Cream, Glazed, Blueberry, and Cinnamon Sugar). Whenever these are clicked in the listView
 * a new activity is opened up to finish donut ordering
 * @author Manveer Singh, Prasidh Sriram
 */
public class DonutActivity extends AppCompatActivity {

    private ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    public static final String SEND_MESSAGE = "com.example.rucafeproject5.extra.MESSAGE";

    /**
     * Method that adds our donut flavor to the listView and then populates for user usage along with
     * using intent to open up individual activities for donut flavors (5 of them)
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donut);
        arrayList.add("Cinnamon Sugar");
        arrayList.add("Jelly");
        arrayList.add("Glazed");
        arrayList.add("Blueberry");
        arrayList.add("Boston Cream");
        listView = (ListView) findViewById(R.id.donutListView);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * Whenever Jelly, Boston Cream, Glazed, Blueberry or Cinnamon Sugar is clicked, this onItemClick
             * method opens up a new activity specifically for that flavor
             * @param parent
             * @param view
             * @param position
             * @param id
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("Jelly") || parent.getItemAtPosition(position).equals("Boston Cream") || parent.getItemAtPosition(position).equals("Glazed") || parent.getItemAtPosition(position).equals("Blueberry") || parent.getItemAtPosition(position).equals("Cinnamon Sugar")) {
                    Intent intent = new Intent(DonutActivity.this, DonutOrderActivity.class);
                    String message = arrayList.get(position).toString();
                    intent.putExtra(SEND_MESSAGE, message);
                    startActivity(intent);
                }
            }
        });


    }
}