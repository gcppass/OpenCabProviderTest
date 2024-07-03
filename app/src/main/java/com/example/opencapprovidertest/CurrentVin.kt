package com.example.opencapprovidertest

class CurrentVin {
    var vin: String? = null

    companion object {
        private var instance: CurrentVin? = null

        fun setCurrentVin(vin: String?) {
            getInstance().vin = vin
        }

        @JvmStatic
        @Synchronized
        fun getInstance(): CurrentVin {
            synchronized(CurrentVin::class) {
                if (instance == null) {
                    instance = CurrentVin()
                }
            }
            return instance!!
        }
    }
}

/*


class LocationBroadcastReceiver @Inject constructor() : BroadcastReceiver() {

    var onNewLocation: (Location) -> Unit = {}

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent != null) {
            when (intent.action) {
                LocationService().broadcastFilter -> {
                    val bundle = intent.getBundleExtra("Location")
                    if (bundle?.isEmpty == false) {
                        val parcel = bundle.getParcelable<Location>("Location")
                        if (parcel != null) {
                            onNewLocation.invoke(parcel)
                        }
                    }
                }
            }
        }
    }

    companion object {
        private lateinit var instance: LocationBroadcastReceiver

        @JvmStatic
        @Synchronized
        fun getInstance(): LocationBroadcastReceiver {
            synchronized(LocationBroadcastReceiver::class) {
                if (!::instance.isInitialized) {
                    instance = LocationBroadcastReceiver()
                }
            }
            return instance
        }
    }
}
 */