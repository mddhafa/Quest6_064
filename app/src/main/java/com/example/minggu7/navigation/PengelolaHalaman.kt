package com.example.minggu7.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.minggu7.model.Mahasiswa
import com.example.minggu7.model.RencanaStudy
//import com.example.minggu7.model.mahasiswa
import com.example.minggu7.ui.screen.MahasiswaFormView
import com.example.minggu7.ui.screen.RencanaStudyView
import com.example.minggu7.ui.screen.SplashView
import com.example.minggu7.ui.screen.TampilanDataView
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
    mahasiswaviewmodel: mahasiswaviewmodel = viewModel (),
    RencanaStudyViewModel: RencanaStudyViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){
    val mahasiswaUiState = mahasiswaviewmodel.mahasiswaUiState.collectAsState().value
    val krsStateUi = RencanaStudyViewModel.krsStateUi.collectAsState().value
    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = Modifier.padding()
    ){
        composable(route = Halaman.Splash.name) {
            SplashView(onMulaiButton = {
                navController.navigate(
                    Halaman.Mahasiswa.name
                )
            })
        }
        composable(route = Halaman.Mahasiswa.name) {
            MahasiswaFormView (
                onSubmitButtonClicked = {
                    mahasiswaviewmodel.saveDataMahasiswa(it)
                    navController.navigate(Halaman.Matakuliah.name)
                },
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = Halaman.Matakuliah.name) {
            RencanaStudyView(
                mahasiswa = mahasiswaUiState,
                onSubmitButtonClicked = { RencanaStudyViewModel.saveDataKRS(it)
                        navController.navigate(Halaman.Tampil.name)
                                        },
                onBackButtonClicked = {navController.popBackStack()}
            )
        }
        composable(route = Halaman.Tampil.name) {
            TampilanDataView(
                mahasiswa = mahasiswaUiState,
                RencanaStudy = krsStateUi,
                onBackButtonClicked = {
                    navController.navigate(Halaman.Splash.name) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }
    }
}