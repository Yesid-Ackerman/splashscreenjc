package com.example.splashscreenjc.sliderexample

/*
 * Copyright 2023 El Proyecto de Código Abierto de Android
 *
 * Licenciado bajo la Licencia Apache, Versión 2.0 (la "Licencia");
 * no puedes usar este archivo excepto en cumplimiento con la Licencia.
 * Puedes obtener una copia de la Licencia en
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * A menos que lo exija la ley aplicable o se acuerde por escrito,
 * el software distribuido bajo la Licencia se distribuye en una base
 * "TAL CUAL", SIN GARANTÍAS O CONDICIONES DE NINGÚN TIPO, ya sean
 * expresas o implícitas.
 * Consulta la Licencia para obtener el lenguaje específico que regula
 * los permisos y las limitaciones bajo la Licencia.
 */

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Función para mostrar ejemplos de diferentes tipos de deslizadores
@Preview
@Composable
fun SliderExamples() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Título para el componente de deslizador minimalista
        Text("Componente de deslizador minimalista")
        SliderMinimalExample()

        // Título para el componente de deslizador avanzado
        Text("Componente de deslizador avanzado")
        SliderAdvancedExample()

        // Título para el componente de deslizador de rango
        Text("Componente de deslizador de rango")
        RangeSliderExample()
    }
}

// [INICIO android_compose_componentes_deslizadores_minimalista]
@Preview
@Composable
fun SliderMinimalExample() {
    // Estado para mantener la posición actual del deslizador
    var sliderPosition by remember { mutableFloatStateOf(0f) }

    Column {
        // Deslizador básico
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it }
        )
        // Muestra el valor actual del deslizador
        Text(text = sliderPosition.toString())
    }
}
// [FIN android_compose_componentes_deslizadores_minimalista]


// [INICIO android_compose_componentes_deslizadores_avanzado]
@Preview
@Composable
fun SliderAdvancedExample() {
    // Estado para mantener la posición actual del deslizador
    var sliderPosition by remember { mutableFloatStateOf(0f) }

    Column {
        // Deslizador avanzado con personalización
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            steps = 3,
            valueRange = 0f..50f
        )
        // Muestra el valor actual del deslizador
        Text(text = sliderPosition.toString())
    }
}
// [FIN android_compose_componentes_deslizadores_avanzado]


// [INICIO android_compose_componentes_deslizadores_rango]
@Preview
@Composable
fun RangeSliderExample() {
    // Estado para mantener el rango actual del deslizador
    var sliderPosition by remember { mutableStateOf(0f..100f) }

    Column {
        // Deslizador de rango
        RangeSlider(
            value = sliderPosition,
            steps = 5,
            onValueChange = { range -> sliderPosition = range },
            valueRange = 0f..100f,
            onValueChangeFinished = {
                // Lanza alguna lógica de negocio actualizando el estado que mantienes
                // Por ejemplo, podrías actualizar un ViewModel aquí
                // viewModel.updateSelectedSliderValue(sliderPosition)
            },
        )
        // Muestra el rango actual del deslizador
        Text(text = sliderPosition.toString())
    }
}
// [FIN android_compose_componentes_deslizadores_rango]
