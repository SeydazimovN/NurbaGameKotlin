package com.example.root.nurbagamekotlin


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.collections.HashMap


/**
 * A simple [Fragment] subclass.
 * Use the [SmallestUnique.newInstance] factory method to
 * create an instance of this fragment.
 */
class SmallestUnique : Fragment() {

    // TODO: Rename and change types of parameters
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        var myView = inflater!!.inflate(R.layout.fragment_smallest_unique, container, false)
        var numberOfPlayersTextView = myView.findViewById<TextView>(R.id.givenNumber)
        val numberOfPlayers = randomInt(500) + 2
        numberOfPlayersTextView.text = numberOfPlayers.toString()
        var submitButton = myView.findViewById<Button>(R.id.submitButton)
        submitButton.setOnClickListener {

            var playerNumberEditText = myView.findViewById<EditText>(R.id.playerNumber)
            var numberAsString = playerNumberEditText.text.toString()
            var playerNumber = Integer.parseInt(numberAsString)
            println(playerNumber)
            var result = isSmallestUnique(playerNumber, numberOfPlayers, myView) as String

            var response = when(result) {
                "win" -> "you won"
                "lost" -> "you lost"
                else -> "draw game"
            }
            sayToUser(response)
        }
        return myView
    }

    fun isSmallestUnique(number : Int, total : Int, view : View) : String {

        val array = IntArray(total + 1)
        for (i in 1 .. total) array[i] = 0

        array[1]++
        for (i in 2 .. total) {
            var pickedNumber = randomInt(i - 1) + 1
            array[pickedNumber]++
        }
        for (i in 1 .. total) {
            if (array[i] == 1) {
                var winnerNumberTextView = view.findViewById<TextView>(R.id.winnerNumber)
                winnerNumberTextView.text = "winner number is ${i}"
                if (i == number) return "win"
                else return "lost"
            }
        }
        return "draw"
    }

    fun sayToUser(sentence : String) {
        Toast.makeText(context, sentence, Toast.LENGTH_LONG).show()
    }
    fun randomInt(range : Int) : Int {
        var random = Random()
        return random.nextInt(range)
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

        // TODO: Rename and change types and number of parameters
        fun newInstance(): SmallestUnique {
            val fragment = SmallestUnique()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
