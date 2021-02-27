package com.example.androiddevchallenge

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.androiddevchallenge.datastore.DataStoreImpl
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AdogtApplication: Application() {

}