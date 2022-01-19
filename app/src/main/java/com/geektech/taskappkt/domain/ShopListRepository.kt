package com.geektech.taskappkt.domain

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)
    fun deleteShopItem(shopItem: ShopItem)
    fun getShopList(): List<ShopItem>
    fun editShopItem(shopItem: ShopItem,index: Int)
    fun getShopItem(): ShopItem
}