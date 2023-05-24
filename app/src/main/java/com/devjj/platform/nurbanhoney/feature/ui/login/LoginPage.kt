package com.devjj.platform.nurbanhoney.feature.ui.login

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import androidx.navigation.NavController
import com.devjj.platform.nurbanhoney.R
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient

@Composable
fun LoginPage(
	state: LoginState,
	navController: NavController,
	onKakaoLoginResult: (Result<OAuthToken>) -> Unit
) {
	Column(
		modifier = Modifier.fillMaxSize(),
		horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
	) {
		Box(
			Modifier
				.wrapContentSize()
				.padding(50.dp)
		) {
			KakaoLogin(onKakaoLoginResult = onKakaoLoginResult)
		}

		Box(
			Modifier
				.wrapContentSize()
				.padding(50.dp)
		) {
			Button(onClick = { /*TODO*/ }, modifier = Modifier.size(200.dp, 50.dp)) {
				Image(
					painter = painterResource(id = R.drawable.ic_naver_login),
					contentDescription = null,
					modifier = Modifier.fillMaxSize()
				)
			}
		}

		Box(
			Modifier
				.wrapContentSize()
				.padding(50.dp)
		) {
			Button(onClick = { /*TODO*/ }, modifier = Modifier.size(200.dp, 50.dp)) {
				Image(
					painter = painterResource(id = R.drawable.ic_google_login),
					contentDescription = null,
					modifier = Modifier.fillMaxSize()
				)
			}
		}
	}
}

@Composable
fun KakaoLogin(onKakaoLoginResult: (Result<OAuthToken>) -> Unit) {
	val context = LocalContext.current
	Button(onClick = {
		Log.d("KakaoLogin", "KakaoLogin")
		LoginTypes.KakaoLogin.login(context, onKakaoLoginResult)
	}, modifier = Modifier.size(200.dp, 50.dp)) {
		Image(
			painter = painterResource(id = LoginTypes.KakaoLogin.layout),
			contentDescription = null,
			modifier = Modifier.fillMaxSize()
		)
	}
}

sealed class LoginTypes(val layout: Int) {
	object KakaoLogin : LoginTypes(R.drawable.ic_kakao_login) {
		fun login(context: Context, onKakaoResult: (Result<OAuthToken>) -> Unit) {
			if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
				UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
					error?.let {
						Log.d("KakaoLogin", "KakaoLogin error = $error")
						onKakaoResult(Result.failure(it))
					}
					token?.let {
						Log.d("KakaoLogin", "KakaoLogin success")
						onKakaoResult(Result.success(it))
					}
				}
			}
		}
	}

	object Naver : LoginTypes(R.drawable.ic_naver_login) {
		fun login(context: Context, onKakaoResult: (Result<OAuthToken>) -> Unit) {

		}
	}

	object Google : LoginTypes(R.drawable.ic_google_login) {
		fun login(context: Context, onKakaoResult: (Result<OAuthToken>) -> Unit) {

		}
	}
}

sealed class LoginUiState {
	object Loading : LoginUiState()
	object Success : LoginUiState()
	data class Error(val message: String) : LoginUiState()
}

data class LoginState(val state: LoginUiState = LoginUiState.Loading)
