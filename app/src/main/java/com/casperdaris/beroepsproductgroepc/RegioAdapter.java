package com.casperdaris.beroepsproductgroepc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

// Deze klasse regelt dat de juiste fragments worden weergegeven aan de hand van de TabLayout in de RegioActivity
public class RegioAdapter extends FragmentPagerAdapter {

    // Alle freagments die in deze lijst komen te staan, worden weergegeven in de TabLayout in de RegioActivity
    private final List<Fragment> regioFragmentLijst = new ArrayList<>();
    // Deze lijst bevat de namen van de fragments uit de lijst hierboven
    private final List<String> regioFragmentLijstNamen = new ArrayList<>();

    public RegioAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return regioFragmentLijst.get(position);
    }

    // Het aantal fragments uit de lijst (regioFragmentLijst) ophalen
    @Override
    public int getCount() {
        return regioFragmentLijst.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return regioFragmentLijstNamen.get(position);
    }

    // Met deze methode kun je nieuwe fragments aan de TabLayout van de RegioActivity toevoegen
    public void fragmentToevoegen(Fragment fragment, String naam){
        regioFragmentLijst.add(fragment);
        regioFragmentLijstNamen.add(naam);
    }
}
