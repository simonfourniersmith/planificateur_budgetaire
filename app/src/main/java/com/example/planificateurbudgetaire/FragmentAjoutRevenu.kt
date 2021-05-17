package com.example.planificateurbudgetaire

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.Navigation
import com.example.planificateurbudgetaire.model.Revenu
import kotlinx.android.synthetic.main.fragment_ajout_revenu.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentAjoutRevenu.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentAjoutRevenu : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_ajout_revenu, container, false)

        // Lorsque le bouton 'ajouter' est appuyé, les renseignements sur le revenu sont envoyés dans MainActivity et on retourne à l'écran d'accueil.
        view.bouton_ajouter.setOnClickListener {
            val categorie = view.input_categorie_revenu.text.toString()
            val frequence = view.spinner_frequence.selectedItem.toString()
            var somme = view.input_somme.text.toString()
            if (somme.isEmpty()) {
                somme = "0"
            }
            var somme_float = somme.toFloat()
            val revenu = Revenu(categorie, frequence, somme_float)

            (activity as MainActivity?)!!.addRevenu(revenu)

            Navigation.findNavController(view).navigate(R.id.navigateToFragmentPrincipal)
        }

        // Retour à l'écran d'accueil.
        view.bouton_annuler.setOnClickListener { Navigation.findNavController(view).navigate(R.id.navigateToFragmentPrincipal) }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentAjoutRevenu.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentAjoutRevenu().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}