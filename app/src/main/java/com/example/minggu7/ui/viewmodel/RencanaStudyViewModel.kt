package com.example.minggu7.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.minggu7.model.RencanaStudy
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RencanaStudyViewModel : ViewModel() {
    private val krsState = MutableStateFlow(RencanaStudy())
    val krsStateUi: StateFlow<RencanaStudy> = krsState.asStateFlow()

    fun setMataKuliah(MataKuliah: String){
        krsState.update { stateMK -> stateMK.copy(mataKuliah = MataKuliah)
        }
    }
    fun setKelas(RuangKelas: String) {
        krsState.update { stateKelas -> stateKelas.copy(kelas = RuangKelas) }
    }

    fun saveDataKRS(ls: MutableList<String>){
        krsState.update { status -> status.copy(
            mataKuliah = ls[0],
            kelas = ls[1]
        )
        }
    }
}