package m.vk.k003_listadapter.adapter

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import m.vk.k003_listadapter.R
import m.vk.k003_listadapter.constant.PostType
import m.vk.k003_listadapter.model.PhotoPost
import m.vk.k003_listadapter.model.Post
import m.vk.k003_listadapter.model.StatusPost
import m.vk.k003_listadapter.viewholder.PhotoViewHolder
import m.vk.k003_listadapter.viewholder.StatusViewHolder

class ContentAdapter : ListAdapter<Post, RecyclerView.ViewHolder>(PostDiffCallback()) {
    override fun getItemViewType(position: Int): Int {
        return getItem(position).type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        PostType.STATUS -> StatusViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_status_post, parent, false)) as RecyclerView.ViewHolder
        PostType.PHOTO -> PhotoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_photo_post, parent, false)) as RecyclerView.ViewHolder
        else -> throw NullPointerException("View holder for type $viewType not found")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is StatusViewHolder) {
            val statusPost = getItem(position) as StatusPost
            holder.bind(statusPost)
        } else if (holder is PhotoViewHolder) {
            val photoPost = getItem(position) as PhotoPost
            holder.bind(photoPost)
        }
    }
}