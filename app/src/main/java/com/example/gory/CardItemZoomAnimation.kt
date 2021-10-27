package com.example.gory

import android.content.Context
import android.graphics.drawable.GradientDrawable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.Math.abs
import java.lang.Math.min

class CardItemZoomAnimation : LinearLayoutManager {

    private val shrinkValue = 0.15f
    private val shrinkDistance = 0.9f

    constructor(context: Context) : super(context)
    constructor(context: Context, orientation: Int, reverseLayout:Boolean) :
            super(context, orientation, reverseLayout)

    override fun scrollHorizontallyBy(
        dx: Int,
        recycler: RecyclerView.Recycler?,
        state: RecyclerView.State?
    ): Int {

        val orientation = orientation
        if(orientation == HORIZONTAL){
            val scroll = super.scrollHorizontallyBy(dx, recycler, state)

            val midPoint = width/2f
            val d0 = 0f
            val d1 = shrinkDistance * midPoint
            val s0 = 1f
            val s1 = 1f - shrinkValue

            for (i in 0 until childCount){
                val child = getChildAt(i)
                val chilMidPoint = (getDecoratedRight(child!!)
                        + getDecoratedLeft(child)/2f)
                val d = min(d1, abs(midPoint-chilMidPoint))
                val scale = s0+(s1-s0) * (d-d0)/(d1-d0)
                child.scaleX = scale
                child.scaleY = scale
            }

            return scroll
        }else{
            return 0;
        }

    }

}