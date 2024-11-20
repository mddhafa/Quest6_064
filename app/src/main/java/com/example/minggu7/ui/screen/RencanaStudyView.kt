package com.example.minggu7.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minggu7.R
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
    var listData: MutableList<String> = mutableListOf(chosenDropdown, pilihKelas)
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.primary))
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(R.drawable.umy),
                contentDescription = "",
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(50.dp)
            )
            Spacer(modifier = Modifier.padding(start = 16.dp))
            Column (modifier = Modifier.weight(1f)){
                Text(
                    text = mahasiswa.nama,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color.White
                )
                Text(
                    text = mahasiswa.nim,
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
        }
    }
}