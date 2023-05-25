package com.devjj.platform.nurbanhoney.feature.ui

import com.devjj.platform.nurbanhoney.NurbanTokenRepository
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNurbanToken
@Inject constructor(private val repository: NurbanTokenRepository): UseCase<Flow<String?>, UseCase.None>() {
	override suspend fun run(params: None) = repository.getNurbanToken()
}