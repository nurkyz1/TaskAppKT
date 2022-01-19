package com.geektech.taskappkt.domain

class GetShopItemUseCase (private val shopListRepository: ShopListRepository){
    fun getShopItem(shopItem: ShopItem){
        shopListRepository.getShopItem()
    }
}