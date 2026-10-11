package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class StudentData(
    val name: String,
    val nim: String,
    val location: String,
    val cardColorRes: Int
)

@Composable
fun AktivitasPertama(modifier: Modifier) {
    // Menyiapkan data
    val listMahasiswa = listOf(
        StudentData(
            name = stringResource(id = R.string.mhs1_name),
            nim = stringResource(id = R.string.mhs1_nim),
            location = stringResource(id = R.string.mhs1_loc),
            cardColorRes = R.color.card_gray
        ),
        StudentData(
            name = stringResource(id = R.string.mhs2_name),
            nim = stringResource(id = R.string.mhs2_nim),
            location = stringResource(id = R.string.mhs2_loc),
            cardColorRes = R.color.card_purple
        ),
        StudentData(
            name = stringResource(id = R.string.mhs3_name),
            nim = stringResource(id = R.string.mhs3_nim),
            location = stringResource(id = R.string.mhs3_loc),
            cardColorRes = R.color.card_blue
        ),
        StudentData(
            name = stringResource(id = R.string.mhs4_name),
            nim = stringResource(id = R.string.mhs4_nim),
            location = stringResource(id = R.string.mhs4_loc),
            cardColorRes = R.color.card_green
        )
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // --- HEADER ---
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = stringResource(id = R.string.header_title),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.black),
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(id = R.string.header_subtitle),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.black),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(24.dp))

        // --- LIST OF CARDS ---
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(listMahasiswa) { mahasiswa ->
                // Memanggil fungsi Card di bawah
                MahasiswaCard(mahasiswa = mahasiswa)
            }
        }

        // --- FOOTER ---
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = R.string.footer_text),
            fontSize = 12.sp,
            color = colorResource(id = R.color.black),
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}

@Composable
fun MahasiswaCard(mahasiswa: StudentData) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = mahasiswa.cardColorRes)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Logo Kiri
            Image(
                painter = painterResource(id = R.drawable.logo_umy),
                contentDescription = stringResource(id = R.string.logo_desc),
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            // Teks Tengah
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = mahasiswa.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.white)
                )
                Text(
                    text = mahasiswa.nim,
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.text_secondary)
                )
                Text(
                    text = mahasiswa.location,
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.text_secondary)
                )
            }

            // Logo Kanan
            Image(
                painter = painterResource(id = R.drawable.logo_umy),
                contentDescription = stringResource(id = R.string.logo_desc),
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }
    }
}