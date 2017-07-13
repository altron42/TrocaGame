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

import java.util.ArrayList;
import java.util.List;

import tk.trocagame.trocagame.R;
import tk.trocagame.trocagame.utils.Console;


public class InicioFragment extends Fragment {

    private Toolbar toolbar;
    private ViewPager mViewPager;
    private TabLayout tabLayout;


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

        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        //((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mViewPager = (ViewPager) rootView.findViewById(R.id.container);
        setupViewPager(mViewPager);

        tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        return rootView;
    }

    /*
     * Adicionar as outras fragments aqui
     * Atentar aos parametros passados ao instanciar novos fragments
     */
    private void setupViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(
                ((AppCompatActivity)getActivity()).getSupportFragmentManager());
        adapter.addFragment(new ConsoleInicioFragment().newInstance(Console.PS3), "PS3");
        adapter.addFragment(new ConsoleInicioFragment().newInstance(Console.PS4), "PS4");
        adapter.addFragment(new ConsoleInicioFragment().newInstance(Console.XBOX360), "XBOX 360");
        adapter.addFragment(new ConsoleInicioFragment().newInstance(Console.XBOXONE), "XBOX One");
        adapter.addFragment(new ConsoleInicioFragment().newInstance(Console.WII), "WII");
        adapter.addFragment(new ConsoleInicioFragment().newInstance(Console.SWITCH), "Switch");

        viewPager.setAdapter(adapter);
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
