package com.salti.maps_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMapOptions
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.salti.maps_kotlin.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
//        mMap = googleMap
//
//        // Add a marker in Sydney and move the camera
//        val sydney = LatLng(-0.9345836, 100.3912699)
//        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))


        // Set the map coordinates to Kyoto Japan.
        val kyoto = LatLng(35.00116, 135.7681)

        // Set the map type to Hybrid.
        googleMap.mapType = GoogleMap.MAP_TYPE_HYBRID

        val options = GoogleMapOptions()
        options.mapType(GoogleMap.MAP_TYPE_SATELLITE)
            .compassEnabled(true)
            .rotateGesturesEnabled(true)
            .tiltGesturesEnabled(true)
        googleMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
        // Add a marker on the map coordinates.
        googleMap.addMarker(
            MarkerOptions()
                .position(kyoto)
                .title("Kyoto")
        )

        // Move the camera to the map coordinates and zoom in closer.
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(kyoto))
        googleMap.moveCamera(CameraUpdateFactory.zoomTo(15f))

        // Display traffic.
        googleMap.isTrafficEnabled = true
    }
}