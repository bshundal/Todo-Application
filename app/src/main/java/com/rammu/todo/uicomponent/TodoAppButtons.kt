package com.rammu.todo.uicomponent

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rammu.todo.R

@Composable
fun TodoAppButton(btnTxt: String, modifier: Modifier= Modifier, onClick:()-> Unit){
    Button(colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.button_color)),
         modifier = modifier.padding(top = 24.dp, start = 36.dp, end = 36.dp, bottom = 16.dp)
        .fillMaxWidth()
        .height(56.dp),
        shape = RoundedCornerShape(50.dp),onClick = onClick) {
        TodoAppTextView(txt=btnTxt, color = colorResource(R.color.white))
    }
}

@Composable
@Preview
fun ButtonPreview(){
    TodoAppButton(btnTxt = "Login") { }
}