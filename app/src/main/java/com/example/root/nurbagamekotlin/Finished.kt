package com.example.root.nurbagamekotlin


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


// TODO: Rename parameter arguments, choose names that match

class Finished : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var myView = inflater!!.inflate(R.layout.fragment_finished, container, false)
        return myView
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        fun newInstance(): Finished {
            val fragment = Finished()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
