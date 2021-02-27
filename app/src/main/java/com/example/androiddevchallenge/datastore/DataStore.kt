package com.example.androiddevchallenge.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

private val STORE_NAME = "settings"
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = STORE_NAME)
