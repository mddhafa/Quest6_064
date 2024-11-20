package com.example.minggu7.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.minggu7.model.mahasiswa
import kotlinx.coroutines.flow.StateFlow

class mahasiswaviewmodel : ViewModel() {

    //r
    private val mahasiswaStateUI =
        mutableStateFlow(mahasiswa())

    val mahasiswaUiState:
            StateFlow<mahasiswa> =
        mahasiswaStateUI.asStateFlow()

    fun saveDataMahasiswa(ls: MutableList<String>){
        mahasiswaStateUI.update { statusSaatIni ->
            statusSaatIni.copy(
                nim = ls[0],
                nama = ls[1],
                email =  ls[2]
            )
        }
    }
}