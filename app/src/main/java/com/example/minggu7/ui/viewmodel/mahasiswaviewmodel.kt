package com.example.minggu7.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.minggu7.model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class mahasiswaviewmodel : ViewModel() {

    private val mahasiswaStateUI =
        MutableStateFlow(Mahasiswa())

    val mahasiswaUiState:
            StateFlow<Mahasiswa> =
        mahasiswaStateUI.asStateFlow()

    fun saveDataMahasiswa(ls: MutableList<String>){
        mahasiswaStateUI.update{ statusSaatIni ->
            statusSaatIni.copy(
                nim = ls[0],
                nama = ls[1],
                email =  ls[2]
            )
        }
    }
}