package com.example.eventmanagement19

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [QrCodeCameraFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [QrCodeCameraFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class QrCodeCameraFragment : Fragment(), ZXingScannerView.ResultHandler  {



    private lateinit var mScannerView: ZXingScannerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return startQRCodeScanner()
    }

    fun startQRCodeScanner(): View {
        mScannerView = ZXingScannerView(context)   // Programmatically initialize the scanner view
        mScannerView.setResultHandler(this@QrCodeCameraFragment)
        mScannerView.startCamera()
        return mScannerView // Set the scanner view as the content view
    }

    override fun handleResult(p0: Result?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
