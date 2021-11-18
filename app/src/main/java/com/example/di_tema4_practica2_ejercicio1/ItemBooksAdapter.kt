package com.example.di_tema4_practica2_ejercicio1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ItemBooksAdapter(var listaItems: ArrayList<ItemBooks>) :
    RecyclerView.Adapter<ItemBooksAdapter.ItemViewHolder>() {
    /*Sustituimos onClick con on LongClick*/

    //La clase declarada como itemViewHolder hereda, es, un ViewHolder
    class ItemViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView)
    /*es: View.OnCreateContextMenuListener*/ {

        /*
        Si son privadas no son accesibles en onBindViewHolder
        y no se podran usar.
        */
        var imagen: ImageView
        var titulo: TextView
        var autor: TextView
        var precio: TextView

        init {

            titulo = itemView.findViewById(R.id.tvTitulo)
            imagen = itemView.findViewById(R.id.ivImagen)
            autor = itemView.findViewById(R.id.tvAutor)
            precio = itemView.findViewById(R.id.tvPrecio)
        }

        fun bindTarjeta(item: ItemBooks) = with(itemView) {
            titulo.setText(item.titulo)
            imagen.setImageResource(item.imagen)
            autor.setText(item.autor)
            precio.setText(item.precio)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_book, viewGroup, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: ItemViewHolder, pos: Int) {
        val ItemBooks= listaItems.get(pos)
        viewHolder.bindTarjeta(ItemBooks)

    }

    override fun getItemCount(): Int {
        return listaItems.size
    }

}