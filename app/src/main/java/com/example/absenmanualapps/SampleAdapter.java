package com.example.absenmanualapps;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class SampleAdapter extends FragmentStateAdapter {

    public SampleAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position==0){
            MasukFragment fragment1 = new MasukFragment();
            return fragment1;

        }else{
            DaftarFragment fragment2 = new DaftarFragment();
            return fragment2;
        }
    }

    //ngasih tau berapa tab yang ditampilkan
    @Override
    public int getItemCount() {
        return 2;
    }
}
