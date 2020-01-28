package com.jamesnyakush.workmanager.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.jamesnyakush.workmanager.util.NotificationHelper.displayNotification
import com.jamesnyakush.workmanager.util.sleep

class FirstWorker(
    ctx: Context,
    params: WorkerParameters
) : Worker(ctx, params) {

    private val TAG by lazy {
        FirstWorker::class.java.simpleName
    }

    override fun doWork(): Result {

        displayNotification(applicationContext, "Doing First Job", "This is our first Worker class")

        return try {
            sleep()

            displayNotification(
                applicationContext,
                "Completed First Job",
                "This is our first Worker class"
            )

            Result.success()
        } catch (throwable: Throwable) {
            Result.failure()
        }
    }

}