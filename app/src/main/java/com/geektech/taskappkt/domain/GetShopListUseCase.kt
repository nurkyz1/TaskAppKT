package com.geektech.taskappkt.domain

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopList()= shopListRepository.getShopList()
}