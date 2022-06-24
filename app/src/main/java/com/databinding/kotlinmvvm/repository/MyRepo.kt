package com.databinding.kotlinmvvm.repository

import androidx.lifecycle.MutableLiveData
import com.databinding.kotlinmvvm.model.Contacts
import com.databinding.kotlinmvvm.model.Resource
import com.databinding.kotlinmvvm.network.ApiInterface
import com.databinding.kotlinmvvm.network.MyClient
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyRepo {

    var client: ApiInterface

    init {
        client = MyClient.MyClientSingleton.getClient()
    }

    fun getContacts(): MutableLiveData<Resource<ArrayList<Contacts>>> {

        var mcontact = MutableLiveData<Resource<ArrayList<Contacts>>>()
        mcontact.postValue(Resource.loading(null))

        client.getContact().enqueue(object : Callback<JsonElement> {
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {

                if (response.isSuccessful) {
                    var jsonObject = JSONObject(response.body().toString())
                    mcontact.postValue(
                        Resource.success(
                            Gson().fromJson(
                                jsonObject.getJSONArray("contacts").toString(),
                                object : TypeToken<List<Contacts>>() {}.type
                            )
                        )
                    )
                } else {
                    mcontact.postValue(Resource.error(null, "asdsa"))
                }
            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                mcontact.postValue(Resource.error(null, "asdsa"))
            }

        })
        return mcontact
    }
}