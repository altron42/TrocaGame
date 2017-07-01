package tk.trocagame.trocagame.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tk.trocagame.trocagame.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class XboxFragment extends Fragment {


    public XboxFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_xbox, container, false);
    }

}
