package com.curidev.moviecompose.shared.ui

import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(text: String, onclick: () -> Unit) {
    Button(
        modifier = Modifier.width(200.dp),
        onClick = { onclick() }) {
        Text(text = text)
    }
}