package com.example.androiddevchallenge.datastore

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.example.androiddevchallenge.AdogtApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DataStoreImpl
@Inject
constructor(
    private val app: AdogtApplication
) {


    private val scope = CoroutineScope(Dispatchers.Main)

    init {
        observeDataStore()
    }

    private val _isDark = mutableStateOf(false)
    val isDark: State<Boolean>
        get() = _isDark

    fun toggleTheme() {
        scope.launch {
            app.dataStore.edit { pref ->
                val current = pref[DARK_THEME_KEY] ?: false
                pref[DARK_THEME_KEY] = !current
            }
        }
    }

    private fun observeDataStore() {
        app.dataStore.data.onEach { pref ->
            pref[DARK_THEME_KEY]?.let { isDarkTheme ->
                _isDark.value = isDarkTheme
            }
        }.launchIn(scope)
    }

    companion object {
        private val DARK_THEME_KEY = booleanPreferencesKey("dark_theme_key")
    }
}