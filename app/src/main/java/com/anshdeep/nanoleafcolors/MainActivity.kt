package com.anshdeep.nanoleafcolors

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var colorAdapter = ColorAdapter(arrayListOf())
    private val colorsMap: MutableMap<String, Int> = mutableMapOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewColors.adapter = colorAdapter
        recyclerViewColors.layoutManager = LinearLayoutManager(this)

        setClickListeners()
    }

    private fun setClickListeners() {
        btnRed.setOnClickListener {
            colorsText.append(resources.getString(R.string.red) + ", ")
        }
        btnYellow.setOnClickListener {
            colorsText.append(resources.getString(R.string.yellow) + ", ")
        }
        btnOrange.setOnClickListener {
            colorsText.append(resources.getString(R.string.orange) + ", ")
        }
        btnGreen.setOnClickListener {
            colorsText.append(resources.getString(R.string.green) + ", ")
        }
        btnBlue.setOnClickListener {
            colorsText.append(resources.getString(R.string.blue) + ", ")
        }
        btnPurple.setOnClickListener {
            colorsText.append(resources.getString(R.string.purple) + ", ")
        }
        btnClear.setOnClickListener {
            colorsText.text = "".trim()
            colorAdapter.clearData()
            colorsMap.clear()
            recyclerViewColors.visibility = View.GONE
        }
        btnCalculate.setOnClickListener {
            if (colorsText.text.isEmpty()) {
                Toast.makeText(
                    this,
                    "Select at least one color to calculate!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                calculate()
            }
        }
    }

    private fun calculate() {
        colorsMap.clear()
        var splitList = colorsText.text.split(",")
        splitList = splitList.subList(0, splitList.size - 1)


        // storing colors and their count in a mutable map
        for (e in splitList) {
            val key = e.trim()

            if (colorsMap.containsKey(key)) {
                var count = colorsMap[key]
                count = count?.plus(1)
                colorsMap[key] = count!!
            } else {
                colorsMap[key] = 1
            }
        }

        val colorList = ArrayList<Color>()

        for ((i, color) in colorsMap.keys.withIndex()) {
            if (color == "Yellow") {
                colorAdapter.setYellowColorPosition(i)
            }
            colorList.add(Color(color, colorsMap[color].toString()))
        }

        colorAdapter.updateData(colorList)
        recyclerViewColors.visibility = View.VISIBLE
    }
}