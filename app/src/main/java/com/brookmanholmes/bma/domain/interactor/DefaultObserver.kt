package com.brookmanholmes.bma.domain.interactor

import io.reactivex.observers.DisposableObserver

/**
 * Created by brookman on 9/16/17.
 */
open class DefaultObserver<T>: DisposableObserver<T>() {
    override fun onNext(t: T) {
    }

    override fun onComplete() {
    }

    override fun onError(e: Throwable) {
    }
}