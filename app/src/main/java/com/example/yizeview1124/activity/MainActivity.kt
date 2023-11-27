package com.example.yizeview1124.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.yizeview1124.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

const val ARG_OBJECT = "object"
const val ARG_SAMPLE = "sampleLayoutRes"
const val ARG_PRACTICE = "practiceLayoutRes"

class MainActivity : FragmentActivity() {
    // 2.声明adapter，之后再初始化
    private lateinit var tabCollectionAdapter: TabCollectionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 初始化适配器，传入本页
        tabCollectionAdapter = TabCollectionAdapter(this)
//        tabCollectionAdapter = TabPracticeAdapter(this)
        var viewPager2 = findViewById<ViewPager2>(R.id.pager_main)
        // 3.viewPager的adapter
        viewPager2.adapter = tabCollectionAdapter

        val tabLayout = findViewById<TabLayout>(R.id.tab_main)
        // 4.tab的命名，跟viewPager绑定
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            // 【注意】resource.getString可以通过资源id取到资源的字符串。
            tab.text = resources.getString(pageModels[position].titleRes)
        }.attach()


    }

}

// 1. 写tab的adapter，给每个Fragment传数据
class TabCollectionAdapter(activity: MainActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = pageModels.size

    override fun createFragment(position: Int): Fragment {
        val pageModel = pageModels[position]
        return TabFragment.Util.newInstance(pageModel.sampleLayoutRes, pageModel.practiceLayoutRes)
    }

}

class TabPracticeAdapter(activity: MainActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = pageModels.size

    override fun createFragment(position: Int): Fragment {
        val pageModel = pageModels[position]
        return TabFragment.Util.newInstance(pageModel.sampleLayoutRes, pageModel.practiceLayoutRes)
    }

}
