package com.example.planificateurbudgetaire

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_principal.*
import kotlinx.android.synthetic.main.fragment_principal.view.*
import java.math.RoundingMode
import java.math.BigDecimal

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentPrincipal.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentPrincipal : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val args by navArgs<FragmentPrincipalArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onResume() {
        super.onResume()
        // Récupère la liste des revenus, calcule la somme totale et l'affiche.
        val liste_revenus = (activity as MainActivity?)!!.liste_revenus
        var somme_totale_revenus = 0.0
        liste_revenus.forEach {
            if (it.frequence == "Hebdomadaire") {
                somme_totale_revenus += it.somme * 4
            }
            else if (it.frequence == "Bimensuel") {
                somme_totale_revenus += it.somme * 2
            }
            else {
                somme_totale_revenus += it.somme
            }
        }
        revenus_totaux.setText(BigDecimal(somme_totale_revenus).setScale(2, RoundingMode.HALF_EVEN).toString())

        // Récupère la liste des dépenses, calcule la somme totale et l'affiche.
        val liste_depenses = (activity as MainActivity?)!!.liste_depenses
        var somme_totale_depenses = 0.0
        liste_depenses.forEach {
            if (it.frequence == "Hebdomadaire") {
                somme_totale_depenses += it.somme * 4
            }
            else if (it.frequence == "Bimensuel") {
                somme_totale_depenses += it.somme * 2
            }
            else {
                somme_totale_depenses += it.somme
            }
        }
        depenses_totales.setText(BigDecimal(somme_totale_depenses).setScale(2, RoundingMode.HALF_EVEN).toString())

        // Calcule les revenus moins les dépenses et affiche l'argent disponible.
        var somme_restante = somme_totale_revenus - somme_totale_depenses
        argent_disponible.setText(BigDecimal(somme_restante).setScale(2, RoundingMode.HALF_EVEN).toString())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_principal, container, false)

        view.bouton_revenu.setOnClickListener { Navigation.findNavController(view).navigate(R.id.navigateToFragmentAjoutRevenu) }
        view.bouton_depense.setOnClickListener { Navigation.findNavController(view).navigate(R.id.navigateToFragmentAjoutDepense) }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentPrincipal.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentPrincipal().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}