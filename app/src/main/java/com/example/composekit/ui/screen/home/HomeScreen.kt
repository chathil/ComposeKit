package com.example.composekit.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.composekit.R
import com.example.composekit.data.source.domain.PetModel
import com.example.composekit.ui.component.InsetAwareTopAppBar
import com.example.composekit.ui.theme.Shapes

enum class HomeViewComponent {
    PET_LIST
}

@Composable
fun HomeScreen(
    /** for now this doesn't work, it might work after an update to Hilt */
//    viewModel: HomeViewModel = viewModel()
    viewModel: HomeViewModel
) {
    Scaffold(
        scaffoldState = rememberScaffoldState(),
        topBar = {
            val title = stringResource(id = R.string.app_name)
            InsetAwareTopAppBar(
                title = { Text(text = title) },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Rounded.Person,
                            contentDescription = stringResource(R.string.user)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        val pets by viewModel.pets.collectAsState(listOf())
        LazyColumn(
            modifier = Modifier
                .fillMaxSize().padding(innerPadding)
        ) {
            item {
                Spacer(Modifier.padding(16.dp))
            }
            items(pets.size, { pets[it].id }) { index ->
                PetRow(
                    pet = pets[index],
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
            item {
                Spacer(Modifier.padding(64.dp))
            }
        }
    }
}

@Composable
fun PetRow(modifier: Modifier = Modifier, pet: PetModel) {
    Surface(
        color = MaterialTheme.colors.primary.copy(.10f),
        shape = Shapes.medium,
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(pet.name)
            PetType(pet.type)
        }
    }
}

@Composable
fun PetType(type: String) {
    Surface(color = MaterialTheme.colors.primaryVariant, shape = Shapes.small) {
        Text(type, modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp))
    }
}
