package com.devjj.platform.nurbanhoney.core.platform

import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.devjj.platform.nurbanhoney.core.extension.tokenDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

val NURBAN_TOKEN_KEY = stringPreferencesKey("nurban.token.key")

suspend fun setNurbanToken(context: Context, token: String) {
	context.tokenDataStore.edit {
		Log.d("setNurbanToken", "token : $token")
		it[NURBAN_TOKEN_KEY] = token
	}
}

fun getNurbanToken(context: Context): Flow<String?> {
	return context.tokenDataStore.data.map { preferences ->
		val key =preferences[NURBAN_TOKEN_KEY]
		Log.d("getNurbanToken", "key : $key")
		key
	}
}
