package com.winsonmac.tikihometest.apis

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET

interface ListAPIKeyword {

    @GET(APIConfig.API_LIST_KEYWORDS)
    fun getKeywordList(): Call<JsonElement>

}