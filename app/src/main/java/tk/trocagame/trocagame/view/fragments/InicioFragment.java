package tk.trocagame.trocagame.view.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tk.trocagame.trocagame.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class InicioFragment extends Fragment {

    private ViewPager mViewPager;
    private SectionsPagerAdapter mSectionsPagerAdapter;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Inicio");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_inicio,container, false);
        Toolbar toolbar =(Toolbar)rootView.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        mSectionsPagerAdapter= new SectionsPagerAdapter(((AppCompatActivity)getActivity()).getSupportFragmentManager());

        mViewPager =(ViewPager)rootView.findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabLayout= (TabLayout)rootView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);



        return rootView;
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    PS3Fragment tab1= new PS3Fragment();
                    return tab1;
                case 1:
                    XboxFragment tab2 = new XboxFragment();
                    return tab2;
                case 2:
                    WiiFragment tab3= new WiiFragment() ;
                    return tab3;
                default:
                    return null;

            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "PS3";
                case 1:
                    return "XBOX";
                case 2:
                    return "WII";
            }
            return null;
        }
    }
}
