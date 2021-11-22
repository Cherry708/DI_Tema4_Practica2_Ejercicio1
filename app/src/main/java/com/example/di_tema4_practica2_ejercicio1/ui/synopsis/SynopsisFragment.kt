package com.example.di_tema4_practica2_ejercicio1.ui.synopsis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.di_tema4_practica2_ejercicio1.databinding.FragmentSynopsisBinding

class SynopsisFragment : Fragment() {

    private lateinit var synopsisViewModel: SynopsisViewModel
    private var _binding: FragmentSynopsisBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        synopsisViewModel =
            ViewModelProvider(this).get(SynopsisViewModel::class.java)

        _binding = FragmentSynopsisBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val listaTitulos = ArrayList<String>()
        listaTitulos.add("Morir no es lo que más duele")
        listaTitulos.add("Yo, Julia")
        listaTitulos.add("La vida en cuatro letras")
        listaTitulos.add("Tus pasos en la\n" +
                "escalera")
        listaTitulos.add("Cementerio de\n" +
                "animales")
        listaTitulos.add("Sidi")
        listaTitulos.add("Una jaula de oro")
        listaTitulos.add("Lo mejor de ir es volver")


        val listaSinopsis = ArrayList<String>()
        listaSinopsis.add("Un hombre aparece ahorcado en un pinar a las afueras de Madrid, con los ojos arrancados de cuajo. En uno de sus bolsillos se halla un papel con el nombre y la dirección de una mujer:Sara Azcárraga, que vive a pocos kilómetros del escenario del crimen.")
        listaSinopsis.add("192 d.C. Varios hombres luchan por un imperio, pero Julia, hija de reyes, madre de césares y esposa de emperador, piensa en algo más ambicioso: una dinastía.")
        listaSinopsis.add("Partiendo de un momento extraordinariamente difícil de la vida del autor, este libro empieza con una pregunta fascinante: ¿llevamos la felicidad escrita en nuestros genes?.")
        listaSinopsis.add("Un hombre anticipa con ilusión el momento de reunirse con su esposa mientras ultima los preparativos de su nuevo hogar en Lisboa. Atrás queda una etapa de sus vidas en Nueva York marcada por el indeleble recuerdo del 11-S.")
        listaSinopsis.add("Church estaba allí otra vez, como Louis Creed temía y deseaba. Porque su hijita Ellie le había encomendado que cuidara del gato, y Church había muerto atropellado. Louis lo había comprobado: el gato estaba muerto, incluso lo había enterrado más allá del cementerio de animales.")
        listaSinopsis.add("En él se funden de un modo fascinante la aventura, la historia y la leyenda. Hay muchos Cid en la tradición española, y éste es el mío.")
        listaSinopsis.add("Faye, con un oscuro pasado, ha conseguido todolo que siempre había soñado, un marido atractivo, una hija a la que quiere y, sobre todo, estatus social y una vida llena de lujo. Pero cuando, de un día para otro, esta vida perfecta se va al traste, surge una nueva mujer intrépida y vengadora.")
        listaSinopsis.add("Bella historia sobre los recuerdos, el perdón y el amor que transcurre el 23 de abril, el día del libro y las rosas, entre la ciudad de Barcelona y las islas de Ischia y Menorca.")


        val adaptador = ArrayAdapter<String>(requireContext(),
            android.R.layout.simple_dropdown_item_1line, listaTitulos)


        binding.actvBook.setAdapter(adaptador)
        binding.actvBook.threshold = 1

        binding.actvBook.setOnItemClickListener{ adaptadorItem: AdapterView<*>, viewItem: View,
                                                     posicion: Int, l: Long ->
            val itemTitulo = adaptadorItem.getItemAtPosition(posicion) as String
            for (titulo in listaTitulos){
                if (titulo == itemTitulo) {
                   binding.tvSinopsis.text = listaSinopsis[listaTitulos.indexOf(titulo)]
                }
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}