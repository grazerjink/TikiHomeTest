package com.winsonmac.tikihometest.controllers.keyword

import android.content.Context
import android.graphics.Color
import com.google.gson.JsonElement
import com.winsonmac.core.base.BaseViewModel
import com.winsonmac.tikihometest.apis.APICallback
import com.winsonmac.tikihometest.apis.ListAPIKeyword
import com.winsonmac.tikihometest.env.Constants
import com.winsonmac.tikihometest.models.KeywordModel


/* =========================================================================================== */
/*  Binding model                                                                              */
/* =========================================================================================== */

class KeywordListViewModel(context: Context) : BaseViewModel<ListAPIKeyword>(context) {

    /**
     * Get color for keyword
     */
    private val colors = intArrayOf(
        Color.parseColor("#651e3e"),
        Color.parseColor("#d50000"),
        Color.parseColor("#005b96"),
        Color.parseColor("#004d40"),
        Color.parseColor("#1e88e5"),
        Color.parseColor("#8d6e63"),
        Color.parseColor("#00897b"),
        Color.parseColor("#f9a825"),
        Color.parseColor("#afb42b"),
        Color.parseColor("#512da8"),
        Color.parseColor("#c2185b"),
        Color.parseColor("#7b1fa2")
    )


    /**
     * Property for binding on view
     */
    val mKeywordAdapter: KeywordListAdapter = KeywordListAdapter(context, mutableListOf())


    /**
     * Call api get list keywords
     */
    fun getKeywordList(completion: (success: Boolean, message: Int?, messageTitle: Int?) -> Unit) {
        api().getKeywordList().enqueue(APICallback<JsonElement> { success, data, message ->
            if (success) {
                val keywords = mutableListOf<KeywordModel>()
                data?.apply {
                    var colorIndex = 0

                    asJsonArray.forEachIndexed { index, item ->
                        if (colorIndex == 12) colorIndex = 0
                        keywords.add(KeywordModel(item.asString, colors[colorIndex]))
                        colorIndex++
                    }
                }
                mKeywordAdapter.addAllItems(keywords)
                completion.invoke(true, null, null)
            } else {
                completion.invoke(false, message, Constants.MESSAGE_ERROR_TITLE)
            }
        })
    }
}
