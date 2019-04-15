package com.example.maxim.protov20;


import android.os.Bundle;
import android.app.Fragment;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomListFragment extends ListFragment {


    public CustomListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.custom_list_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
       super.onActivityCreated(bundle);
//        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), ,
//                android.R.layout.simple_list_item_1);
    }

}
