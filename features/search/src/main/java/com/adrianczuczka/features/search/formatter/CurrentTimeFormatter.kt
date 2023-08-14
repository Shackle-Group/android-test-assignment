package com.adrianczuczka.features.search.formatter

import java.util.Date
import javax.inject.Inject

class CurrentTimeFormatter @Inject constructor() {
    operator fun invoke() = Date().time
}