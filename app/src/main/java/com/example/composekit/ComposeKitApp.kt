package com.example.composekit

import androidx.compose.runtime.Composable
import com.example.composekit.ui.theme.ComposeKitTheme
import com.google.accompanist.insets.ProvideWindowInsets

@Composable
fun ComposeKitApp(
    /** if you have a welcome screen that only open once, this decide to show it or not, */
//  showWelcomeInitially: Boolean,
    /** and call this when welcome is showing */
//    welcomeShown: () -> Unit,
    finishActivity: () -> Unit,
) {
    ProvideWindowInsets {
        ComposeKitTheme {
            NavGraph(finishActivity = finishActivity)
        }
    }
}
