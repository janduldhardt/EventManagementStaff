package com.example.eventmanagement19

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup



/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [QrCodeCameraFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [QrCodeCameraFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class QrCodeCameraFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_qr_code_camera, container, false)
    }

}
