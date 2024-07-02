package com.example.opencapprovidertest.opencab

import android.util.Log
import com.example.opencapprovidertest.AbstractVehicleInformationProvider
import com.example.opencapprovidertest.VehicleInformationContract.VehicleInformation


class VehicleInformationProvider : AbstractVehicleInformationProvider() {
    override fun getVehicleInformation(version: String): VehicleInformation {
        Log.d(LOG_TAG, "getVehicleInformation()")

        val vehicleInformation = VehicleInformation()
        vehicleInformation.vehicleId = "Great Vehicle ID 1"
        vehicleInformation.vin = "QWERRTYUIOP12345"
        vehicleInformation.isInGear = true
        return vehicleInformation
    }

    companion object {
        private val LOG_TAG: String = "OpenCabVehicleInfoProvider"
    }
}