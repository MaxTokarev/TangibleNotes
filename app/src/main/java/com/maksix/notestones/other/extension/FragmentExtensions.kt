package com.maksix.notestones.other.extension

import android.widget.Toast
import androidx.fragment.app.Fragment


fun Fragment.onBackPressed() {
    requireActivity().onBackPressed()
}

fun Fragment.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(requireContext(), message, duration).show()
}

fun Fragment.hideKeyboard() = activity?.hideKeyboard()
