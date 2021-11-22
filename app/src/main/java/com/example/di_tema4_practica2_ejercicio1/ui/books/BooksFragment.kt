package com.example.di_tema4_practica2_ejercicio1.ui.books

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.di_tema4_practica2_ejercicio1.ItemBooks
import com.example.di_tema4_practica2_ejercicio1.ItemBooksAdapter
import com.example.di_tema4_practica2_ejercicio1.R
import com.example.di_tema4_practica2_ejercicio1.databinding.FragmentBooksBinding

class BooksFragment : Fragment() {

    private lateinit var booksViewModel: BooksViewModel
    private var _binding: FragmentBooksBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        booksViewModel =
            ViewModelProvider(this).get(BooksViewModel::class.java)

        _binding = FragmentBooksBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val listaBooks = ArrayList<ItemBooks>()
        listaBooks.
        add(
            ItemBooks(
                R.string.autor1, R.string.titulo1, "22€",
                R.drawable.book1, R.string.sinopsis1
            )
        )
        listaBooks.add(
            ItemBooks(
                R.string.autor2, R.string.titulo2, "17€",
                R.drawable.book2, R.string.sinopsis2)
        )
        listaBooks.add(
            ItemBooks(
                R.string.autor3, R.string.titulo3, "19€",
                R.drawable.book3, R.string.sinopsis3)
        )
        listaBooks.add(
            ItemBooks(
                R.string.autor4, R.string.titulo4, "14€",
                R.drawable.book4, R.string.sinopsis4)
        )
        listaBooks.add(
            ItemBooks(
                R.string.autor5, R.string.titulo5, "17€",
                R.drawable.book5, R.string.sinopsis5)
        )
        listaBooks.add(
            ItemBooks(
                R.string.autor6, R.string.titulo6, "20",
                R.drawable.book6, R.string.sinopsis6)
        )
        listaBooks.add(
            ItemBooks(
                R.string.autor7, R.string.titulo7, "19€",
                R.drawable.book7, R.string.sinopsis7)
        )
        listaBooks.add(
            ItemBooks(
                R.string.autor8, R.string.titulo8, "14€",
                R.drawable.book8, R.string.sinopsis8)
        )




        val recView = binding.recView
        recView.setHasFixedSize(true)

        val adaptador = ItemBooksAdapter(listaBooks)
        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}