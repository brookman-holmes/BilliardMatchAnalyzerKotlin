package com.brookmanholmes.scaffold.domain.interactor

import android.support.v4.util.Preconditions
import com.brookmanholmes.scaffold.data.executor.JobExecutor
import com.brookmanholmes.scaffold.domain.executor.PostExecutionThread
import com.brookmanholmes.scaffold.domain.executor.ThreadExecutor
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This interface represents a execution unit for different use cases (this means any use case
 * in the application should implement this contract).
 *
 * By convention each UseCase implementation will return the result using a {@link DisposableObserver}
 * that will execute its job in a background thread and will post the result in the UI thread.
 */
abstract class UseCase<T, Params>(val threadExecutor: ThreadExecutor = JobExecutor(),
                                  val postExecutionThread: PostExecutionThread = UseCase.Companion,
                                  val disposables: CompositeDisposable = CompositeDisposable()) {

    /**
     * Builds an {@link Observable} which will be used when executing the current {@link UseCase}.
     */
    abstract fun buildUseCaseObservable(params: Params?): Observable<T>

    /**
     * Executes the current use case.
     *
     * @param observer {@link DisposableObserver} which will be listening to the observable build
     * by {@link #buildUseCaseObservable(Params)} ()} method.
     * @param params Parameters (Optional) used to build/execute this use case.
     */
    fun execute(observer: DisposableObserver<T>, params: Params?) {
        val observable = buildUseCaseObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
        addDisposable(observable.subscribeWith(observer))
    }

    /**
     * Dispose from current {@link CompositeDisposable}.
     */
    fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    /**
     * Dispose from current {@link CompositeDisposable}.
     */
    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    companion object: PostExecutionThread {
        override fun getScheduler(): Scheduler {
            return AndroidSchedulers.mainThread()
        }
    }
}