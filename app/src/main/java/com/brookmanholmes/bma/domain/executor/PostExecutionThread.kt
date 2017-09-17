package com.brookmanholmes.bma.domain.executor

import io.reactivex.Scheduler

/**
 * Created by brookman on 9/16/17.
 */
interface PostExecutionThread {
    fun getScheduler(): Scheduler
}