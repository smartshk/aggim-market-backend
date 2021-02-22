package com.example.aggim.donation

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DonatesListViewModel(
        val dataSource: DonateListItemDataSource
) : ViewModel() {
    val donatesLiveData = dataSource.getDonateList()
    val donationsLiveData = dataSource.getDonationList()
}

class DonatesListViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DonatesListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DonatesListViewModel(
                    dataSource = DonateListItemDataSource.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}