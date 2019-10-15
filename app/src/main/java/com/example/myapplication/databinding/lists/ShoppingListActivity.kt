package com.example.myapplication.databinding.lists

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityShoppingListBinding
import kotlinx.android.synthetic.main.activity_shopping_list.*

class ShoppingListActivity : AppCompatActivity() {

    companion object {
        fun start(activity: AppCompatActivity) {
            activity.startActivity(Intent(activity, ShoppingListActivity::class.java))
        }
    }

    private lateinit var viewModel: ShoppingListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ShoppingListViewModel::class.java)
        val binding = DataBindingUtil.setContentView<ActivityShoppingListBinding>(
            this,
            R.layout.activity_shopping_list
        )
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        setupRecyclerView()
        viewModel.loadData()
    }

    private fun setupRecyclerView() {
        recyclerViewAtShoppingListActivity.apply {
            val lm = LinearLayoutManager(this@ShoppingListActivity)
            layoutManager = lm
            setHasFixedSize(false)
            adapter = ShoppingListAdapter().apply {
                //                registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
//                    override fun onItemRangeMoved(
//                        fromPosition: Int,
//                        toPosition: Int,
//                        itemCount: Int
//                    ) {
//                        super.onItemRangeMoved(fromPosition, toPosition, itemCount)
//                        if (fromPosition == 0) lm.scrollToPosition(0)
//                    }
//                })
            }
        }
        viewModel.itemsLiveData.observe(this, Observer { items ->
            (recyclerViewAtShoppingListActivity.adapter as? ShoppingListAdapter?)?.apply {
                //                submitList(null)
                submitList(items)
            }
        })

        viewModel.eventsMediatorLiveData.observe(this, Observer { event ->
            when (val payload = event.getContentIfNotHandled()) {
                is ShoppingListItemCheckedChangedPayload -> {
                    recyclerViewAtShoppingListActivity.postDelayed(
                        { viewModel.onCheckedChanged() },
                        500
                    )
                }
            }
        })
    }

}