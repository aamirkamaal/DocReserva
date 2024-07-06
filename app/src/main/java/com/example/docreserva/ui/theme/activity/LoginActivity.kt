package com.example.docreserva.ui.theme.activity


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.docreserva.R
import com.example.docreserva.ui.theme.fragment.HomeFragment

class LoginActivity : ComponentActivity() {

    companion object {
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, LoginActivity::class.java)
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
                loginView(this)

            }
        }

    }
}

@Composable
fun loginView(context: Context) {
    val boldFontFamily = FontFamily(Font(R.font.montserrat_bold))
    val mediumFontFamily = FontFamily(Font(R.font.montserrat_medium))
    val email = remember { mutableStateOf(TextFieldValue()) }
    val password = remember { mutableStateOf(TextFieldValue()) }
    val themeColor = colorResource(id = R.color.app_theme_color)
    Column {
        Image(
            painter = painterResource(id = R.drawable.app_logo_green),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 110.dp)

        )
        Text(
            text = "Sign in",
            modifier = Modifier.padding(start = 20.dp, top = 50.dp),
            style = TextStyle(
                fontFamily = boldFontFamily,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.app_theme_color)
            )
        )
        RoundedTextField(email, false, "enter email address", KeyboardType.Text)
        RoundedTextField(password, true, "enter password", KeyboardType.Text)
        Text(
            text = "Forger password?",
            modifier = Modifier
                .padding(end = 20.dp, top = 20.dp)
                .align(Alignment.End),
            style = TextStyle(
                fontFamily = mediumFontFamily,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = R.color.black)
            )
        )
        SignUpButton(email, password, context = context)
        ConnectWith()
        SocialMediaIcons()
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(
                text = "don't have an account", modifier = Modifier, style = TextStyle(
                    fontFamily = mediumFontFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = themeColor
                )
            )
            Text(
                text = "Register",
                modifier = Modifier
                    .padding(start = 2.dp)
                    .clickable { RegisterActivity.start(context) },
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoundedTextField(
    email: MutableState<TextFieldValue>,
    isPassword: Boolean,
    hintText: String,
    textType: KeyboardType
) {

    val themeColor = colorResource(id = R.color.app_theme_color)

    val customFontFamily = FontFamily(
        Font(R.font.montserrat_medium, FontWeight.Normal)
    )

    OutlinedTextField(
        keyboardOptions = KeyboardOptions(keyboardType = textType),
        value = email.value,
        onValueChange = { email.value = it },
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 20.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = themeColor,
            unfocusedBorderColor = themeColor,
            cursorColor = themeColor,
            focusedTextColor = themeColor
        ),
        placeholder = {
            Text(
                text = hintText, color = Color.LightGray, fontFamily = customFontFamily
            )
        },
        textStyle = TextStyle(
            fontSize = 18.sp, color = themeColor, fontFamily = customFontFamily
        ),
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None
    )
}

fun showToast(msg: String, context: Context) {
    Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
}

@Composable
fun SignUpButton(
    email: MutableState<TextFieldValue>, password: MutableState<TextFieldValue>, context: Context
) {
    val themeColor = colorResource(id = R.color.app_theme_color)
    Button(
        onClick = {
            if (email.value.text.isEmpty()) {
                showToast("enter email address", context)
                return@Button
            } else if (password.value.text.isEmpty()) {
                showToast("enter password", context)
                return@Button
            } else {
                showToast("User Login", context)
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

@Composable
fun ConnectWith() {
    val themeColor = colorResource(id = R.color.app_theme_color)
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 40.dp, bottom = 10.dp)
    ) {
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .weight(1f)
                .background(themeColor)
        )
        Text(
            text = "connect with",
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .weight(1f)
                .background(themeColor)
        )
    }
}

@Composable
fun SocialMediaIcons() {
    Row(
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center,

        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.google_plus),
            contentDescription = "Google Plus",
            modifier = Modifier
                .size(48.dp)
                .padding(8.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.facebook_iconpng),
            contentDescription = "Facebook",
            modifier = Modifier
                .size(48.dp)
                .padding(8.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.twitter),
            contentDescription = "Twitter",
            modifier = Modifier
                .size(48.dp)
                .padding(8.dp)
        )

    }
}
