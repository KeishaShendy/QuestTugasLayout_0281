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