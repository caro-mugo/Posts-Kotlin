package com.example.mypost


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mypost.databinding.CommentsListItemsBinding

class CommentsRvAdapter(var commentList:List<Comment>):RecyclerView.Adapter<CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        var binding = CommentsListItemsBinding
            .inflate(LayoutInflater.from(parent.context), parent,false)
        return CommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var Comment = commentList.get(position)
        with(holder.binding){
            tvText1.text = Comment.postId.toString()
            tvText2.text = Comment.id.toString()
            tvText3.text = Comment.name.toString()
            tvText4.text = Comment.email.toString()
            tvText5.text = Comment.body.toString()
        }
    }

    override fun getItemCount(): Int {
        return commentList.size
    }
}

class CommentViewHolder(var binding: CommentsListItemsBinding):RecyclerView.ViewHolder(binding.root)

