package com.example.kemanakita.ui.notifications

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kemanakita.R
import com.example.kemanakita.databinding.FragmentNotificationsBinding
import com.example.kemanakita.preferense.ModelListWisata
import com.example.kemanakita.ui.home.HomeAdapter

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private val list = ArrayList<ModelListWisata>()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        list.clear()
        list.addAll(getwisata)
        showCardView()


        return root
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
        binding.recyclerVieFavorite.setHasFixedSize(true)
        binding.recyclerVieFavorite.layoutManager = LinearLayoutManager(activity)
        val cardViewUserAdapter = FavoriteAdapter(list)
        binding.recyclerVieFavorite.adapter = cardViewUserAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}