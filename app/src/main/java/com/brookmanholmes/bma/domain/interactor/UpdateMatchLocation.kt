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
class UpdateMatchLocation(val matchDataRepository: MatchRepository = MatchDataRepository(),
                          threadExecutor: ThreadExecutor = JobExecutor(),
                          postExecutionThread: PostExecutionThread = UseCase.Companion) :
        UseCase<Void, UpdateMatchLocation.Params>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: Params): Observable<Void> {
        matchDataRepository.updateMatchLocation(params.id, params.location)
        return Observable.empty()
    }

    data class Params(val id: String, val location: String)
}