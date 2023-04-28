package com.devjj.platform.nurbanhoney.feature.ui.login

sealed class LoginSideEffect {
	object BackStack : LoginSideEffect()
	object CancelLogin : LoginSideEffect()
}