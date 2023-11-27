package com.example.yizeview1124.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import android.widget.RelativeLayout
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.example.yizeview1124.R

class TabFragment : Fragment() {

    object Util {
        fun newInstance(
            @LayoutRes sampleLayoutRes: Int,
            @LayoutRes practiceLayoutRes: Int
        ): TabFragment {
            val fragment = TabFragment()
            val args = Bundle()
            args.putInt("sampleLayoutRes", sampleLayoutRes)
            args.putInt("practiceLayoutRes", practiceLayoutRes)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 默认的，不用管
        return inflater.inflate(R.layout.fragment_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.getInt("sampleLayoutRes",-1)?.let { layoutId->
            view.findViewById<RelativeLayout>(R.id.example_layout)?.apply {
                val v = LayoutInflater.from(context).inflate(layoutId,null)
                addView(v)
            }
        }

        arguments?.getInt("practiceLayoutRes", -1)?.let { layoutId->
            view.findViewById<RelativeLayout>(R.id.practice_layout)?.apply {
                addView(LayoutInflater.from(context).inflate(layoutId, null))
            }
        }

        // 每一页的内容，这里用ARG_OBJECT传的页数
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
//             val imageView: ImageView = view.findViewById(R.id.img_ani)
//            imageView.setImageResource(arrayList[getInt(ARG_OBJECT) - 1 ])

        }
    }

}

var pageModels: List<PageModel> = arrayListOf(
    PageModel(R.layout.sample_color, R.string.title_draw_color, R.layout.practice_color),
    PageModel(R.layout.sample_circle, R.string.title_draw_circle, R.layout.practice_circle),
    PageModel(R.layout.sample_rect, R.string.title_draw_rect, R.layout.practice_rect),
    PageModel(R.layout.sample_point, R.string.title_draw_point, R.layout.practice_point),
    PageModel(R.layout.sample_oval, R.string.title_draw_oval, R.layout.practice_oval),
    PageModel(R.layout.sample_line, R.string.title_draw_line, R.layout.practice_line),
    PageModel(
        R.layout.sample_round_rect,
        R.string.title_draw_round_rect,
        R.layout.practice_round_rect
    ),
    PageModel(R.layout.sample_arc, R.string.title_draw_arc, R.layout.practice_arc),
    PageModel(R.layout.sample_path, R.string.title_draw_path, R.layout.practice_path),
    PageModel(
        R.layout.sample_histogram,
        R.string.title_draw_histogram,
        R.layout.practice_histogram
    ),
    PageModel(R.layout.sample_pie_chart, R.string.title_draw_pie_chart, R.layout.practice_pie_chart)
)

class PageModel internal constructor(
    @field:LayoutRes @param:LayoutRes var sampleLayoutRes: Int,
    @field:StringRes @param:StringRes var titleRes: Int,
    @field:LayoutRes @param:LayoutRes var practiceLayoutRes: Int
)