package com.maksix.notestones.other.extension

import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun FragmentActivity.asAppCompatActivity(): AppCompatActivity{
    return (this as AppCompatActivity)
}

fun Fragment.onBackPressed() {
    requireActivity().onBackPressed()
}

fun Fragment.showToast(message: String, duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(requireContext(), message, duration).show()
}

fun Fragment.hideKeyboard() = activity?.hideKeyboard()
fun Fragment.showKeyboard(view: View) = activity?.showKeyboard(view)