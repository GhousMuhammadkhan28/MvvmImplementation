package com.databinding.kotlinmvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.databinding.kotlinmvvm.R
import com.databinding.kotlinmvvm.databinding.RowContactBinding
import com.databinding.kotlinmvvm.model.Contacts

class ContactListAdapter(var context: Context, var list: List<Contacts>) :
    RecyclerView.Adapter<ContactListAdapter.ContactListRow>() {

    class ContactListRow(view: View) : RecyclerView.ViewHolder(view) {
        var rowContactBinding: RowContactBinding? = DataBindingUtil.bind(view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactListRow {
        var row = LayoutInflater.from(context).inflate(R.layout.row_contact, null)
        return ContactListRow(row)
    }

    override fun onBindViewHolder(holder: ContactListRow, position: Int) {
        holder.rowContactBinding?.data = list.get(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}