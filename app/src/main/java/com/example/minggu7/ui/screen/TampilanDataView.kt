package com.example.minggu7.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minggu7.R
import com.example.minggu7.model.Mahasiswa
import com.example.minggu7.model.RencanaStudy

@Composable
fun TampilanDataView(
   mahasiswa: Mahasiswa,
   RencanaStudy: RencanaStudy,
   onBackButtonClicked : () -> Unit
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = colorResource(R.color.primary)
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier= Modifier.padding(16.dp))
        Row (verticalAlignment = Alignment.CenterVertically,)
        {
            Image(
                painter = painterResource(R.drawable.umy),
                contentDescription = "",
                modifier = Modifier.size(45.dp)
            )
            Spacer(modifier = Modifier.padding(start = 16.dp))
            Column {
                Text(
                    text = mahasiswa.nama,
                    color = Color.Red,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = mahasiswa.nim,
                    color = Color.Red,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light
                )
            }
            Box{
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
        Box(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topEnd = 15.dp,
                        topStart = 15.dp
                    )
                )
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Data Diri",
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp
                )
                Text(
                    text = "Hasil Rencana Study kamu",
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Hasil(judulParam = "Nama" , isiParam = mahasiswa.nama)
                Spacer(modifier = Modifier.padding(4.dp))
                Hasil(judulParam = "NIM" , isiParam = mahasiswa.nim)
                Spacer(modifier = Modifier.padding(4.dp))
                Hasil(judulParam = "Email" , isiParam = mahasiswa.email)
                Spacer(modifier = Modifier.padding(4.dp))
                Hasil(judulParam = "Matakuliah" , isiParam = RencanaStudy.mataKuliah)
                Spacer(modifier = Modifier.padding(4.dp))
                Hasil(judulParam = "Kelas" , isiParam = RencanaStudy.kelas)
                Spacer(modifier = Modifier.padding(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = { onBackButtonClicked() }
                    ) {
                        Text("Kembali ke Halaman Utama")
                    }
                }
            }
        }
    }
}

@Composable
fun Hasil(judulParam:String, isiParam:String){
        Column {
            Row(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly

            ) {
                Text(judulParam, modifier = Modifier.weight(0.8f))
                Text(":", modifier = Modifier.weight(0.2f))
                Text(isiParam, modifier = Modifier.weight(2f))
            }
        }
}