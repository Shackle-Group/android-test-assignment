package com.adrianczuczka.features.search.content

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun AmountTextField(
    amount: Int,
    onAmountChange: (amount: Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    var text by remember(amount) { mutableStateOf(amount.toString()) }
    TextField(
        value = text,
        onValueChange = { raw ->
            text = raw
            val parsed = (raw.toIntOrNull() ?: 0).coerceIn(0, 99)
            onAmountChange(parsed)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        singleLine = true,
    )
}