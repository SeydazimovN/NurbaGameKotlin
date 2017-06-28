package com.example.root.nurbagamekotlin


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*


/**
 * A simple [Fragment] subclass.
 * Use the [PrimeORComposite.newInstance] factory method to
 * create an instance of this fragment.
 */
class PrimeORComposite : Fragment() {

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        if (arguments != null) {
//            mParam1 = arguments.getString(ARG_PARAM1)
//            mParam2 = arguments.getString(ARG_PARAM2)
//        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val myView = inflater!!.inflate(R.layout.fragment_prime_orcomposite, container, false)
        var numberTextView = myView.findViewById<TextView>(R.id.givenNumber)
        var randomNumber = randomInt(600000) + 300000
        val lastDig = listOf(1, 3, 7, 9)
        randomNumber = randomNumber * 10 + lastDig.get(randomInt(4))
        numberTextView.text = randomNumber.toString()

        var isPrimeRes = isPrime(randomNumber)

        var primeButton = myView.findViewById<Button>(R.id.primeButton)
        primeButton.setOnClickListener {
            if (isPrimeRes) sayToUser("correct")
            else sayToUser("wrong")
        }
        var compositeButton = myView.findViewById<Button>(R.id.compositeButton)
        compositeButton.setOnClickListener {
            if (!isPrimeRes) sayToUser("correct")
            else sayToUser("wrong")
        }
        return myView
    }

    fun sayToUser(sentence : String) {
        Toast.makeText(context, sentence, Toast.LENGTH_LONG).show()
    }

    fun isPrime(N : Int) : Boolean {
        var sqrtN = Math.sqrt(N.toDouble()).toInt()
        for (i in 2 .. sqrtN)
            if (N % i == 0)
                return false
        return true
    }
    fun randomInt(range : Int) : Int {
        var random = Random()
        return random.nextInt(range)
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

        // TODO: Rename and change types and number of parameters
        fun newInstance(): PrimeORComposite {
            val fragment = PrimeORComposite()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
