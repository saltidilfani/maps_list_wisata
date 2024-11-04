package com.salti.maps_kotlin.model

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.salti.maps_kotlin.R
import com.salti.maps_kotlin.adapter.ListWisataAdapter
import java.util.ArrayList

class WisataActivity : AppCompatActivity() {

    private var recycleView : RecyclerView? = null
    private var wisataAdapter : ListWisataAdapter? = null

    //array data wisata
    private var wisataList = mutableListOf<ModelWisata>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_wisata)

        wisataList = ArrayList()
        recycleView = findViewById(R.id.rv_list_wisata)
        wisataAdapter = ListWisataAdapter (this, wisataList);

        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(this, 1)

        recycleView!!.layoutManager = layoutManager
        recycleView!!.adapter = wisataAdapter

        //create dummy data
        prepareDataWisata()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun prepareDataWisata(){
        var itemWisata = ModelWisata(
            R.drawable.jamgadang,
            "Jam Gadang",
            "Bukittinggi, Sumatera Barat",
            "Destinasi yang tidak boleh dilewatkan kalau kamu berkunjung ke Bukittinggi pastilah Jam Gadang. Jam di menara berukuran 13×4 meter ini berada di kawasan Taman Sabai Nan Aluih. Berlokasi di taman, Jam Gadang memiliki suasana yang rindang dengan adanya sejumlah pepohonan hijau. Ikon Bukittinggi ini tak pernah sepi dari pengunjung. Mulai dari pagi, siang, sore, hingga malam, kawasan ini sangat digemari oleh wisatawan.",
            -0.3051816,
            100.3694972
        )
        wisataList.add(itemWisata)
        itemWisata = ModelWisata(
            R.drawable.bali,
            "Ulun Danu Beratan",
            "Candikuning, Bali",
            "Danau Beratan merupakan danau terbesar kedua di Bali, dan menjadi sumber irigasi bagi persawahan dan perkebunan di seluruh Desa Bedugul. Gunung tempat danau ini berada sering disebut sebagai â€œgunung suciâ€ karena cuacanya sejuk dan tanahnya subur dan gembur.",
            -8.2751754,
            115.1642485
        )
        wisataList.add(itemWisata)
        itemWisata = ModelWisata(
            R.drawable.candiborobudur,
            "Candi Borobudur",
            "Magelang, Jawa Tengah",
            "Candi Borobudur merupakan sebuah candi Buddha yang megah dan menjadi salah satu situs bersejarah terpenting di Indonesia, terletak di Magelang, Jawa Tengah. Dibangun sekitar abad ke-9 Masehi, candi ini merupakan salah satu keajaiban arsitektur dan kepercayaan agama Buddha di Asia Tenggara.",
            -7.6067821,
            110.2054869
        )
        wisataList.add(itemWisata)
        wisataAdapter!!.notifyDataSetChanged()
    }
}