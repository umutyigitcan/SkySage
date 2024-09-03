package com.example.skysage

import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.skysage.databinding.FragmentHomepageBinding
import com.example.skysage.network.ApiResponse
import com.example.skysage.network.ApiService
import com.example.skysage.network.RetrofitClient
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Homepage : Fragment() {

    private lateinit var binding:FragmentHomepageBinding



    private lateinit var adapter:RVAdapter
    private lateinit var dataList:ArrayList<CityData>
    private val apiKey = "71958f6e76a80b2c1f8e3a3594198bc6"
    private var cityName = "Ankara"
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= FragmentHomepageBinding.inflate(inflater,container,false)



        dataList= ArrayList()
        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager=StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)
        binding.cityName.text=cityName

        val apiService=RetrofitClient.instance.create(ApiService::class.java)

        apiService.getData(cityName, apiKey).enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val weatherResponse = response.body()
                    val tempString = weatherResponse?.main?.temp?.toString() ?: "0.0"
                    val tempDouble = tempString.toDouble()
                    val roundedTemp = if (tempDouble % 1 == 0.0) {
                        tempDouble.toInt()
                    } else {
                        (tempDouble + 1).toInt()
                    }
                    binding.temp.text = "$roundedTemp°C"
                    binding.desc.text="${weatherResponse!!.weather[0].description}"
                    binding.weatherImage.visibility=View.VISIBLE

                    if(binding.desc.text=="clear sky"){
                        binding.weatherImage.setBackgroundResource(R.drawable.sunny)
                    }
                    if(binding.desc.text=="few clouds"){
                        binding.weatherImage.setBackgroundResource(R.drawable.fewclouds)
                    }
                    if(binding.desc.text=="scattered clouds"){
                        binding.weatherImage.setBackgroundResource(R.drawable.scatteredclouds)
                    }
                    if(binding.desc.text=="broken clouds"){
                        binding.weatherImage.setBackgroundResource(R.drawable.brokenclouds)
                    }
                    if(binding.desc.text=="shower rain"){
                        binding.weatherImage.setBackgroundResource(R.drawable.showerrain)
                    }
                    if(binding.desc.text=="rain"){
                        binding.weatherImage.setBackgroundResource(R.drawable.rainyday)
                    }
                    if(binding.desc.text=="thunderstorm"){
                        binding.weatherImage.setBackgroundResource(R.drawable.scatteredthunderstorms)
                    }
                    if(binding.desc.text=="snow"){
                        binding.weatherImage.setBackgroundResource(R.drawable.snow)
                    }
                    if(binding.desc.text=="mist"){
                        binding.weatherImage.setBackgroundResource(R.drawable.mist)
                    }


                    imageMove()
                    Log.e("temp", tempString)
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
            }
        })


        dataList.add(CityData("İstanbul"))
        dataList.add(CityData("Ankara"))
        dataList.add(CityData("Zonguldak"))
        dataList.add(CityData("Adana"))
        dataList.add(CityData("Adıyaman"))
        dataList.add(CityData("Afyonkarahisar"))
        dataList.add(CityData("Ağrı"))
        dataList.add(CityData("Aksaray"))
        dataList.add(CityData("Amasya"))
        dataList.add(CityData("Antalya"))
        dataList.add(CityData("Ardahan"))
        dataList.add(CityData("Artvin"))
        dataList.add(CityData("Aydın"))
        dataList.add(CityData("Balıkesir"))
        dataList.add(CityData("Bartın"))
        dataList.add(CityData("Batman"))
        dataList.add(CityData("Bayburt"))
        dataList.add(CityData("Bilecik"))
        dataList.add(CityData("Bingöl"))
        dataList.add(CityData("Bitlis"))
        dataList.add(CityData("Bolu"))
        dataList.add(CityData("Burdur"))
        dataList.add(CityData("Bursa"))
        dataList.add(CityData("Çanakkale"))
        dataList.add(CityData("Çankırı"))
        dataList.add(CityData("Çorum"))
        dataList.add(CityData("Denizli"))
        dataList.add(CityData("Diyarbakır"))
        dataList.add(CityData("Düzce"))
        dataList.add(CityData("Edirne"))
        dataList.add(CityData("Elazığ"))
        dataList.add(CityData("Erzincan"))
        dataList.add(CityData("Erzurum"))
        dataList.add(CityData("Eskişehir"))
        dataList.add(CityData("Gaziantep"))
        dataList.add(CityData("Giresun"))
        dataList.add(CityData("Gümüşhane"))
        dataList.add(CityData("Hakkari"))
        dataList.add(CityData("Hatay"))
        dataList.add(CityData("Iğdır"))
        dataList.add(CityData("Isparta"))
        dataList.add(CityData("İzmir"))
        dataList.add(CityData("Kahramanmaraş"))
        dataList.add(CityData("Karabük"))
        dataList.add(CityData("Karaman"))
        dataList.add(CityData("Kars"))
        dataList.add(CityData("Kastamonu"))
        dataList.add(CityData("Kayseri"))
        dataList.add(CityData("Kırıkkale"))
        dataList.add(CityData("Kırıklareli"))
        dataList.add(CityData("Kırşehir"))
        dataList.add(CityData("Kilis"))
        dataList.add(CityData("Konya"))
        dataList.add(CityData("Kütahya"))
        dataList.add(CityData("Malatya"))
        dataList.add(CityData("Manisa"))
        dataList.add(CityData("Mardin"))
        dataList.add(CityData("Mersin"))
        dataList.add(CityData("Muğla"))
        dataList.add(CityData("Muş"))
        dataList.add(CityData("Nevşehir"))
        dataList.add(CityData("Niğde"))
        dataList.add(CityData("Ordu"))
        dataList.add(CityData("Osmaniye"))
        dataList.add(CityData("Rize"))
        dataList.add(CityData("Sakarya"))
        dataList.add(CityData("Samsun"))
        dataList.add(CityData("Şanlıurfa"))
        dataList.add(CityData("Şırnak"))
        dataList.add(CityData("Tekirdağ"))
        dataList.add(CityData("Tokat"))
        dataList.add(CityData("Trabzon"))
        dataList.add(CityData("Tunceli"))
        dataList.add(CityData("Uşak"))
        dataList.add(CityData("Van"))
        dataList.add(CityData("Yalova"))
        dataList.add(CityData("Yozgat"))




























        adapter= RVAdapter(requireContext(),dataList)
        binding.rv.adapter=adapter


        binding.changeButton.setOnClickListener {
            var vt=SelectedCity(requireContext())
            var list=SelectedCityDao().getData(vt)
            for(k in list){
                binding.cityName.text=k.cityName
                cityName=k.cityName
            }
            apiService.getData(cityName, apiKey).enqueue(object : Callback<ApiResponse> {
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    if (response.isSuccessful) {
                        val weatherResponse = response.body()
                        val tempString = weatherResponse?.main?.temp?.toString() ?: "0.0"
                        val tempDouble = tempString.toDouble()
                        val roundedTemp = if (tempDouble % 1 == 0.0) {
                            tempDouble.toInt()
                        } else {
                            (tempDouble + 1).toInt()
                        }
                        binding.temp.text = "$roundedTemp°C"
                        binding.desc.text="${weatherResponse!!.weather[0].description}"

                        if(binding.desc.text=="clear sky"){
                            binding.weatherImage.setBackgroundResource(R.drawable.sunny)
                        }
                        if(binding.desc.text=="few clouds"){
                            binding.weatherImage.setBackgroundResource(R.drawable.fewclouds)
                        }
                        if(binding.desc.text=="scattered clouds"){
                            binding.weatherImage.setBackgroundResource(R.drawable.scatteredclouds)
                        }
                        if(binding.desc.text=="broken clouds"){
                            binding.weatherImage.setBackgroundResource(R.drawable.brokenclouds)
                        }
                        if(binding.desc.text=="shower rain"){
                            binding.weatherImage.setBackgroundResource(R.drawable.showerrain)
                        }
                        if(binding.desc.text=="rain"){
                            binding.weatherImage.setBackgroundResource(R.drawable.rainyday)
                        }
                        if(binding.desc.text=="thunderstorm"){
                            binding.weatherImage.setBackgroundResource(R.drawable.scatteredthunderstorms)
                        }
                        if(binding.desc.text=="snow"){
                            binding.weatherImage.setBackgroundResource(R.drawable.snow)
                        }
                        if(binding.desc.text=="mist"){
                            binding.weatherImage.setBackgroundResource(R.drawable.mist)
                        }


                        Log.e("temp", tempString)
                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                }
            })
            imageMove()
        }


        apiService.getData(cityName,apiKey).enqueue(object :Callback<ApiResponse>{
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if(response.isSuccessful){
                    val weatherResponse=response.body()
                    //binding.title.text="${weatherResponse?.weather?.get(0)?.description}"
                    Log.e("Temp",binding.title.text.toString())
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {

            }
        })


        return binding.root
    }

    fun imageMove(){
        var e= ObjectAnimator.ofFloat(binding.weatherImage,"translationX",800.0f,0.0f).apply {
            duration=3000
        }
        e.start()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Snackbar'ı burada çağırabilirsiniz
        Snackbar.make(view, "Umut Yiğit tarafından geliştirilmiştir.", Snackbar.LENGTH_SHORT).show()
    }
}