package com.geektech.taskappkt.domain

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun editShopItem(shopItem: ShopItem, index: Int){
        shopListRepository.editShopItem(shopItem,index)
    }
}