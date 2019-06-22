package com.example.expandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by K.I Prihan Nimsara on 2019-06-12.
 */
public class MyExpandableListviewAdapter extends BaseExpandableListAdapter {

    Context context;
    List<String> langs;
    Map<String,List<String>> topics;

    public MyExpandableListviewAdapter(Context context, List<String> langs, Map<String, List<String>> topics) {
        this.context = context;
        this.langs = langs;
        this.topics = topics;
    }

    @Override
    public int getGroupCount() {
        return langs.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return topics.get(langs.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return langs.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return topics.get(langs.get(i)).get(i);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String langs = (String) getGroup(i);
        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.parent_list,null);
        }
        TextView txtParent = (TextView)view.findViewById(R.id.txtparent);
        txtParent.setText(langs);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String topics = (String) getChild(i,i1);
        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.child_list,null);
        }
        TextView txtChild = (TextView)view.findViewById(R.id.txtchild);
        txtChild.setText(topics);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
