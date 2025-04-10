package com.yogify.study.ui.component

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.airbnb.lottie.LottieAnimationView
import com.yogify.study.R


class ProgessLayout(context: Context?, attrs: AttributeSet?) : RelativeLayout(
    context!!, attrs
) {


    private var progess: Boolean
    private var animationfile: Int
    private var progessBackground: Int
    private var containtLayoutEnable: Boolean

    private var layoutprogess: LinearLayout
    private var animatiom_view: LottieAnimationView

    init {

        inflate(context, R.layout.layout_progess, this)
        layoutprogess = this.findViewById(R.id.ll_progess)
        animatiom_view = this.findViewById(R.id.animation_view)


        val a = context!!.theme.obtainStyledAttributes(attrs, R.styleable.ProgessLayout, 0, 0)

        try {

            var hasprogess = a.hasValue(R.styleable.ProgessLayout_showprogess)
            if (hasprogess) {
                progess = a.getBoolean(R.styleable.ProgessLayout_showprogess, false)
            } else {
                progess = true
            }

            var hasanimationfile = a.hasValue(R.styleable.ProgessLayout_animationfile)

            if (hasanimationfile) {
                animationfile = a.getResourceId(R.styleable.ProgessLayout_animationfile, 0)
            } else {
                animationfile = R.raw.progess
            }

            var hasBackground = a.hasValue(R.styleable.ProgessLayout_progessbackground)
            if (hasBackground) {
                progessBackground = a.getColor(R.styleable.ProgessLayout_progessbackground, 0)
            } else {
                progessBackground = this.resources.getColor(R.color.background_progess)
            }

            var hasContaintEnable = a.hasValue(R.styleable.ProgessLayout_containlayoutenable)
            if (hasContaintEnable) {
                containtLayoutEnable = a.getBoolean(R.styleable.ProgessLayout_containlayoutenable, false)
            } else {
                containtLayoutEnable = false
            }

            setShowProgress(progess)
            setanimationFile(animationfile)
            setProgessBackground(progessBackground)
            setEnableControls(containtLayoutEnable, this)

        } finally {
            a.recycle()
        }

    }

    fun setShowProgress(isshow: Boolean) {
        progess = isshow
        if (progess) {
            layoutprogess.visibility = View.VISIBLE
        } else {
            layoutprogess.visibility = View.GONE
        }

    }

    fun setanimationFile(filesourse: Int) {
        animationfile = filesourse
        animatiom_view.setAnimation(animationfile)
    }

    fun setProgessBackground(filesourse: Int) {
        progessBackground = filesourse
        layoutprogess.setBackgroundColor(progessBackground)
    }


    fun setEnableControls(enable: Boolean, vg: ViewGroup) {

        for (i in 0 until vg.childCount) {
            val child = vg.getChildAt(i)
            child.isEnabled = enable
            child.isClickable = enable
            if (child is ViewGroup) {
                setEnableControls(enable, child)
            }
        }

    }
}


