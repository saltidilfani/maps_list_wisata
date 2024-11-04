package com.salti.maps_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.salti.maps_kotlin.databinding.ActivityMaps2Binding

class MapsActivity2 : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMaps2Binding
    private lateinit var lokasiWisata: LatLng

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMaps2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //untuk get latitude longitude dari intent
        val latitude = intent.getDoubleExtra("Latitude Wisata", 0.3051816)
        val longitude = intent.getDoubleExtra("Latitude Wisata", 100.3694972)

        // Menyimpan lokasi tujuan sebagai LatLng
        lokasiWisata = LatLng(latitude, longitude)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapWisataActivity) as SupportMapFragment
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

        mMap = googleMap


        // Menambahkan marker dan memindahkan kamera
        googleMap.addMarker(MarkerOptions().position(lokasiWisata).title("Lokasi Wisata"))
        // Move the camera to the map coordinates and zoom in closer.
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(lokasiWisata))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasiWisata, 8f))
    }
}







