package com.example.minggu7.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
//import androidx.navigation.NavHostController
import com.example.minggu7.ui.viewmodel.RencanaStudyViewModel
import com.example.minggu7.ui.viewmodel.mahasiswaviewmodel

enum class Halaman{
    Splash,
    Mahasiswa,
    Matakuliah,
    Tampil
}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    mahasiswaviewmodel: mahasiswaviewmodel = viewmodel (),
    krsViewModel: RencanaStudyViewModel = viewmodel(),
    navController: NavHostController = rememberNavController()
){
    val mahasiswauiState = mahasiswaviewmodel.mahasiswaUiState.collectAsState().value
    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = Modifier.padding()
    ){

    }
}