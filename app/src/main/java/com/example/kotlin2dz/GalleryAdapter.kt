package com.example.kotlin2dz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class GalleryAdapter(
    private val list: MutableList<GalleryModel>,
    private val onItemClickListener: GalleryFragment
) : RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>(), View.OnClickListener {

    inner class GalleryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var ivPhoto: ImageView? = null

        init {
            ivPhoto = view.findViewById(R.id.im_photo)
        }

        fun onBind(photo: GalleryModel) {
            ivPhoto?.let {
                Glide.with(it.context).load(photo.photoUrl).into(it)
            }
            itemView.tag = photo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        )
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.itemView.setOnClickListener(this)
        holder.onBind(list[position])
        holder.itemView.setOnLongClickListener {
            list.removeAt(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
            true
        }
    }

    override fun getItemCount(): Int {
        return list.size;
    }

    override fun onClick(view: View?) {
        onItemClickListener.onClick(view?.tag as GalleryModel)
    }
}
