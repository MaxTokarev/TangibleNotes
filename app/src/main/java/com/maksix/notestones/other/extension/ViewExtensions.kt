package ru.datumgroup.smartlighting.other.extension

import android.view.View
import android.widget.AdapterView
import android.widget.Spinner

fun Spinner.onItemSelected(listener: (value: Any) -> Unit) {
    onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            listener(getItemAtPosition(position))
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {}
    }
}

fun Spinner.onItemSelectedPosition(listener: (value: Int) -> Unit) {
    onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            listener(position)
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {}

    }
}