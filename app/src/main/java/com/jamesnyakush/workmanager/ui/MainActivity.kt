package com.jamesnyakush.workmanager.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.jamesnyakush.workmanager.R
import com.jamesnyakush.workmanager.workers.FirstWorker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener{
            val workManager = WorkManager.getInstance()

            val firstWorkerRequest = OneTimeWorkRequest.Builder(FirstWorker::class.java).build()

            workManager.enqueue(firstWorkerRequest)
            //workManager.beginWith(firstWorkerRequest).enqueue()

            workManager.getWorkInfoByIdLiveData(firstWorkerRequest.id).observe(this, Observer {workInfo->

                var fwStatus =workInfo?.state

                Toast.makeText(applicationContext,fwStatus?.name,Toast.LENGTH_LONG).show()

            })
        }


    }
}
