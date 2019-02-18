package com.osipov.moneytracker;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainPagesAdapter extends FragmentPagerAdapter {

    private static final int PAGE_INCOMES = 0;
    private static final int PAGE_EXPENSES = 1;
    private static final int PAGE_BALANCE = 2;

    private String currentPage;
    private String[] tabTitle;

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case PAGE_INCOMES:
                currentPage = Item.TYPE_INCOMES;
                break;

            case PAGE_EXPENSES:
                currentPage = Item.TYPE_EXPENSES;

        }
        Fragment fragment = new ItemsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ItemsFragment.TYPE_KEY, currentPage);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    public MainPagesAdapter(FragmentManager fm, Context context) {
        super(fm);
        tabTitle = context.getResources().getStringArray(R.array.tabs);

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return  tabTitle[position];
    }
}
