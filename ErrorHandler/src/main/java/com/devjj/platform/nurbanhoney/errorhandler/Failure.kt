package com.devjj.platform.nurbanhoney.errorhandler

sealed class Failure : Throwable() {
    object ServerFailure : Failure()
    object NetworkFailure : Failure()
    object TokenFailure : Failure()

    abstract class FeatureFailure : Failure()
}
