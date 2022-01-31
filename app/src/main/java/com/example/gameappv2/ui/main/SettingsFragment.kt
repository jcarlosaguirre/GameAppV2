package com.example.gameappv2.ui.main

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.gameappv2.R

class SettingsFragment : PreferenceFragmentCompat() {

    /**
     * Set shared preferences on default location and using the given xml resource
     *
     * @param savedInstanceState
     * @param rootKey
     */
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
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
            SettingsFragment()
//                .apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
    }
}