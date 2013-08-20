package com.example.charactertranslater;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.viewpagerindicator.TitlePageIndicator;

public class SampleTitlesWithListener extends BaseSampleActivity {
	private Button backbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.simple_titles);
        ArrayList<String> strs=getResultStrings(this.getIntent().getStringExtra("resultString"));
        ArrayList<String> inis=getResultStrings(this.getIntent().getStringExtra("iniString"));
        
        Log.v("mylog", strs.toString());
        mAdapter = new TestFragmentAdapter(getSupportFragmentManager(),strs,inis);
        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        mIndicator = (TitlePageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);

        mIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
    private ArrayList<String> getResultStrings(String result)
    {
    	ArrayList<String> ans=new ArrayList<String>();
    	for(int i=0;i<result.length();i++)
    		ans.add(result.charAt(i)+"");
    	return ans;
    }
}