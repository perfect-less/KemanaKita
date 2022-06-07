package com.example.kemanakita.ui.dashboard

import android.Manifest
import android.app.Activity.RESULT_OK
import android.content.ContentValues.TAG
import android.content.Context

import android.content.Intent
import android.content.Intent.ACTION_GET_CONTENT
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kemanakita.api.ApiConfig
import com.example.kemanakita.databinding.FragmentDashboardBinding
import com.example.kemanakita.preferense.DestinationPreference

import com.example.kemanakita.preferense.ResponseDestination
import com.example.kemanakita.preferense.ViewModelFactory
import com.example.kemanakita.ui.dashboard.kamera.KameraActivity
import com.example.kemanakita.ui.dashboard.kamera.rotateBitmap
import com.example.kemanakita.ui.dashboard.kamera.uriToFile
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File


private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "auth")
class DashboardFragment : Fragment() {

    private var getFile: File? = null
    private var _binding: FragmentDashboardBinding? = null
    private lateinit var dashboardViewModel: DashboardViewModel
    // This property is only valid between onCreateView and
    // onDestroyView.
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (!allPermissionsGranted()) {
                Toast.makeText(
                    getActivity(),
                    "Tidak mendapatkan permission.",
                    Toast.LENGTH_SHORT
                ).show()
                activity?.onBackPressed()
            }
        }
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(requireContext(), it) == PackageManager.PERMISSION_GRANTED
    }

    private val binding get() = _binding!!

    override fun onCreateView(  
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val pref = DestinationPreference.getInstance(requireContext().dataStore)
        dashboardViewModel = ViewModelProvider(this,ViewModelFactory(pref))[DashboardViewModel::class.java]

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.btnKamera.setOnClickListener { startCameraX() }
        binding.btnScanFoto.setOnClickListener { startTakePhoto() }
        binding.btnAddgallry.setOnClickListener { startGallery() }
        binding.btnBackfoto.setOnClickListener { backToMenu() }


        if (!allPermissionsGranted()) {
            getActivity()?.let {
                ActivityCompat.requestPermissions(
                    it,
                    REQUIRED_PERMISSIONS,
                    REQUEST_CODE_PERMISSIONS
                )
            }
        }
        return root
    }
    private fun backToMenu() {
        Toast.makeText(getActivity(), "Fitur ini belum tersedia", Toast.LENGTH_SHORT).show()
    }

    private fun startGallery() {
        val intent = Intent()
        intent.action = ACTION_GET_CONTENT
        intent.type = "image/*"
        val chooser = Intent.createChooser(intent, "Choose a Picture")
        launcherIntentGallery.launch(chooser)
    }

    private fun startTakePhoto() {
        if (getFile != null) {
            val file = getFile as File
            val requestImageFile = file.asRequestBody("image/jpeg".toMediaTypeOrNull())
            val imageMultipart: MultipartBody.Part = MultipartBody.Part.createFormData(
                "imageFile",
                file.name,
                requestImageFile
            )
            val sevice = ApiConfig().getApiService().uploadImage(imageMultipart)
            sevice.enqueue(object : Callback<ResponseDestination>{
                override fun onResponse(
                    call: Call<ResponseDestination>,
                    response: Response<ResponseDestination>
                ) {
                    if (response.isSuccessful){
                        val Response =response.body()?.destination?.description
                        Response.let {
                            dashboardViewModel.saveDescription(it.toString())
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseDestination>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.printStackTrace()}")
                }
            })

        } else {
            Toast.makeText(getActivity(), "Silakan masukkan berkas gambar terlebih dahulu.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun startCameraX() {
        var intent = Intent(getActivity(),KameraActivity::class.java)
        launcherIntentCameraX.launch(intent)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private val launcherIntentCameraX = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == CAMERA_X_RESULT) {
            val myFile = it.data?.getSerializableExtra("picture") as File
            val isBackCamera = it.data?.getBooleanExtra("isBackCamera", true) as Boolean
            getFile = myFile
            val result = rotateBitmap(
                BitmapFactory.decodeFile(myFile.path),
                isBackCamera
            )

            binding.imageViewScan.setImageBitmap(result)
        }
    }

    private val launcherIntentGallery = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val selectedImg: Uri = result.data?.data as Uri
            val myFile = getActivity()?.let { uriToFile(selectedImg, it) }
            getFile = myFile
            binding.imageViewScan.setImageURI(selectedImg)
        }
    }


    companion object {
        const val CAMERA_X_RESULT = 200
        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
        private const val REQUEST_CODE_PERMISSIONS = 10
    }
}