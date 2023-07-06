package com.devjj.platform.nurbanhoney.core.platform

import android.content.Context
import android.util.Log
import androidx.datastore.core.Serializer
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.devjj.platform.nurbanhoney.NurbanTokenProto
import com.devjj.platform.nurbanhoney.core.extension.tokenDataStore
import com.devjj.platform.nurbanhoney.domain.login.model.NurbanToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.io.InputStream
import java.io.OutputStream

val NURBAN_TOKEN_KEY = stringPreferencesKey("nurban.token.key")

suspend fun setNurbanToken(context: Context, token: String) {
	context.tokenDataStore.edit {
		Log.d("setNurbanToken", "token : $token")
		it[NURBAN_TOKEN_KEY] = token
	}
}

fun getNurbanToken(context: Context): Flow<String?> {
	return context.tokenDataStore.data.map { preferences ->
		val key = preferences[NURBAN_TOKEN_KEY]
		Log.d("getNurbanToken", "key : $key")
		key
	}
}

interface DataStoreRepository {
	fun getNurbanToken(): NurbanToken
	suspend fun setNurbanToken(nurbanToken: NurbanToken)
}

class DataStoreRepositoryImpl(val context: Context) : DataStoreRepository{
	override fun getNurbanToken(): NurbanToken {
		TODO("Not yet implemented")
	}

	override suspend fun setNurbanToken(nurbanToken: NurbanToken) {
		context.tokenDataStore.edit {
			it[NURBAN_TOKEN_KEY]
		}
	}
}

object NurbanTokenSerializer : Serializer<NurbanTokenProto> {
	override val defaultValue: NurbanTokenProto = NurbanTokenProto.getDefaultInstance()

	override suspend fun readFrom(input: InputStream): NurbanTokenProto {
		TODO("Not yet implemented")
	}

	override suspend fun writeTo(t: NurbanTokenProto, output: OutputStream) {
		TODO("Not yet implemented")
	}
}