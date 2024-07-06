package com.example.docreserva.ui.theme.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.docreserva.R

class RegisterActivity : ComponentActivity() {

    companion object {
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, RegisterActivity::class.java)
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
                RegisterUI(this)

            }
        }

    }

    @Composable
    fun RegisterUI(context: Context) {

        val boldFontFamily = FontFamily(Font(R.font.montserrat_bold))
        val mediumFontFamily = FontFamily(Font(R.font.montserrat_medium))
        val email = remember { mutableStateOf(TextFieldValue()) }
        val userName = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf(TextFieldValue()) }
        val comfirmPassowrd = remember { mutableStateOf(TextFieldValue()) }
        val phoneNumber = remember { mutableStateOf(TextFieldValue()) }
        val themeColor = colorResource(id = R.color.app_theme_color)
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())

        )
        {
            Image(
                painter = painterResource(id = R.drawable.app_logo_green),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 110.dp)

            )
            Text(
                text = "Sign Up",
                modifier = Modifier.padding(start = 20.dp, top = 50.dp),
                style = TextStyle(
                    fontFamily = boldFontFamily,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.app_theme_color)
                )
            )
            RoundedTextField(userName, false, "Create UserName", KeyboardType.Text)
            RoundedTextField(phoneNumber, false, "Enter phone number", KeyboardType.Number)
            RoundedTextField(email, false, "Enter email address", KeyboardType.Text)
            RoundedTextField(password, true, "Enter password", KeyboardType.Text)
            RoundedTextField(comfirmPassowrd, true, "Re-enter password", KeyboardType.Text)
            SignInButton(userName, phoneNumber, email, password, comfirmPassowrd, context)
            ConnectWith()
            SocialMediaIcons()
            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    text = "already have account", modifier = Modifier, style = TextStyle(
                        fontFamily = mediumFontFamily,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = themeColor
                    )
                )
                Text(
                    text = "Login",
                    modifier = Modifier
                        .padding(start = 2.dp, bottom = 50.dp)
                        .clickable { finish() },
                    style = TextStyle(
                        fontFamily = boldFontFamily,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = themeColor
                    )
                )
            }

        }

    }
}


@Composable
fun SignInButton(
    userName: MutableState<TextFieldValue>,
    phoneNumber: MutableState<TextFieldValue>,
    email: MutableState<TextFieldValue>,
    password: MutableState<TextFieldValue>,
    comfirmPassowrd: MutableState<TextFieldValue>,
    context: Context
) {
    val themeColor = colorResource(id = R.color.app_theme_color)
    Button(
        onClick = {
            if (userName.value.text.isEmpty()) {
                showToast("enter username", context)
                return@Button
            } else if (phoneNumber.value.text.isEmpty()) {
                showToast("enter phoneNumber", context)
                return@Button
            } else if (email.value.text.isEmpty()) {
                showToast("enter email address", context)
                return@Button
            } else if (password.value.text.isEmpty()) {
                showToast("enter password", context)
                return@Button
            } else if (comfirmPassowrd.value.text.isEmpty()) {
                showToast("confirm password", context)
                return@Button
            } else if (password.value.text != comfirmPassowrd.value.text) {
                showToast("Passwords do not match. Please try again.", context)
                return@Button
            } else {

                OtpVerificationActivity.start(context)
            }
        }, colors = ButtonDefaults.buttonColors(containerColor = themeColor), modifier = Modifier

            .padding(
                paddingValues = PaddingValues(start = 20.dp, end = 20.dp, top = 30.dp)
            )
            .fillMaxWidth()

    ) {
        Text(text = "Sign in", modifier = Modifier.padding(vertical = 5.dp))
    }
}