package com.pypl.kotlintraining

import android.util.Log
import java.lang.StringBuilder

/**
 * TODO: Write Javadoc for Logger.
 *
 * @author arunarumugam
 */
class Logger {
    companion object {
        public fun log(tag: String, message: String) {
            Log.d(tag, message)
        }
    }
}
