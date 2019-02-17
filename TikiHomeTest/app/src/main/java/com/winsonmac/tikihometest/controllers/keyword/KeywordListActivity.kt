package com.winsonmac.tikihometest.controllers.keyword

import com.winsonmac.core.base.BaseActivity
import com.winsonmac.tikihometest.R
import com.winsonmac.tikihometest.databinding.KeywordListActivityBinding


class KeywordListActivity : BaseActivity() {

    private val mBinding by lazy {
        bindingContentLayout<KeywordListActivityBinding>(R.layout.keyword_list_activity)
    }

    private val mKeywordListViewModel by lazy {
        KeywordListViewModel(this)
    }

    /* =========================================================================================== */
    /*  Implement super methods                                                                    */
    /* =========================================================================================== */

    override fun setupViews() {

        // Init toolbar
        ui().showToolbarWithTitle(R.string.keyword_list_title)

        // Layout binding
        mBinding.viewModel = mKeywordListViewModel

        // Call api get list keywords
        ui().showLoading()
        mKeywordListViewModel.getKeywordList { success, message, messageTitle ->
            ui().dismissLoading()
            if (!success) {
                ui().showPopup(messageTitle!!, message!!, R.string.message_popup_ok_title)
            }
        }
    }
}