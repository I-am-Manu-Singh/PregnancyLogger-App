package com.example.janitripregnancyassignment.ui

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.janitripregnancyassignment.db.VitalsDatabase
import com.example.janitripregnancyassignment.db.VitalsRepository
import com.example.janitripregnancyassignment.vm.VitalsViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import com.example.janitripregnancyassignment.R
import com.example.janitripregnancyassignment.vm.VitalsViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable

fun MainScreen(application: Application) {
    val database = remember { VitalsDatabase.getDatabase(application) }
    val repository = remember { VitalsRepository(database.vitalsDao()) }

    val viewModel: VitalsViewModel = remember {
        ViewModelProvider(ViewModelStore(), VitalsViewModelFactory(repository))[VitalsViewModel::class.java]
    }

    val vitalsList by viewModel.vitalsList.collectAsState()

    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog = true },
                containerColor = Color(0xFF6A1B9A),
                contentColor = Color.White
            )
            {
                VitalsRow2(painterResource(id = R.drawable.add))
            }
        }
    ) {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            Text(
                text = "Pregnancy Vitals Tracker",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6A1B9A)
            )

            LazyColumn {
                items(vitalsList, key = { it.id }) { vitals ->
                    VitalsCard(vitals, onDelete = { viewModel.deleteVitals(vitals) })
                }
            }
        }
    }

    if (showDialog) {
        AddVitalsDialog(onDismiss = {
            showDialog = false
        }) { systolic, diastolic, heartRate, weight, babyKicks ->
            viewModel.addVitals(systolic, diastolic, heartRate, weight, babyKicks)
            showDialog = false
        }
    }
}

@Composable
fun VitalsRow2(icon: Painter) {
        Icon(painter = icon, contentDescription = null, modifier = Modifier.size(24.dp))
}