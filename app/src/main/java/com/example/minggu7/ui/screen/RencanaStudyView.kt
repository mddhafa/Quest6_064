package com.example.minggu7.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.minggu7.model.RencanaStudy
import com.example.minggu7.model.mahasiswa

@Composable
fun RencanaStudyView(
    mahasiswa: mahasiswa,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    onBackButtonClicked : () -> Unit
){
    var chosenDropdown by remember {
        mutableStateOf("")
    }
    var checked by remember { mutableStateOf(false) }
    var pilihKelas by remember {
        mutableStateOf("")
    }
}