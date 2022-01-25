package com.example.gory.fragment

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gory.R
import com.example.gory.databinding.FragmentMapsBinding

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {

    private var _binding: FragmentMapsBinding? = null
    private val binding get () = _binding!!

    private lateinit var googleMap: GoogleMap

    private val markersList: ArrayList<MarkerOptions> = ArrayList()

    private fun initMarkers(){
        markersList.add(MarkerOptions()
            .position(LatLng(49.65597974904006, 20.276747739454148))
            .title("Mogielica")
            .snippet("1170")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)))
        markersList.add(MarkerOptions()
            .position(LatLng(49.17977, 20.08803))
            .title("Rysy")
            .snippet("2501")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)))
        markersList.add(MarkerOptions()
            .position(LatLng(49.57396902136253, 19.530882200778183))
            .title("Babia Góra")
            .snippet("1725")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)))
        markersList.add(MarkerOptions()
            .position(LatLng(50.73664091824822, 15.739688178747647))
            .title("Śnieżka")
            .snippet("1602")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        markersList.add(MarkerOptions()
            .position(LatLng(50.21328434672711, 16.847346836461984))
            .title("Śnieżnik")
            .snippet("1425")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)))
        markersList.add(MarkerOptions()
            .position(LatLng(49.075489628460105, 22.726276817162653))
            .title("Tarnica")
            .snippet("1346")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))
        markersList.add(MarkerOptions()
            .position(LatLng(49.54344610675864, 20.111387685416048))
            .title("Turbacz")
            .snippet("1310")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)))
        markersList.add(MarkerOptions()
            .position(LatLng(49.450093117286556, 20.60413137001527))
            .title("Radziejowa")
            .snippet("1262")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)))
        markersList.add(MarkerOptions()
            .position(LatLng(49.68508693586849, 19.030290716189814))
            .title("Skrzyczne")
            .snippet("1257")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)))
        markersList.add(MarkerOptions()
            .position(LatLng(50.85070357998458, 15.419401455536365))
            .title("Wysoka Kopa")
            .snippet("1126")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)))
        markersList.add(MarkerOptions()
            .position(LatLng(50.24548224851119, 16.97636103928281))
            .title("Rudawiec")
            .snippet("1112")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        markersList.add(MarkerOptions()
            .position(LatLng(50.35071853086843, 16.349811185244214))
            .title("Orlica")
            .snippet("1084")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)))
        markersList.add(MarkerOptions()
            .position(LatLng(49.4333094775025, 20.44946087652411))
            .title("Wysoka")
            .snippet("1050")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)))
        markersList.add(MarkerOptions()
            .position(LatLng(50.684927604788264, 16.48648732669942))
            .title("Wielka Sowa")
            .snippet("1015")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)))
        markersList.add(MarkerOptions()
            .position(LatLng(49.427135501248785, 21.1025899486808))
            .title("Lackowa")
            .snippet("997")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)))
        markersList.add(MarkerOptions()
            .position(LatLng(50.264200262507366, 17.01388046247619))
            .title("Kowadło")
            .snippet("989")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))
        markersList.add(MarkerOptions()
            .position(LatLng(50.25288636944188, 16.564949988198798))
            .title("Jagodna")
            .snippet("977")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        markersList.add(MarkerOptions()
            .position(LatLng(50.80864899280983, 15.899964049444382))
            .title("Skalnik")
            .snippet("945")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)))
        markersList.add(MarkerOptions()
            .position(LatLng(50.680939713981175, 16.27810472345634))
            .title("Waligóra")
            .snippet("936")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))
        markersList.add(MarkerOptions()
            .position(LatLng(49.766327681478245, 19.1552050631697))
            .title("Czupel")
            .snippet("933")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)))
        markersList.add(MarkerOptions()
            .position(LatLng(50.48426517108458, 16.343203891162712))
            .title("Szczeliniec Wielki")
            .snippet("919")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)))
        markersList.add(MarkerOptions()
            .position(LatLng(49.76708136073559, 20.05958178637773))
            .title("Lubomir")
            .snippet("904")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
        markersList.add(MarkerOptions()
            .position(LatLng(50.257259696317895, 17.42868197219536))
            .title("Biskupia Kopia")
            .snippet("889")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))
        markersList.add(MarkerOptions()
            .position(LatLng(50.78045365290661, 16.211987552567702))
            .title("Chełmiec")
            .snippet("850")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)))
        markersList.add(MarkerOptions()
            .position(LatLng(50.45227979770458, 16.753640878394627))
            .title("Kłodzka Góra")
            .snippet("765")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)))
        markersList.add(MarkerOptions()
            .position(LatLng(50.944094285290184, 15.88468003774538))
            .title("Skopiec")
            .snippet("724")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))
        markersList.add(MarkerOptions()
            .position(LatLng(50.865048228394336, 16.708609841657445))
            .title("Ślęża")
            .snippet("718")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)))
        markersList.add(MarkerOptions()
            .position(LatLng(50.89211685609258, 20.89652729828751))
            .title("Łysica")
            .snippet("612")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))

    }

    private val callback = OnMapReadyCallback { googleMap ->

        val rysy = LatLng(49.17977, 20.08803)
        googleMap.addMarker(MarkerOptions().position(rysy).title("Znacznik na Rysach"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rysy, 10f))

        initMarkers()
        binding.buttonShowLocations.setOnClickListener{
            googleMap.clear()
            for (marker in markersList){
                googleMap.addMarker(marker)
            }
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(49.17977, 20.08803), 6f))
        }

        binding.radioButtonMapNormal.setOnClickListener{
            googleMap.mapType = GoogleMap.MAP_TYPE_NORMAL
        }
        binding.radioButtonMapSatelite.setOnClickListener{
            googleMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
        }

        binding.arrowBack.setOnClickListener{
            val fragment = MenuFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainer,fragment)?.commit()
        }

        googleMap.uiSettings.isZoomControlsEnabled = true
        googleMap.uiSettings.isZoomGesturesEnabled = true
        googleMap.uiSettings.isCompassEnabled = true
        googleMap.uiSettings.isMyLocationButtonEnabled = true
        googleMap.mapType = GoogleMap.MAP_TYPE_NORMAL
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(49.17977, 20.08803), 11f))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMapsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

}