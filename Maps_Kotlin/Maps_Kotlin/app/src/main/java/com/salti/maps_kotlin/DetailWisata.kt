package com.salti.maps_kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class DetailWisata : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var imgDetailWisata: ImageView
    private lateinit var txtDeskripsiWisata: TextView
    private  lateinit var btnLihatMapWisata : Button
    private  lateinit var mapsWisata : SupportMapFragment //Ubah deklarasi mapsWisata ke SupportMapFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_wisata)

        imgDetailWisata = findViewById(R.id.imgDWisata)
        txtDeskripsiWisata = findViewById(R.id.txtDeskWisata)
        btnLihatMapWisata = findViewById(R.id.btnMaps2)

        // Pastikan fragment peta diinisialisasi dengan benar
        mapsWisata = supportFragmentManager.findFragmentById(R.id.mapWisata) as? SupportMapFragment ?:return
        mapsWisata.getMapAsync(this)

        //get data  //Mendapatkan data dari Intent
        val imgWisata = intent.getIntExtra("Image Wisata", 0)
        val deskripsiWisata = intent.getStringExtra("Deskripsi Wisata")

        //set data ke widget
        imgDetailWisata.setImageResource(imgWisata)
        txtDeskripsiWisata.setText(deskripsiWisata)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnLihatMapWisata.setOnClickListener{
            val intentPassingData = Intent(this@DetailWisata,
                MapsActivity2::class.java)

            // Mengambil data latitude dan longitude dari Intent DetailWisata
            val latitude = intent.getDoubleExtra("Latitude Wisata", -0.3051816)
            val longitude = intent.getDoubleExtra("Longitude Wisata", 100.3694972)

            // Mengirimkan latitude dan longitude ke MapsActivity2
            intentPassingData.putExtra("Latitude Wisata", latitude)
            intentPassingData.putExtra("Longitude Wisata", longitude)

            startActivity(intentPassingData)
        }
    }

    // Menginisialisasi peta
    override fun onMapReady(googleMap: GoogleMap) {
        // Menambahkan marker pada lokasi yang diberikan
        val lokasiWisata = LatLng(intent.getDoubleExtra("Latitude Wisata", -0.3051816),
            intent.getDoubleExtra("Longitude Wisata", 100.3694972))

        googleMap.addMarker(MarkerOptions().position(lokasiWisata).title("Lokasi Wisata"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasiWisata, 8f))
    }
}