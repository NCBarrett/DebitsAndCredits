package com.neillbarrett.debitsandcredits.database

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class CreditsAndDebitsApp : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())


}