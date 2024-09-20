package com.example.circeprogressdemo

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate


class MainActivity : AppCompatActivity() {

    lateinit var pieChart: PieChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pieChart = findViewById(R.id.pieChart)

        showPieChart()
    }

    private fun showPieChart() {
        val pieEntries = ArrayList<PieEntry>()
        val label = "type"

        //initializing data
        val typeAmountMap: MutableMap<String, Int> = HashMap()
        typeAmountMap["Meds"] = 200
        typeAmountMap["Food"] = 180
        typeAmountMap["Phone"] = 50

        //initializing colors for the entries
        val colors = ColorTemplate.MATERIAL_COLORS

        //input data and fit data into pie chart entry
        for (type in typeAmountMap.keys) {
            pieEntries.add(PieEntry(typeAmountMap[type]!!.toFloat(), type))
        }

        //collecting the entries with label name
        val pieDataSet = PieDataSet(pieEntries, label)
        //setting text size of the value
        pieDataSet.valueTextSize = 12f
        //providing color list for coloring different entries
        pieDataSet.setColors(*colors)
        //grouping the data set from entry to chart
        val pieData = PieData(pieDataSet)
        //showing the value of the entries, default true if not set
        pieData.setDrawValues(true)

        pieChart.data = pieData

       // pieChart.getAngleForPoint(60f, 270f) //
        pieChart.maxAngle = 180f //
        pieChart.setRotationAngle(180f)
        pieChart.setCenterTextOffset(0F, -20f)
        pieChart.invalidate()

    //that it
    }

}