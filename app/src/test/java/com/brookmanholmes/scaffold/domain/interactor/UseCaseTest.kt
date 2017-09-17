package com.brookmanholmes.scaffold.domain.interactor

import com.brookmanholmes.scaffold.domain.executor.PostExecutionThread
import com.brookmanholmes.scaffold.domain.executor.ThreadExecutor
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import io.reactivex.Observable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

import org.assertj.core.api.Assertions.assertThat
/**
 * Created by brookman on 9/16/17.
 */
class UseCaseTest {
    private lateinit var useCase: UseCaseTestClass
    private lateinit var testObserver: TestDisposableObserver<Object>
    private lateinit var mockThreadExecutor: ThreadExecutor
    private lateinit var mockPostExecutionThread: PostExecutionThread

    @get:Rule
    public val expectedException = ExpectedException.none()

    @Before
    fun setup() {
        mockThreadExecutor = mock()
        mockPostExecutionThread = mock()
        useCase = UseCaseTestClass(mockThreadExecutor, mockPostExecutionThread)
        testObserver = TestDisposableObserver()
        given(mockPostExecutionThread.getScheduler()).willReturn(TestScheduler())
    }

    @Test
    fun testBuildUseCaseObservableReturnCorrectResult() {
        useCase.execute(testObserver, Params())

        assertThat(testObserver.valuesCount).isZero()
    }

    @Test
    fun testSubscriptionWhenExecutingUseCase() {
        useCase.execute(testObserver, Params())
        useCase.dispose()

        assertThat(testObserver.isDisposed).isTrue()
    }

    private class TestDisposableObserver<T>: DisposableObserver<T>() {
        var valuesCount = 0

        override fun onNext(t: T) {
            valuesCount++
        }

        override fun onComplete() {

        }

        override fun onError(e: Throwable) {

        }
    }

    private class UseCaseTestClass(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread):
            UseCase<Object, Params>(threadExecutor, postExecutionThread) {

        override fun buildUseCaseObservable(params: Params?): Observable<Object> {
            return Observable.empty()
        }
    }

    private class Params {

    }
}