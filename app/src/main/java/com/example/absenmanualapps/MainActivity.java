package com.example.absenmanualapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {


    TabLayoutMediator mediator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager2 viewPager = findViewById(R.id.pager);

        SampleAdapter adapter = new SampleAdapter(getSupportFragmentManager(), getLifecycle());
        //tempel ke pager , pager buat pindah
        viewPager.setAdapter(adapter);

        String[] tab = new String[]{"Masuk", "Daftar"};
        mediator = new TabLayoutMediator(tabLayout, viewPager, (tab1, position) -> tab1.setText(tab[position]));
        mediator.attach();
    }


}
