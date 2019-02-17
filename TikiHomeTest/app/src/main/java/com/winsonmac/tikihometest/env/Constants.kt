package com.winsonmac.tikihometest.env

import com.winsonmac.tikihometest.R

/* =========================================================================================== */
/*  Contains all const variable to use during app working                                      */
/* =========================================================================================== */

object Constants {

    /* =========================================================================================== */
    /*  A list of HTTP status code                                                                 */
    /* =========================================================================================== */

    const val SERVER_BAD_REQUEST_CODE = 400
    const val SERVER_PAGE_NOT_FOUND_CODE = 404
    const val SERVER_SUCCESS_CODE = 200
    const val SERVER_ERROR_CODE = 500

    
    /* =========================================================================================== */
    /*  The string id for message popup                                                            */
    /* =========================================================================================== */

    const val MESSAGE_ERROR_TITLE = R.string.message_popup_error_title
    const val MESSAGE_INFORM_TITLE = R.string.message_popup_inform_title
    const val MESSAGE_CONFIRM_TITLE = R.string.message_popup_confirm_title
    const val MESSAGE_FAIL_TITLE = R.string.message_popup_fail_title
    const val MESSAGE_SUCCESS_TITLE = R.string.message_popup_success_title

}