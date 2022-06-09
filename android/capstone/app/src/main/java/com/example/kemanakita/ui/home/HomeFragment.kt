package com.example.kemanakita.ui.home


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kemanakita.R
import com.example.kemanakita.databinding.FragmentHomeBinding
import com.example.kemanakita.preferense.ModelListWisata

class HomeFragment : Fragment() {
    private lateinit var rvHeroes: RecyclerView
    private var _binding: FragmentHomeBinding? = null
    private val list = ArrayList<ModelListWisata>()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
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
//    private fun showRecyclerList() {
//        rvHeroes = binding.recyclerView
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