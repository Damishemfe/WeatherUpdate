package com.hitrosttech.weatherupdate.domain.location

import android.location.Location

interface LocationTracker {
	suspend fun getCurrentLocation(): Location?
}