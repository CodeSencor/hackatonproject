package com.example.pabulu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ListAdapter(var mContext: Context, var names: Array<String>, var flags: IntArray) :
    ArrayAdapter<String?>(mContext, R.layout.listview_item) {
    override fun getCount(): Int {
        return names.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        var mViewHolder = ViewHolder()
        if (convertView == null) {
            val mInflater =
                mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = mInflater.inflate(R.layout.listview_item, parent, false)
            mViewHolder.mFlag = convertView!!.findViewById<View>(R.id.imageView) as ImageView?
            mViewHolder.mName = convertView.findViewById<View>(R.id.textView) as TextView?
            convertView.setTag(mViewHolder)
        } else {
            mViewHolder = convertView.tag as ViewHolder
        }
        mViewHolder.mFlag!!.setImageResource(flags[position])
        mViewHolder.mName!!.text = names[position]
        return convertView!!
    }

    internal class ViewHolder {
        var mFlag: ImageView? = null
        var mName: TextView? = null
    }
}