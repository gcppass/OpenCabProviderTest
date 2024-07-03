package com.example.opencapprovidertest;

import android.util.Log;

import org.opencabstandard.provider.VehicleInformationContract;

public class VehicleInformationProvider extends AbstractVehicleInformationProvider {
    private static final String LOG_TAG = "VehicleInformationProvider";

    @Override
    public VehicleInformationContract.VehicleInformation getVehicleInformation(String version) {
        Log.d(LOG_TAG, "getVehicleInformation()");

        VehicleInformationContract.VehicleInformation vehicleInformation = new VehicleInformationContract.VehicleInformation();
        vehicleInformation.setVehicleId("Great Vehicle ID 1");
        vehicleInformation.setVin("1GB4YSE74LF293614");
        vehicleInformation.setInGear(true);
        return vehicleInformation;
    }
}