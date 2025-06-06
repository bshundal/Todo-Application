package com.rammu.todo.uicomponent

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun TodoAppSpacer(space: Dp){
    Spacer(modifier = Modifier.size(space))
}