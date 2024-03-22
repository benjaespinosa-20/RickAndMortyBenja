package com.example.rickandmortybenja.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.rickandmortybenja.domain.model.DetailCharacter
import com.example.rickandmortybenja.ui.detail.components.CharacterImage
import com.example.rickandmortybenja.ui.detail.components.mirroringBackIcon

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    upPress: () -> Unit
) {
    val state = viewModel.state
    DetailContent(
        character = state.character,
        upPress = upPress
    )
}

@Composable
private fun DetailContent(
    modifier: Modifier = Modifier,
    character: DetailCharacter?,
    upPress: () -> Unit
) {
    Box(modifier.fillMaxSize()) {
        Column {
            Header(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp),
                character = character
            )
            Body(character = character)
        }
        Up(upPress)
    }
}

@Composable
private fun Header(
    modifier: Modifier = Modifier,
    character: DetailCharacter?
) {
    Column(
        modifier = modifier.background(Color(0xffffe0b2)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CharacterImage(image = character?.image)
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = character?.gender ?: "",
            color = Color.White
        )
    }
}

@Composable
private fun Body(character: DetailCharacter?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        DetailProperty(label = stringResource(R.string.specie), value = character?.species, imageVector = Icons.Filled.EmojiPeople)
        DetailProperty(label = stringResource(R.string.status), value = character?.status, imageVector = Icons.Outlined.Help)
        DetailProperty(label = stringResource(R.string.gender), value = character?.gender, imageVector = Icons.Outlined.SafetyDivider)
        DetailProperty(label = stringResource(R.string.first_location), value = character?.origin?.name, imageVector = Icons.Outlined.Visibility)
        DetailProperty(label = stringResource(R.string.last_location), value = character?.location?.name, imageVector = Icons.Outlined.LocationOn)
    }
}

@Composable
private fun Up(upPress: () -> Unit) {
    IconButton(
        onClick = upPress,
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 10.dp)
            .size(36.dp)
    ) {
        Icon(
            imageVector = mirroringBackIcon(),
            tint = Color(0xffffffff),
            contentDescription = null
        )
    }
}