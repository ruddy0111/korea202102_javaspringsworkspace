package com.koreait.exam.pager;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.koreait.exam.fragments.BlueFragment;
import com.koreait.exam.fragments.RedFragment;
import com.koreait.exam.fragments.YellowFragment;


//ViewPager는 뷰에 불과하므로, 실제적으로 몇페이지, 어떤 페이지 등을 보여줄지를 결정짓는
//어댑터를 정의해본다..
public class MyAdapter extends FragmentStateAdapter {
    Fragment[] page = new Fragment[3];

    //생성자 호출시, 액티비티 넘기면 된다!!
    public MyAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        page[0] = new YellowFragment();
        page[1] = new RedFragment();
        page[2] = new BlueFragment();
    }

    //총 몇 페이지인지 반환하여, viewPager가 페이지 수를 구성할 수 있도록..
    public int getItemCount() {
        return page.length;
    }

    public Fragment createFragment(int position) {
        return page[position];
    }
}
