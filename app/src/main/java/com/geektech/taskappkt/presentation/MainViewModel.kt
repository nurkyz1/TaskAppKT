package com.geektech.taskappkt.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geektech.taskappkt.data.ShopListRepositoryImpl
import com.geektech.taskappkt.domain.*

class MainViewModel: ViewModel() {
    private val repository = ShopListRepositoryImpl

    private val  addShopItemUseCase = AddShopItemUseCase(repository)
    private val getShopItemListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val getShopItemUseCase = GetShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList= MutableLiveData<List<ShopItem>>()

    fun addShopItem(shopItem: ShopItem){
        addShopItemUseCase.addShopItem(shopItem)
    }
    fun getShopItemList(){
        val list = getShopItemListUseCase.getShopList()
        shopList.value= list
    }
    fun deleteShopItem(shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }
    fun getShopItem(shopItem: ShopItem){
        getShopItemUseCase.getShopItem(shopItem)
    }
    fun editShopItem(shopItem: ShopItem, index: Int){
        editShopItemUseCase.editShopItem(shopItem,index)
    }

}