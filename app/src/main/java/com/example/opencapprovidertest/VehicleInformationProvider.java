package com.example.opencapprovidertest;

import android.util.Log;

import org.opencabstandard.provider.VehicleInformationContract;

public class VehicleInformationProvider extends AbstractVehicleInformationProvider {
    private static final String LOG_TAG = "VehicleInformationProvider";

    @Override
    public VehicleInformationContract.VehicleInformation getVehicleInformation(String version) {
        Log.d(LOG_TAG, "getVehicleInformation()");

        VehicleInformationContract.VehicleInformation vehicleInformation = new VehicleInformationContract.VehicleInformation();
        if (CurrentVin.getInstance().getVin() != null) {
            vehicleInformation.setVin(CurrentVin.getInstance().getVin());
        }
        vehicleInformation.setVehicleId("Great Vehicle ID 1");
        vehicleInformation.setInGear(true);

        printVehicleInformation(vehicleInformation);
        return vehicleInformation;
    }

    private void printVehicleInformation(VehicleInformationContract.VehicleInformation vehicleInformation) {
        String vinIsNullSuffix = "false";
        if (vehicleInformation.getVin() == null) {
            vinIsNullSuffix = "true";
        }

        Log.d(LOG_TAG, "VIN IS NULL" + vinIsNullSuffix);
    }
}