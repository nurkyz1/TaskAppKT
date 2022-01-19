package com.geektech.taskappkt.data

import com.geektech.taskappkt.domain.ShopItem
import com.geektech.taskappkt.domain.ShopListRepository

object ShopListRepositoryImpl: ShopListRepository {
    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId=0

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id==ShopItem.UNDEFINED_ID){
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }

    override fun editShopItem(shopItem: ShopItem,index: Int) {
        if (shopList.isNotEmpty()){
            shopList[index] = shopItem
        }
    }

    override fun getShopItem(): ShopItem {
        return shopList[0]
    }
}