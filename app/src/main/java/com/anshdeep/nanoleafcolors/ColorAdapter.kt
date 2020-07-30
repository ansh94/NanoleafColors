package com.anshdeep.nanoleafcolors

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

/**
 * Created by ansh on 2020-07-29.
 */
class ColorAdapter(private var list: ArrayList<Color>) : RecyclerView.Adapter<ColorViewHolder>() {

    private var yellowColorPosition = -1


    fun setYellowColorPosition(position: Int) {
        yellowColorPosition = position
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_layout, parent, false);
        return ColorViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateData(updatedColorList: ArrayList<Color>) {
        list.clear()
        list = updatedColorList
        notifyDataSetChanged()
    }

    fun clearData() {
        list.clear()
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        val currentColor = list[position]

        holder.colorName.text = currentColor.colorName
        holder.colorNumber.text = currentColor.colorNumber

        setColor(holder, currentColor)

        if (position == yellowColorPosition) {
            holder.colorName.setTextColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.colorBlack
                )
            )
            holder.colorNumber.setTextColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.colorBlack
                )
            )
        } else {
            holder.colorName.setTextColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.colorWhite
                )
            )
            holder.colorNumber.setTextColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.colorWhite
                )
            )
        }


    }


    private fun setColor(holder: ColorViewHolder, currentColor: Color) {
        when (currentColor.colorName) {
            "Red" -> {
                holder.colorLayout.backgroundTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.colorRed
                    )
                )
            }
            "Yellow" -> {
                holder.colorLayout.backgroundTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.colorYellow
                    )
                )
            }
            "Orange" -> {
                holder.colorLayout.backgroundTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.colorOrange
                    )
                )
            }
            "Green" -> {
                holder.colorLayout.backgroundTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.colorGreen
                    )
                )
            }
            "Blue" -> {
                holder.colorLayout.backgroundTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.colorBlue
                    )
                )
            }
            "Purple" -> {
                holder.colorLayout.backgroundTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.colorPurple
                    )
                )
            }
        }
    }
}

class ColorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val colorName: TextView = itemView.colorName
    val colorNumber: TextView = itemView.colorNumber
    val colorLayout: ConstraintLayout = itemView.colorLayout
}