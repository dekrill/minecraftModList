package omstu.pin252t.ryazanov.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import omstu.pin252t.ryazanov.model.Mod

@Composable
fun ModIcon(
    mod: Mod,
    modifier: Modifier = Modifier,
    size: Dp = 48.dp
) {
    val initial = mod.title.firstOrNull()?.uppercaseChar()?.toString() ?: "M"

    Box(
        modifier = modifier
            .size(size)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = initial,
            style = MaterialTheme.typography.titleMedium.copy(
                fontSize = (size.value * 0.45).sp
            ),
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )

        AsyncImage(
            model = mod.iconUrl,
            contentDescription = mod.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}
