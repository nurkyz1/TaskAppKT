package com.geektech.taskappkt.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.taskappkt.R
import com.geektech.taskappkt.databinding.ActivityMainBinding
import com.geektech.taskappkt.domain.ShopItem

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding: ActivityMainBinding by viewBinding()
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.shopList.observe(this,{list->
            list.forEach { shopItem ->
                Log.e("TAG","list: ${shopItem}")
                Toast.makeText(applicationContext,shopItem.toString(),Toast.LENGTH_SHORT).show()
            }
        })
        initListeners()
    }

    private fun initListeners() {
        binding.startBtn.setOnClickListener {
            addShopItemfun()
        }
        binding.deleteBtn.setOnClickListener {
            deleteShopItemFun()
        }
        binding.editBtn.setOnClickListener {
            editShopItem(0)
        }
        binding.getItemBtn.setOnClickListener {
            getShopItem()
        }
        binding.getListBtn.setOnClickListener {
            getShopList()
        }
    }
    private fun addShopItemfun() {
        viewModel.addShopItem(ShopItem("Potato",2,false,1))
        viewModel.getShopItemList()
    }
    private fun deleteShopItemFun(){
    viewModel.deleteShopItem(ShopItem("Potato",2,false,1))
        viewModel.getShopItemList()
    }
    private fun getShopItem(){
        viewModel.getShopItem(ShopItem("Potato", 2,false,1))
        viewModel.getShopItemList()
    }
    private fun getShopList(){
        viewModel.getShopItemList()
    }
    private fun editShopItem(index: Int){
        viewModel.editShopItem(ShopItem("potato",2,false,1),index)
        viewModel.getShopItemList()
    }
}