package com.example.numberpuzzle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.numberpuzzle.databinding.ActivityStatisticBinding
import com.example.numberpuzzle.game.bindingStatistic
import com.example.numberpuzzle.game.setStatisticData

class StatisticActivity : AppCompatActivity() {

//    private lateinit var binding: ActivityStatisticBinding
    private var arrayList = mutableMapOf<Int, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingStatistic = ActivityStatisticBinding.inflate(layoutInflater)
        setContentView(bindingStatistic.root)

        bindingStatistic.apply {
            arrayList[statistic0.text.toString().toInt()] = name0.text.toString()
            arrayList[statistic1.text.toString().toInt()] = name1.text.toString()
            arrayList[statistic2.text.toString().toInt()] = name2.text.toString()
            arrayList[statistic3.text.toString().toInt()] = name3.text.toString()
            arrayList[statistic4.text.toString().toInt()] = name4.text.toString()
            arrayList[statistic5.text.toString().toInt()] = name5.text.toString()
            arrayList[statistic6.text.toString().toInt()] = name6.text.toString()
            arrayList[statistic7.text.toString().toInt()] = name7.text.toString()
            arrayList[statistic8.text.toString().toInt()] = name8.text.toString()
            arrayList[statistic9.text.toString().toInt()] = name9.text.toString()
        }

//        getData()

        arrayList = setStatisticData(arrayList)

        getData()

    }

    private fun getData() {

        bindingStatistic.apply {

//            var array = arrayList.toSortedMap()

            Log.i("tag", "arrayList = $arrayList")
//            Log.i("tag", "arraySort = $array")

            val statistics = arrayList.keys.toIntArray()
            val names = arrayList.values

            statistic0.text = statistics[0].toString()
            statistic1.text = statistics[1].toString()
            statistic2.text = statistics[2].toString()
            statistic3.text = statistics[3].toString()
            statistic4.text = statistics[4].toString()
            statistic5.text = statistics[5].toString()
            statistic6.text = statistics[6].toString()
            statistic7.text = statistics[7].toString()
            statistic8.text = statistics[8].toString()
            statistic9.text = statistics[9].toString()


            name0.text = arrayList[statistic0.text.toString().toInt()]
            name1.text = arrayList[statistic1.text.toString().toInt()]
            name2.text = arrayList[statistic2.text.toString().toInt()]
            name3.text = arrayList[statistic3.text.toString().toInt()]
            name4.text = arrayList[statistic4.text.toString().toInt()]
            name5.text = arrayList[statistic5.text.toString().toInt()]
            name6.text = arrayList[statistic6.text.toString().toInt()]
            name7.text = arrayList[statistic7.text.toString().toInt()]
            name8.text = arrayList[statistic8.text.toString().toInt()]
            name9.text = arrayList[statistic9.text.toString().toInt()]

        }
    }
}