package br.com.rstduio.codelab4.app.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import br.com.rstduio.codelab4.app.R

val provider = GoogleFont.Provider(
  providerAuthority = "com.google.android.gms.fonts",
  providerPackage = "com.google.android.gms",
  certificates = R.array.com_google_android_gms_fonts_certs
)

val bodyFontFamily = FontFamily(
  Font(
    googleFont = GoogleFont("Roboto Mono"),
    fontProvider = provider,
  )
)

val displayFontFamily = FontFamily(
  Font(
    googleFont = GoogleFont("Roboto Mono"),
    fontProvider = provider,
  )
)

// Default Material 3 typography values
val baseline = Typography()

val AppTypography = Typography(
  displayLarge = baseline.displayLarge.copy(fontFamily = displayFontFamily),
  displayMedium = baseline.displayMedium.copy(fontFamily = displayFontFamily),
  displaySmall = baseline.displaySmall.copy(fontFamily = displayFontFamily),
  headlineLarge = baseline.headlineLarge.copy(fontFamily = displayFontFamily),
  headlineMedium = baseline.headlineMedium.copy(fontFamily = displayFontFamily),
  headlineSmall = TextStyle(
    fontWeight = FontWeight.SemiBold,
    fontSize = 24.sp,
    lineHeight = 32.sp,
    letterSpacing = 0.sp
  ),
  titleLarge = TextStyle(
    fontWeight = FontWeight.SemiBold,
    fontSize = 18.sp,
    lineHeight = 32.sp,
    letterSpacing = 0.sp
  ),
  titleMedium = baseline.titleMedium.copy(fontFamily = displayFontFamily),
  titleSmall = baseline.titleSmall.copy(fontFamily = displayFontFamily),
  bodyLarge = TextStyle(
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.15.sp
  ),
  bodyMedium = TextStyle(
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    lineHeight = 20.sp,
    letterSpacing = 0.25.sp
  ),
  bodySmall = baseline.bodySmall.copy(fontFamily = bodyFontFamily),
  labelLarge = baseline.labelLarge.copy(fontFamily = bodyFontFamily),
  labelMedium = TextStyle(
    fontWeight = FontWeight.SemiBold,
    fontSize = 12.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.5.sp
  ),
  labelSmall = baseline.labelSmall.copy(fontFamily = bodyFontFamily),
)
