package com.example.docreserva.helper

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.TextFieldValue
import com.example.docreserva.R
import com.example.docreserva.model.DocModel


@Composable
fun GetResource() {
    val themeColor = colorResource(id = R.color.app_theme_color)


}

@Composable
fun GetTopDocList(): MutableState<TextFieldValue> {
    val inputvalue = remember { mutableStateOf(TextFieldValue()) }
    val sampleItems = ArrayList<DocModel>()
    sampleItems.add(DocModel(R.drawable.general, "General"))
    sampleItems.add(DocModel(R.drawable.nepphrologist, "Nephrologist"))
    sampleItems.add(DocModel(R.drawable.cardiology, "Cardiology"))
    sampleItems.add(DocModel(R.drawable.neurologist, "Neurologist"))
    sampleItems.add(DocModel(R.drawable.dentist, "Dentist"))
    sampleItems.add(DocModel(R.drawable.gynecologist, "Gynecologist"))
    sampleItems.add(DocModel(R.drawable.pediatrician, "Pediatrician"))
    sampleItems.add(DocModel(R.drawable.surgeon, "G surgeon"))

    return inputvalue
}