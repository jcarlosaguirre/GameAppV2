package com.example.gameappv2.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.gameappv2.databinding.FragmentCharacterBinding
import androidx.fragment.app.FragmentTransaction
import com.example.gameappv2.ui.main.character.StatsFragment
import com.example.gameappv2.ui.main.character.TeamFragment


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CharacterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CharacterFragment : Fragment() {

    private lateinit var _binding: FragmentCharacterBinding
    private val binding get() = _binding

    private var middleSection: Boolean = false

    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
        Toast.makeText(requireContext(), "Create", Toast.LENGTH_SHORT).show()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Binding
        _binding = FragmentCharacterBinding.inflate( inflater, container, false)



        binding.middleSectionBtn.setOnClickListener {
            changeMiddleSection()
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Fragments for stats and team choosing
        setInnerFragments()
    }

    private fun setInnerFragments(){
        val transaction: FragmentTransaction = childFragmentManager.beginTransaction()

        val statsFragment: Fragment = StatsFragment()
        transaction.replace(binding.statsFragmentContainer.id, statsFragment)

        val teamFragment: Fragment = TeamFragment()
        transaction.replace(binding.teamFragmentContainer.id, teamFragment)

        transaction.commit()
    }

    private fun changeMiddleSection(){

        middleSection = !middleSection

//        if( middleSection ) {
//            binding.statsData.visibility = View.GONE
//            binding.teamMembers.visibility = View.VISIBLE
//        }
//        else{
//            binding.statsData.visibility = View.VISIBLE
//            binding.teamMembers.visibility = View.GONE
//        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CharacterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(/*param1: String, param2: String*/) =
            CharacterFragment()
//                .apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(requireContext(), "Resume", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(requireContext(), "Destroy", Toast.LENGTH_SHORT).show()
    }
}