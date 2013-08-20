package com.example.charactertranslater;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.viewpagerindicator.IconPagerAdapter;

class TestFragmentAdapter extends FragmentPagerAdapter implements IconPagerAdapter {
	public ArrayList<String> CONTENT=new ArrayList<String>();
	public ArrayList<String> INICONTENT=new ArrayList<String>();
    
    private int mCount = CONTENT.size();

    public TestFragmentAdapter(FragmentManager fm) {
        super(fm);
    }
    public TestFragmentAdapter(FragmentManager fm, ArrayList<String> content, ArrayList<String> inicontent) {
        super(fm);
        CONTENT=content;
        INICONTENT=inicontent;
        mCount=CONTENT.size();
    }
    

    @Override
    public Fragment getItem(int position) {
        return TestFragment.newInstance(CONTENT.get(position%CONTENT.size()));
    }

    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
      return this.INICONTENT.get(position % INICONTENT.size());
    }


    public void setCount(int count) {
        if (count > 0 && count <= 10) {
            mCount = count;
            notifyDataSetChanged();
        }
    }

	@Override
	public int getIconResId(int index) {
		// TODO Auto-generated method stub
		return 0;
	}
}