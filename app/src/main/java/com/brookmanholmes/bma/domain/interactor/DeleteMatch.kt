package com.brookmanholmes.bma.domain.interactor

import com.brookmanholmes.bma.data.executor.JobExecutor
import com.brookmanholmes.bma.data.repository.MatchDataRepository
import com.brookmanholmes.bma.domain.executor.PostExecutionThread
import com.brookmanholmes.bma.domain.executor.ThreadExecutor
import com.brookmanholmes.bma.domain.repository.MatchRepository
import io.reactivex.Observable

/**
 * Created by brookman on 9/18/17.
 */
class DeleteMatch(val matchDataRepository: MatchRepository = MatchDataRepository(),
                  threadExecutor: ThreadExecutor = JobExecutor(),
                  postExecutionThread: PostExecutionThread = UseCase.Companion) :
        UseCase<Void, String>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: String): Observable<Void> {
        matchDataRepository.removeMatch(params)
        return Observable.empty()
    }
}