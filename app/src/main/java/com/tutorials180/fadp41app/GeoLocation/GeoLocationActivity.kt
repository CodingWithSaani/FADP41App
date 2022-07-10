package com.tutorials180.fadp41app.GeoLocation

import android.content.Context
import android.content.pm.PackageManager
import android.location.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.tutorials180.fadp41app.R
import java.util.*

class GeoLocationActivity : AppCompatActivity(),LocationListener
{
    private lateinit var getLatLngBtn:Button
    private lateinit var latTV:TextView

    private lateinit var lngTV:TextView
    private lateinit var mLocationManager: LocationManager

    private lateinit var mGeocoder: Geocoder
    private lateinit var addressTV: TextView

    private lateinit var performReveseGeoCodingBtn:Button
    private lateinit var currentLocation:Location
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_geo_location)

        initializer()
        getLatLngBtn.setOnClickListener {
            getLiveLatLng()
        }

        performReveseGeoCodingBtn.setOnClickListener {
            performReverseGeoCoding(currentLocation)
        }
    }

    private fun performReverseGeoCoding(location: Location) {

            var address:List<Address> = mGeocoder.getFromLocation(location.latitude,
                                        location.longitude,1)
            addressTV.text = "${address[0].getAddressLine(0)} ${address[0].adminArea}" +
                             "${address[0].postalCode} ${address[0].countryName}"
    }

    private fun getLiveLatLng() {
       if(ActivityCompat.checkSelfPermission(
               applicationContext,android.Manifest.permission.ACCESS_COARSE_LOCATION
       )==PackageManager.PERMISSION_GRANTED)
       {
            mLocationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                5000,
                5.0f,
                this
                )
       }
        else
       {
           Toast.makeText(applicationContext, "You don't have the permission", Toast.LENGTH_SHORT).show();
           ActivityCompat.requestPermissions(
               GeoLocationActivity@this,
               arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION),
               200
           )
       }
    }


    private fun initializer()
    {
        getLatLngBtn = findViewById(R.id.getLatLngBtn)
        latTV = findViewById(R.id.latTV)

        lngTV = findViewById(R.id.lngTV)
        mLocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        mGeocoder = Geocoder(applicationContext, Locale.getDefault())
        addressTV = findViewById(R.id.addressTV)

        performReveseGeoCodingBtn = findViewById(R.id.performReverseGeoCodingBtn)
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==200)
        {
            if(grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(applicationContext, "Permission Granted", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(applicationContext, "Permission Not Granted", Toast.LENGTH_SHORT).show();
            }
        }
    }

    override fun onLocationChanged(p0: Location) {
        latTV.text = p0.latitude.toString()
        lngTV.text = p0.longitude.toString()

        currentLocation = p0
    }














}