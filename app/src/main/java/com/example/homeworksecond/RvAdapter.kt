package com.example.homeworksecond
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.TransformationUtils.circleCrop
import com.example.homeworksecond.databinding.ItemContactBinding


class RvAdapter(private val dataSet: List<Contactdata>): RecyclerView.Adapter<RvAdapter.ViewHolder>() {

    class ViewHolder(private val itemBinding: ItemContactBinding):
        RecyclerView.ViewHolder(itemBinding.root) {
            fun bind(contactData: Contactdata) {
                // дописать сюда экстенжен функцию
                Glide.with(itemBinding.root.context)
                    .load(contactData.contactPhoto)
                    .circleCrop()
                    .into(itemBinding.contactPhoto)
                itemBinding.contactName.text = contactData.contactName
                itemBinding.contactProfession.text = contactData.contactProfession
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemContactBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contactData: Contactdata = dataSet[position]
        holder.bind(contactData)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    fun updateData() {
        ContactsDataList.getContacts()
    }
}
