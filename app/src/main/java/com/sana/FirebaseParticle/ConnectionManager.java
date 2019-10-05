package com.sana.FirebaseParticle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectionManager {

    public static boolean checkConnection(Context context){

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null)
        {
            @SuppressLint("MissingPermission") NetworkInfo[] info = connectivityManager.getAllNetworkInfo();

                    if(info != null)
                    {
                        for (int i = 0; i < info.length; i++)
                        {
                            if (info[i].getState()== NetworkInfo.State.CONNECTED)
                            {
                                return true;
                            }
                        }
                    }
        }



        return false;
    }

}
