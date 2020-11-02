package com.android.cryptoapp.utils

import androidx.annotation.StringRes
import com.android.cryptoapp.App

object Strings {
    fun get(@StringRes stringRes: Int, vararg formatArgs: Any = emptyArray()): String {
        return App.instance.getString(stringRes, *formatArgs)
    }
}