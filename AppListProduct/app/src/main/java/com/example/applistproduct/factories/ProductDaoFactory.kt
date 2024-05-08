package com.example.applistproduct.factories

import com.example.applistproduct.MyApplication
import com.example.applistproduct.model.local.ProductDao
import com.example.applistproduct.persistence.AppDatabase

class ProductDaoFactory private constructor() {
    companion object {
        private var productDao: ProductDao? = null
        fun getProductDao(): ProductDao {
            if (productDao == null) {
                productDao = AppDatabase.getAppDatabase(MyApplication.getContext()).productDao()
            }
            return productDao as ProductDao
        }
    }
}