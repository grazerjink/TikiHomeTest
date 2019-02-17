package com.winsonmac.tikihometest.env.utils

import android.databinding.BindingAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import com.winsonmac.core.util.FontUtil

/* =========================================================================================== */
/*  Add a custom attribute for some views in need                                              */
/* =========================================================================================== */

object BindingUtil {

    /**
     * Setup layout manager for recycler view and the orientation for it
     */
    @JvmStatic
    @BindingAdapter("horizontalLayoutManager")
    fun setHorizontalLayoutManager(recyclerView: RecyclerView, horizontal: Boolean) {
        if (horizontal) {
            recyclerView.layoutManager =
                    LinearLayoutManager(recyclerView.context, LinearLayoutManager.HORIZONTAL, false)
        } else {
            recyclerView.layoutManager =
                    LinearLayoutManager(recyclerView.context)
        }
    }

    /**
     * Setup adapter for recycler for showing data
     */
    @JvmStatic
    @BindingAdapter("adapter")
    fun setAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) {
        recyclerView.adapter = adapter
    }

    /**
     * Init & set font for the text view
     */
    @JvmStatic
    @BindingAdapter("font")
    fun setFont(textView: TextView, fontName: String) {
        textView.typeface = FontUtil.loadFont(textView.context, fontName)
    }
}