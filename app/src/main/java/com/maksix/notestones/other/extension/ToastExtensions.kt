package com.maksix.notestones.other.extension

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.toast(
    message: Any,
    duration: Int = Toast.LENGTH_SHORT
) = context?.toast(message, duration)

fun View.toast(
    message: Any,
    duration: Int = Toast.LENGTH_SHORT
) = context?.toast(message, duration)

fun Context.toast(message: Any, duration: Int = Toast.LENGTH_SHORT) {
    when (message) {
        is String -> {
            if (message.isNotEmpty())
                Toast.makeText(this, message, duration).show()
        }
        is Int -> if (message > 0) {
            Toast.makeText(this, message, duration).show()
        }
    }
}
