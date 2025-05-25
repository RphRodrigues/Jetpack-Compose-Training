package br.com.rstudio.codelab2.feature

import androidx.activity.compose.BackHandler
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rstudio.designsystem.ui.theme.DesignSystemTheme
import kotlin.Int
import kotlin.Pair

@Composable
fun Codelab2Feature(
  size: WindowWidthSizeClass,
  modifier: Modifier = Modifier,
  closeCodelab2: () -> Unit = {}
) {
  BackHandler {
    closeCodelab2()
  }
  when (size) {
    WindowWidthSizeClass.Compact -> MyAppPortrait(modifier)
    else -> MyAppLandscape(modifier)
  }
}

@Composable
fun MyAppPortrait(modifier: Modifier = Modifier) {
  Scaffold(
    bottomBar = { AppBottomNavigation(modifier) }
  ) { padding ->
    MyApp(modifier.padding(padding))
  }
}

@Composable
fun MyAppLandscape(modifier: Modifier = Modifier) {
  Surface(color = MaterialTheme.colorScheme.background) {
    Row {
      AppBottomNavigationRail(modifier)
      MyApp(modifier)
    }
  }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
  val alignYourBodyItems = listOf<Pair<Int, Int>>(
    R.drawable.ab1_inversions to R.string.ab1_inversions,
    R.drawable.ab2_quick_yoga to R.string.ab2_quick_yoga,
    R.drawable.ab3_stretching to R.string.ab3_stretching,
    R.drawable.ab4_tabata to R.string.ab4_tabata,
    R.drawable.ab5_hiit to R.string.ab5_hiit,
    R.drawable.ab6_pre_natal_yoga to R.string.ab6_pre_natal_yoga
  )

  val favoriteCollectionItems = listOf<Pair<Int, Int>>(
    R.drawable.fc1_short_mantras to R.string.fc1_short_mantras,
    R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
    R.drawable.fc3_stress_and_anxiety to R.string.fc3_stress_and_anxiety,
    R.drawable.fc4_self_massage to R.string.fc4_self_massage,
    R.drawable.fc5_overwhelmed to R.string.fc5_overwhelmed,
    R.drawable.fc6_nightly_wind_down to R.string.fc6_nightly_wind_down
  )

  Column(
    modifier
      .fillMaxSize()
      .verticalScroll(rememberScrollState())
  ) {
    SearchBar()
    HomeSection(
      title = R.string.align_your_body,
      modifier = modifier
    ) {
      LazyRow(
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        items(items = alignYourBodyItems) { item ->
          AlignYourBodyElement(item.first, item.second)
        }
      }
    }
    HomeSection(
      title = R.string.favorite_collections,
      modifier = modifier
    ) {
      LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
          .height(168.dp)
          .padding(bottom = 20.dp)
      ) {
        items(favoriteCollectionItems) { item ->
          FavoriteCollectionCard(item.first, item.second)
        }
      }
    }
  }
}

@Composable
fun AppBottomNavigation(modifier: Modifier = Modifier) {
  NavigationBar(
    containerColor = MaterialTheme.colorScheme.surfaceVariant,
    modifier = modifier
  ) {
    NavigationBarItem(
      icon = {
        Icon(
          imageVector = Icons.Default.Face,
          contentDescription = null
        )
      },
      label = {
        Text(text = stringResource(R.string.bottom_navigation_home))
      },
      selected = true,
      onClick = {}
    )
    NavigationBarItem(
      icon = {
        Icon(
          imageVector = Icons.Default.AccountCircle,
          contentDescription = null
        )
      },
      label = {
        Text(text = stringResource(R.string.bottom_navigation_profile))
      },
      selected = false,
      onClick = {}
    )
  }
}

@Composable
fun AppBottomNavigationRail(modifier: Modifier = Modifier) {
  NavigationRail(
    containerColor = MaterialTheme.colorScheme.surfaceVariant,
    modifier = modifier
  ) {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center,
      modifier = modifier.fillMaxHeight()
    ) {
      NavigationRailItem(
        icon = {
          Icon(
            imageVector = Icons.Default.Face,
            contentDescription = null
          )
        },
        label = {
          Text(text = stringResource(R.string.bottom_navigation_home))
        },
        selected = true,
        onClick = {}
      )
      Spacer(Modifier.height(8.dp))
      NavigationRailItem(
        icon = {
          Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = null
          )
        },
        label = {
          Text(text = stringResource(R.string.bottom_navigation_profile))
        },
        selected = false,
        onClick = {}
      )
    }
  }
}

@Composable
fun HomeSection(
  @StringRes title: Int,
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit
) {
  Column {
    Text(
      text = stringResource(title),
      style = MaterialTheme.typography.titleMedium,
      modifier = Modifier
        .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
        .padding(horizontal = 16.dp)
    )
    content()
  }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
  TextField(
    value = "",
    leadingIcon = {
      Icon(
        imageVector = Icons.Default.Search,
        contentDescription = null,
      )
    },
    colors = TextFieldDefaults.colors(
      focusedContainerColor = MaterialTheme.colorScheme.surface,
      unfocusedContainerColor = MaterialTheme.colorScheme.surface
    ),
    placeholder = {
      Text("Search")
    },
    onValueChange = {},
    modifier = modifier
      .padding(16.dp)
      .heightIn(min = 56.dp)
      .fillMaxWidth()
  )
}

@Composable
fun AlignYourBodyElement(
  @DrawableRes imageId: Int,
  @StringRes stringId: Int,
  modifier: Modifier = Modifier
) {
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = modifier
  ) {
    Image(
      painter = painterResource(imageId),
      contentDescription = null,
      contentScale = ContentScale.Crop,
      modifier = modifier
        .size(88.dp)
        .clip(CircleShape)
    )
    Text(
      text = stringResource(stringId),
      style = MaterialTheme.typography.bodyMedium,
      modifier = modifier
        .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
    )
  }
}

@Composable
fun FavoriteCollectionCard(
  @DrawableRes imageId: Int,
  @StringRes stringId: Int,
  modifier: Modifier = Modifier
) {
  Surface(
    shape = MaterialTheme.shapes.medium,
    color = MaterialTheme.colorScheme.surfaceVariant,
    modifier = modifier.height(80.dp)
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = modifier.width(255.dp)
    ) {
      Image(
        painter = painterResource(imageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier.size(80.dp)
      )
      Text(
        text = stringResource(stringId),
        style = MaterialTheme.typography.titleMedium,
        modifier = modifier.padding(horizontal = 16.dp)
      )
    }
  }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun GreetingPreview() {
  DesignSystemTheme {
    MyAppPortrait()
  }
}

/*
* Os modificadores são usados para:
* Mudar o tamanho, o layout, o comportamento e a aparência da função.
* Adicionar informações, como rótulos de acessibilidade.
* Processar entradas do usuário.
* Adicionar interações de nível superior, como fazer com que um elemento seja clicável, rolável, arrastável ou redimensionável.
*
* */