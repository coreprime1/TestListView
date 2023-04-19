package com.dreamyards.testmynewfirebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class StableArrayAdapter extends ArrayAdapter<Tache> {

    HashMap<Integer, Tache> mIdMap = new HashMap<Integer, Tache>();
    Context mContext;

    int viewID;

    public StableArrayAdapter(Context context, int textViewResourceId,
                              List<Tache> objects) {
        super(context, textViewResourceId, objects);
        mContext = context;
        viewID = textViewResourceId;
        for (int i = 0; i < objects.size(); ++i) {
            mIdMap.put(i, objects.get(i));
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(viewID, parent, false);
        TextView titre = (TextView) rowView.findViewById(R.id.tache_titre);
        TextView description = (TextView) rowView.findViewById(R.id.tache_description);

        Tache tache = mIdMap.get(Integer.valueOf(position));
        titre.setText(tache.getNom());
        description.setText(tache.getDescription());

        return rowView;
    }

}
