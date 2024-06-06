package com.example.docreserva.ui.theme.activity


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.docreserva.R

class OtpVerificationActivity : ComponentActivity() {

    companion object {
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, OtpVerificationActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(), color = Color.White
            ) {
                OtpView(this)

            }
        }

    }

    @Composable
    private fun OtpView(otpVerificationActivity: OtpVerificationActivity) {
        val themeColor = colorResource(id = R.color.app_theme_color)
        val gray = colorResource(id = R.color.gray)
        val boldFontFamily = FontFamily(Font(R.font.montserrat_bold))
        val mediumFontFamily = FontFamily(Font(R.font.montserrat_medium))
        Column {
            Image(
                painter = painterResource(id = R.drawable.app_logo_green),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 110.dp)

            )
            Image(
                painter = painterResource(id = R.drawable.otp_screen_image),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 50.dp)
            )
            Text(
                text = "OTP verification",
                style = TextStyle(
                    color = themeColor,
                    fontFamily = boldFontFamily,
                    fontSize = 20.sp
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 30.dp)

            )
            Text(
                text = "we send a OTP on your registered number",
                style = TextStyle(color = gray, fontFamily = mediumFontFamily, fontSize = 17.sp),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 50.dp)
                    .padding(top = 20.dp),
                textAlign = TextAlign.Center

            )
            OtpTextField()
        }

    }

    @Composable
    fun OtpTextField() {
        val themeColor = colorResource(id = R.color.app_theme_color)
        var otpText by remember {
            mutableStateOf("")
        }
        BasicTextField(
            value = otpText,
            onValueChange = { otpText = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp, top = 50.dp, end = 25.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(10.dp)

            ) {

                repeat(6) { index ->
                    val isFocused = index == otpText.length
                    val borderColor = if (isFocused) themeColor else Color.Gray
                    val number = when {
                        index >= otpText.length -> '-'
                        else -> otpText[index]
                    }
                    Column(
                        modifier = Modifier
                            .width(40.dp)
                            .height(45.dp)
                            .border(
                                width = 1.dp,
                                color = borderColor,
                                shape = RoundedCornerShape(10.dp)
                            ),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = number.toString(),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }

}