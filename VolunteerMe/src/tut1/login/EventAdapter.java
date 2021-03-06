package tut1.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

public class EventAdapter extends BaseExpandableListAdapter {
	
    private List<EventData> events;
    private LayoutInflater inflater;

    public EventAdapter(Context context, List<EventData> countries) {
        this.events = countries;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return events.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return EventData.childDataTotal;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return events.get(groupPosition).eventName;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
    	
    	if( childPosition == 0 )
    		return events.get(groupPosition).beginTime;
    	else if( childPosition == 1 )
    		return events.get(groupPosition).location;
    	else if( childPosition == 2 )
    		return events.get(groupPosition).description;
    	
    	return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(android.R.layout.simple_expandable_list_item_1, parent, false);
        }

        ((TextView) convertView).setText(getGroup(groupPosition).toString());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        ((TextView)convertView).setText(getChild(groupPosition,childPosition).toString());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i2) {
        return false;
    }
}
