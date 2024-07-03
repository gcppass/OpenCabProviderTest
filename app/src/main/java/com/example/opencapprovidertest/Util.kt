package com.example.opencapprovidertest

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import androidx.core.os.bundleOf
import org.opencabstandard.provider.VehicleInformationContract

class Util {
    enum class ReceiverType(val contractName: String) {
        VEHICLE_INFORMATION("VehicleInformationChangedReceiver"),
        IDENTITY("IdentityChangedReceiver")
    }
    companion object {
        fun sendIntent(context: Context, receiverType: ReceiverType) {
            val receivers = getReceivers(context, receiverType.contractName)
            val action = if(receiverType == ReceiverType.VEHICLE_INFORMATION) {
                VehicleInformationContract.ACTION_VEHICLE_INFORMATION_CHANGED
            } else {
                IdentityContract.ACTION_IDENTITY_INFORMATION_CHANGED

            }
            receivers.forEach { receiver ->
                val key = receiver.key
                val activityInfo = receiver.value
                val intent = Intent()
                intent.setComponent(ComponentName(activityInfo.packageName, key))
                intent.putExtras(bundleOf(
                    VehicleInformationContract.KEY_VEHICLE_INFORMATION to VehicleInformationContract.VehicleInformation()
                ))
                intent.setAction(action)
                context.sendBroadcast(intent)
            }
        }
        private fun getReceivers(context: Context, contractName: String): HashMap<String, ActivityInfo> {
            // See section 3.4, "Publishing broadcast intents", for specifics about this
            // enumeration process.
            val packages: List<PackageInfo> = context.getPackageManager()
                .getInstalledPackages(PackageManager.GET_RECEIVERS)
            val discoveredReceivers = HashMap<String, ActivityInfo>()
            if (packages != null) {
                for (packageInfo in packages) {
                    if (packageInfo.receivers != null) {
                        for (activityInfo in packageInfo.receivers) {
                            if (activityInfo.name.endsWith(contractName)) {
                                discoveredReceivers[activityInfo.name] = activityInfo
                            }
                        }
                    }
                }
            }
            return discoveredReceivers
        }
    }
}