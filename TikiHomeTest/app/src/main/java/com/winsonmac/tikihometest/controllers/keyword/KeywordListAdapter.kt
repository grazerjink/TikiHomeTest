package com.winsonmac.tikihometest.controllers.keyword

import android.content.Context
import android.graphics.PorterDuff
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.winsonmac.core.base.BaseAdapter
import com.winsonmac.tikihometest.R
import com.winsonmac.tikihometest.databinding.KeywordListItemBinding
import com.winsonmac.tikihometest.env.extensions.shouldSplitTwoLine
import com.winsonmac.tikihometest.models.KeywordModel

class KeywordListAdapter(mContext: Context, mData: MutableList<KeywordModel>) :
    BaseAdapter<KeywordModel>(mContext, mData) {

    override fun onCreateViewHolder(container: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = inflater.inflate(R.layout.keyword_list_item, container, false)
        return KeywordItemViewHolder(KeywordListItemBinding.bind(view))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, pos: Int) {
        (holder as KeywordItemViewHolder).bindData(pos)
    }

    inner class KeywordItemViewHolder(private val mItemBinding: KeywordListItemBinding) :
        RecyclerView.ViewHolder(mItemBinding.root) {

        fun bindData(pos: Int) {
            val item = getData()[pos]
            mItemBinding.container.background.setColorFilter(item.color, PorterDuff.Mode.SRC_IN)
            mItemBinding.keyword = item.description.shouldSplitTwoLine()
        }

    }

}