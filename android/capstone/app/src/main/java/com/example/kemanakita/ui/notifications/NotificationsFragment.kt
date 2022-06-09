package com.example.kemanakita.ui.notifications

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kemanakita.R
import com.example.kemanakita.databinding.FragmentNotificationsBinding
import com.example.kemanakita.preferense.ModelListWisata
import com.example.kemanakita.ui.home.HomeAdapter

class NotificationsFragment : Fragment() {
//    private lateinit var rvHeroes: RecyclerView
    private var _binding: FragmentNotificationsBinding? = null
//    private val list = ArrayList<ModelListWisata>()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root




//        list.addAll(listHeroes)
//        showRecyclerList()
        return root
    }
//    private val listHeroes: ArrayList<ModelListWisata>
//        @SuppressLint("Recycle")
//        get() {
//            val dataName = resources.getStringArray(R.array.data_name)
//            val dataDescription = resources.getStringArray(R.array.data_location)
//            val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
//            val listHero = ArrayList<ModelListWisata>()
//            for (i in dataName.indices) {
//                val hero = ModelListWisata( dataPhoto.getResourceId(i, -1),dataName[i],dataDescription[i])
//                listHero.add(hero)
//            }
//            return listHero
//        }
//
//
//    private fun showRecyclerList() {
//        rvHeroes = binding.recyclerView1
//        rvHeroes.setHasFixedSize(true)
//        rvHeroes.layoutManager = LinearLayoutManager(activity)
//        val listHeroAdapter = HomeAdapter(list)
//        rvHeroes.adapter = listHeroAdapter
//    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}