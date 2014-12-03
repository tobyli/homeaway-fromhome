package com.homeawayfromhome;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.PopupWindow;
import android.widget.ExpandableListView;
import android.widget.ExpandableListAdapter;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.Menu;
import android.widget.ExpandableListView;


public class ResultList extends Activity {

    ListView listView;

    public final static String S_TAB = "away";
//    PopupWindow popupWindowDogs;
    SparseArray<Group> groups = new SparseArray<Group>();
    public class Group {

        public String string;
//        public final List<String> children = new ArrayList<String>();

        public Group(String string) {
            this.string = string;
        }

    }

    public class MyExpandableListAdapter extends BaseExpandableListAdapter {

        private final SparseArray<Group> groups;
        public LayoutInflater inflater;
        public Activity activity;

        public MyExpandableListAdapter(Activity act, SparseArray<Group> groups) {
            activity = act;
            this.groups = groups;
            inflater = act.getLayoutInflater();
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
//            return groups.get(groupPosition).children.get(childPosition);
            return null;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return 0;
        }

        @Override
        public View getChildView(int groupPosition, final int childPosition,
                                 boolean isLastChild, View convertView, ViewGroup parent) {
            final String children = (String) getChild(groupPosition, childPosition);

            TextView text = null;

            TextView text_2 = null;
            TextView text_3 = null;
            TextView text_4 = null;

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.listrow_details, null);
            }
//            text = (TextView) convertView.findViewById(R.id.sublist_textview_1);
//            text_2 = (TextView) convertView.findViewById(R.id.sublist_textview_2);
            text_3 = (TextView) convertView.findViewById(R.id.sublist_textview_3);
//            text_4 = (TextView) convertView.findViewById(R.id.sublist_textview_4);

            text_3.setText(Html.fromHtml(" It is similar to <b>Main Street</b> in <b>Madison, WI</b> because it has a lot of bars and drunk people. It is also considered as the home of crazy people"));

//            text.setText(children);

            return convertView;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
//            return groups.get(groupPosition).children.size();
            return 1;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groups.get(groupPosition);
        }

        @Override
        public int getGroupCount() {
            return groups.size();
        }

        @Override
        public void onGroupCollapsed(int groupPosition) {
            super.onGroupCollapsed(groupPosition);
        }

        @Override
        public void onGroupExpanded(int groupPosition) {
            super.onGroupExpanded(groupPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return 0;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.listrow_group, null);
            }
            Group group = (Group) getGroup(groupPosition);
            ((CheckedTextView) convertView).setText(group.string);
            ((CheckedTextView) convertView).setChecked(isExpanded);
            return convertView;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return false;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_list);

//        listView = (ListView) findViewById(R.id.list);
//
//        final String[] values = new String[] { "1. Uptown \n Similarity Score: 9.2/10",
//                "2. West Calhoun \n Similarity Score: 8.7/10",
//                "3. Dinkytown \n Similarity Score: 8.2/10",
//                "4. Downtown \n Similarity Score: 7.8/10",
//                "5. Seward \n Similarity Score: 7.1/10",
//                "6. East Harriet \n Similarity Score: 7.0/10",
//                "7. Linden Hills \n Similarity Score: 6.8/10",
//                "8. Kingfield \n Similarity Score: 6.5/10",
//                "9. Marcy Holmes \n Similarity Score: 6.1/10",
//                "10. Longfellow \n Similarity Score: 5.8/10"
//
//        };
//
//        ExpandableListView listView = (ExpandableListView) findViewById(R.id.list);
//           ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, android.R.id.text1, values);
////        MyExpandableListAdapter adapter = new MyExpandableListAdapter(this,
////                groups);
//        listView.setAdapter(adapter);


//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, android.R.id.text1, values);
//
//        listView.setAdapter(adapter);
//        listView.setBackgroundColor(Color.RED);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                int itemPosition = position;
//                String itemValue = (String) listView.getItemAtPosition(position);
//
////                View click_list = getLayoutInflater().inflate(R.layout.list_click, R.layout.activity_result_list);
//
////               PopupWindow popup = new PopupWindow();
////                popup.setContentView(click_list);
//                Toast.makeText(getApplicationContext(),
//                        itemValue , Toast.LENGTH_LONG)
//                        .show();
//            }
//        });

        createData();
        ExpandableListView listView = (ExpandableListView) findViewById(R.id.list);
        MyExpandableListAdapter adapter = new MyExpandableListAdapter(this,
                groups);
        listView.setAdapter(adapter);

    }

    final String[] values = new String[] { "1. East Isles \n Similarity Score: 7.2/10",
            "2. West Calhoun \n Similarity Score: 6.7/10",
            "3. Dinkytown \n Similarity Score: 6.2/10",
            "4. Downtown \n Similarity Score: 5.8/10",
            "5. Seward \n Similarity Score: 5.1/10",
            "6. East Harriet \n Similarity Score: 5.0/10",
            "7. Linden Hills \n Similarity Score: 4.8/10",
            "8. Kingfield \n Similarity Score: 4.5/10",
            "9. Marcy Holmes \n Similarity Score: 4.1/10",
            "10. Longfellow \n Similarity Score: 3.8/10"

    };

    final String[] subtext_1 = new String[] { "East Isles \n Similarity Score: 7.2/10",
            "West Calhoun \n Similarity Score: 6.7/10",
            "Dinkytown \n Similarity Score: 6.2/10",
            "Downtown \n Similarity Score: 5.8/10",
            "Seward \n Similarity Score: 5.1/10",
            "East Harriet \n Similarity Score: 5.0/10",
            "Linden Hills \n Similarity Score: 4.8/10",
            "Kingfield \n Similarity Score: 4.5/10",
            "Marcy Holmes \n Similarity Score: 4.1/10",
            "Longfellow \n Similarity Score: 3.8/10"

    };





    public void createData() {
        for (int j = 0; j < 10; j++) {
            Group group = new Group(values[j]);

//            group.children.add(subtext_1[j]);

            groups.append(j, group);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result_list, menu);
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

    public void goMap(View view)
    {
        Intent intent = new Intent(this, RootMap.class);
        intent.putExtra(S_TAB,"Minneapolis");
        startActivity(intent);

    }


}
