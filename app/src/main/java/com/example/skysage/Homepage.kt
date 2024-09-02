package com.example.skysage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.skysage.databinding.FragmentHomepageBinding

class Homepage : Fragment() {

    private lateinit var binding:FragmentHomepageBinding



    private lateinit var adapter:RVAdapter
    private lateinit var dataList:ArrayList<CityData>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= FragmentHomepageBinding.inflate(inflater,container,false)
        dataList= ArrayList()
        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager=StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)

        var u1=CityData("Ankara")
        var u2=CityData("Istanbul")
        var u3=CityData("Denizli")
        var u4=CityData("Adıyaman")
        var u5=CityData("Bayburt")
        var u6=CityData("Rize")
        var u7=CityData("Trabzon")
        var u8=CityData("Zonguldak")
        var u9=CityData("Balıkesir")
        var u10=CityData("Tokat")
        var u11=CityData("Düzce")
        var u12=CityData("Kocaeli")
        dataList.add(u1)
        dataList.add(u2)
        dataList.add(u3)
        dataList.add(u4)
        dataList.add(u5)
        dataList.add(u6)
        dataList.add(u7)
        dataList.add(u8)
        dataList.add(u9)
        dataList.add(u10)
        dataList.add(u11)
        dataList.add(u12)






        adapter= RVAdapter(requireContext(),dataList)
        binding.rv.adapter=adapter

        return binding.root
    }
}