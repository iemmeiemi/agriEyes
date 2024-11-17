package com.example.agrieyes.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SpacerCustom(value: Int) {
    Spacer(modifier = Modifier.height(value.dp))  // Correct usage of dp
}

@Composable
fun SpacerCustomW(value: Int) {
    Spacer(modifier = Modifier.width(value.dp))  // Correct usage of dp
}

