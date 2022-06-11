package com.example.kemanakita.ui.home


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
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
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        list.clear()
        list.addAll(getwisata)
        showCardView()
        return binding.root
    }

    private val getwisata: ArrayList<ModelListWisata>
        @SuppressLint("Recycle")
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataDescription = resources.getStringArray(R.array.data_location)
            val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
            val listHero = ArrayList<ModelListWisata>()
            listHero.clear()
            for (i in dataName.indices) {
                val hero =
                    ModelListWisata(dataName[i], dataPhoto.getResourceId(i, -1), dataDescription[i])
                listHero.add(hero)

            }
            return listHero
        }

    private fun showCardView() {
        binding.recyclerKita.setHasFixedSize(true)
        binding.recyclerKita.layoutManager = GridLayoutManager(activity, 2)
        val cardViewUserAdapter = HomeAdapter(list)
        binding.recyclerKita.adapter = cardViewUserAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}