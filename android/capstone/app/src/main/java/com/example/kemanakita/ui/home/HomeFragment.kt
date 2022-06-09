package com.example.kemanakita.ui.home


import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kemanakita.R
import com.example.kemanakita.databinding.FragmentHomeBinding
import com.example.kemanakita.preferense.ModelListWisata

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val list = ArrayList<ModelListWisata>()
    private lateinit var rvwisata: RecyclerView

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {



        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        rvwisata = binding.recyclerView
        rvwisata.setHasFixedSize(true)

list.addAll(listdestination)
showRecyclerList()

        return root
    }
    private val listdestination : ArrayList<ModelListWisata>
    get() {
        val dataname = resources.getStringArray(R.array.data_name)
        val datalocation = resources.getStringArray(R.array.data_location)
        val dataphoto = resources.obtainTypedArray(R.array.data_photo)
        val listdts =  ArrayList<ModelListWisata>()
        for (i in dataname.indices){
            val destetination = ModelListWisata(dataphoto.getResourceId(i, -1),dataname[i],datalocation[i],)
            listdts.add(destetination)
        }
        return listdts
    }

    private fun showRecyclerList(){

        if (requireActivity().applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvwisata.layoutManager = GridLayoutManager(getActivity(),1)
        }else{
            rvwisata.layoutManager = GridLayoutManager(getActivity(),2)
        }

        val listwisataadapter = HomeAdapter(list)
        rvwisata.adapter = listwisataadapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}