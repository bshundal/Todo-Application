package com.rammu.todo.uicomponent

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Composable
fun TodoAppTextView(txt: String, color: Color= Color.Black, textStyle: TextStyle= MaterialTheme.typography.titleMedium){
    Text(text = txt,
        color=color,
        style=textStyle)
}