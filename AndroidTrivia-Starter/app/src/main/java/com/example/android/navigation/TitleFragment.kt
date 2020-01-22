package com.example.android.navigation


import android.content.Context
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding=
                DataBindingUtil.inflate<FragmentTitleBinding>( //Defines the binding variable
                                                               // to the fragment layout binding
                inflater, // inflates the layout
                R.layout.fragment_title, //provides the layout for the fragment
                container, // (optional parameter) clarifies the parent ViewGroup
                false)

        // Adds the playButton
        binding.playButton.setOnClickListener{
            view?.findNavController()?.navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
        }
        // Adds the ruleButton
        binding.rulesButton.setOnClickListener{
            view?.findNavController()?.navigate(TitleFragmentDirections.actionTitleFragmentToRulesFragment())
        }
        // Adds the aboutButton
        binding.aboutButton.setOnClickListener{
            view?.findNavController()?.navigate(TitleFragmentDirections.actionTitleFragmentToAboutFragment())
        }

        setHasOptionsMenu(true)

        //Log.i("TitleFragment","onCreateView called")

        return binding.root  //outputs the inflated view
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("TitleFragment", "onAttach called")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("TitleFragment", "onCreate called")
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("TitleFragment", "onActivityCreated called")
    }
    override fun onStart() {
        super.onStart()
        Log.i("TitleFragment", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("TitleFragment", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("TitleFragment", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("TitleFragment", "onStop called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("TitleFragment", "onDestroyView called")
    }
    override fun onDetach() {
        super.onDetach()
        Log.i("TitleFragment", "onDetach called")
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,view!!.findNavController())
                || super.onOptionsItemSelected(item)

    }

}
