package m.vk.k003_listadapter.adapter

import android.support.v7.util.DiffUtil
import m.vk.k003_listadapter.model.PhotoPost
import m.vk.k003_listadapter.model.Post
import m.vk.k003_listadapter.model.StatusPost

class PostDiffCallback : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        if (oldItem is StatusPost && newItem is StatusPost) {
            return oldItem.text == newItem.text && oldItem.timestamp == newItem.timestamp
        } else if (oldItem is PhotoPost && newItem is PhotoPost) {
            return oldItem.url == newItem.url && oldItem.text == newItem.text && oldItem.timestamp == newItem.timestamp
        }
        return false
    }
}