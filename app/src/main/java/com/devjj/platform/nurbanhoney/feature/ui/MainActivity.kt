package com.devjj.platform.nurbanhoney.feature.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.devjj.platform.nurbanhoney.core.navigation.SetupNavGraph
import com.devjj.platform.nurbanhoney.core.platform.BaseActivity
import com.devjj.platform.nurbanhoney.core.theme.NurbanHoneyTheme
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NurbanHoneyTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}
