package com.example.mypost

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mypost.databinding.ActivityMainBinding
import com.example.mypost.databinding.RetrofitListItemBinding
import com.example.mypost.databinding.RetrofitListItemBinding.bind
import com.example.mypost.databinding.RetrofitListItemBinding.inflate


class PostRvAdapter (var context:Context, var postList: List<Post>)
    :RecyclerView.Adapter<RetrofitViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var bindingView = RetrofitListItemBinding
            .inflate(LayoutInflater.from(context),parent,false)
        return  RetrofitViewHolder(bindingView)
    }

    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var currentItem = postList.get(position)

        with(holder.bindingView){
            tvUserid.text = currentItem.userId.toString()
            tvId.text = currentItem.id.toString()
            tvTitle.text = currentItem.title
           tvBody.text= currentItem.body
        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}

class RetrofitViewHolder(var bindingView: RetrofitListItemBinding):
    RecyclerView.ViewHolder(bindingView.root)



